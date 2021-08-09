package com.anzexian.demo.controller;

import com.anzexian.demo.entity.InsuranceNews;
import com.anzexian.demo.service.InsuranceNewsService;
import com.anzexian.demo.util.ExportPrintUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static com.anzexian.demo.util.ExportPrintUtils.getReturnFile;

@Controller
@RequestMapping("/insuranceNews")
public class InsuranceNewsController {
    @Autowired
    private InsuranceNewsService insuranceNewsService;

//    @Autowired
//    private InsuranceApplicantService insuranceApplicantService;
//    @Autowired
//    private InsuranceInsuredService insuranceInsuredService;

    @RequestMapping("/toNewsList")
    public String toNewsList() {
        return "insurance/news_list";
    }

//    public static int getCompanyId(String companyId){
//        return 0;
//    }

    @RequestMapping("/selectLike")
    @ResponseBody
    public PageInfo selectLike(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "shortContent", required = false) String shortContent,
            @RequestParam(value = "url", required = false) String url,
            @RequestParam(value = "releaseTimeFrom", required = false) String releaseTimeFrom,
            @RequestParam(value = "releaseTimeTo", required = false) String releaseTimeTo,
            @RequestParam(value = "createTimeFrom", required = false) String createTimeFrom,
            @RequestParam(value = "createTimeTo", required = false) String createTimeTo,

            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum,
            @RequestParam(value = "orderByOne", required = false) String orderByOne,
            @RequestParam(value = "orderByTwo", required = false) String orderByTwo,
            @RequestParam(value = "orderByThree", required = false) String orderByThree
    ) {
        InsuranceNews insuranceNews = new InsuranceNews();
        try {
            insuranceNews.setTitle(title);
            insuranceNews.setShortContent(shortContent);
            insuranceNews.setUrl(url);
            if (releaseTimeFrom != null && !"".equals(releaseTimeFrom))
                insuranceNews.setReleaseTimeFrom(releaseTimeFrom + " 00:00:00");
            if (releaseTimeTo != null && !"".equals(releaseTimeTo))
                insuranceNews.setReleaseTimeTo(releaseTimeTo + " 00:00:00");
            if (createTimeFrom != null && !"".equals(createTimeFrom))
                insuranceNews.setCreateTimeFrom(createTimeFrom + " 00:00:00");
            if (createTimeTo != null && !"".equals(createTimeTo))
                insuranceNews.setCreateTimeTo(createTimeTo + " 00:00:00");
            insuranceNews.setOrderByOne(orderByOne);
            insuranceNews.setOrderByTwo(orderByTwo);
            insuranceNews.setOrderByThree(orderByThree);
        } catch (NullPointerException e) {
            System.out.println("Null pointer in selectLike in News controller");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat problem in selectLike in News controller");
            e.printStackTrace();
        } catch (DateTimeParseException e) {
            System.out.println("DateTimeParseException in add");
            e.printStackTrace();
        }
        PageInfo res = insuranceNewsService.selectLike(insuranceNews, pageNum, pageSize);
        return res;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<InsuranceNews> getAll() {
        return insuranceNewsService.getAll().getList();
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public InsuranceNews selectById(@RequestParam(value = "id") String id) {
        return insuranceNewsService.selectById(id);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam(value = "id", required = false) String id) {
        return insuranceNewsService.deleteById(id) + "";
    }

    @RequestMapping("/updateAjax")
    @ResponseBody
    public Boolean updateAjax(@RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "title", required = false) String title,
                              @RequestParam(value = "shortContent", required = false) String shortContent,
                              @RequestParam(value = "url", required = false) String url,
                              @RequestParam(value = "releaseTime", required = false) String releaseTime
    ) {
        InsuranceNews insuranceNews = new InsuranceNews();
        try {
            insuranceNews.setId(Integer.parseInt(id));
            insuranceNews.setTitle(title);
            insuranceNews.setShortContent(shortContent);
            insuranceNews.setUrl(url);
            if (releaseTime != null && !"".equals(releaseTime))
                insuranceNews.setReleaseTime(LocalDateTime.parse(releaseTime + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (DateTimeParseException e) {
            System.out.println("DateTimeParseException in add");
            e.printStackTrace();
        }
        return insuranceNewsService.updateById(insuranceNews);
    }

    @RequestMapping("/addData")
    @ResponseBody
    public Boolean addData(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "shortContent", required = false) String shortContent,
            @RequestParam(value = "url", required = false) String url,
            @RequestParam(value = "releaseTime", required = false) String releaseTime
    ) {
        InsuranceNews insuranceNews = new InsuranceNews();
        try {
            insuranceNews.setTitle(title);
            insuranceNews.setShortContent(shortContent);
            insuranceNews.setUrl(url);
            if (releaseTime != null && !"".equals(releaseTime))
                insuranceNews.setReleaseTime(LocalDateTime.parse(releaseTime + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            insuranceNews.setCreateTime(LocalDateTime.now());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (DateTimeParseException e) {
            System.out.println("DateTimeParseException in add");
            e.printStackTrace();
        }
        return insuranceNewsService.insert(insuranceNews);
    }

    @RequestMapping("/exportData")
    public ResponseEntity<byte[]> exportData() throws IOException {
        InsuranceNews insuranceNews = new InsuranceNews();
        PageInfo res = insuranceNewsService.getAll();
        String[] rowsName = new String[]{"ID", "标题", "摘要", "原文地址", "发布时间", "创建时间"};
        return getReturnFile(ExportPrintUtils.createInsuranceNewsExcel("新闻列表", rowsName, res.getList()), "新闻列表.xls");
    }
}
