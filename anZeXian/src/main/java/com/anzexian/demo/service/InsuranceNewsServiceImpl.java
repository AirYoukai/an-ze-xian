package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceNews;
import com.anzexian.demo.entity.InsuranceNewsExample;

import com.anzexian.demo.entity.InsuranceService;
import com.anzexian.demo.entity.InsuranceServiceExample;
import com.anzexian.demo.mapper.InsuranceNewsMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceNewsServiceImpl implements InsuranceNewsService {
    @Autowired
    InsuranceNewsMapper insuranceNewsMapper;

    @Override
    public PageInfo getAll() {
        InsuranceNewsExample example=new InsuranceNewsExample();
        InsuranceNewsExample.Criteria criteria=example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        List<InsuranceNews> insuranceNewsList = insuranceNewsMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(insuranceNewsList);
        return pageInfo;
    }

//    @Override
//    public PageInfo list(String pageNum, String pageSize) {
//        return null;
//    }

    @Override
    public PageInfo selectLike(InsuranceNews insuranceNews, String pageNum, String pageSize) {
        List<InsuranceNews> insuranceNewsList = new ArrayList<>();
        InsuranceNewsExample example = setParamOfCriteria(insuranceNews);
        Page<Object> objects = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        insuranceNewsList = this.insuranceNewsMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(insuranceNewsList);
        return pageInfo;
    }

    @Override
    public InsuranceNews selectById(String id) {
        InsuranceNews insuranceNews = new InsuranceNews();
        try {
            insuranceNews=insuranceNewsMapper.selectByPrimaryKey(Integer.parseInt(id));
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceNews;
    }
    @Override
    public Boolean updateById(InsuranceNews insuranceNews) {
        insuranceNewsMapper.updateByPrimaryKeySelective(insuranceNews);
        return true;
    }

    @Override
    public Boolean deleteById(String id) {
        InsuranceNews insuranceNews = new InsuranceNews();
        insuranceNews.setId(Integer.parseInt(id));
        insuranceNews.setIsDeleted(true);
        insuranceNewsMapper.updateByPrimaryKeySelective(insuranceNews);
        return true;
    }

    @Override
    public Boolean insert(InsuranceNews insuranceNews) {
        insuranceNewsMapper.insertSelective(insuranceNews);
        return true;
    }

    public InsuranceNewsExample setParamOfCriteria(InsuranceNews insuranceNews) {
        InsuranceNewsExample example = new InsuranceNewsExample();
        String orderByStr = "";
        if (insuranceNews.getOrderByOne() != null && !"".equals(insuranceNews.getOrderByOne()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceNews.getOrderByOne() + " ASC, ";
        if (insuranceNews.getOrderByTwo() != null && !"".equals(insuranceNews.getOrderByTwo()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceNews.getOrderByTwo() + " ASC, ";
        if (insuranceNews.getOrderByThree() != null && !"".equals(insuranceNews.getOrderByThree()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceNews.getOrderByThree() + " ASC, ";
        if (orderByStr.endsWith(", ")) orderByStr = orderByStr.substring(0, orderByStr.length() - 2);
        if (orderByStr != null && !orderByStr.equals("")) example.setOrderByClause(orderByStr);

        InsuranceNewsExample.Criteria criteria = example.createCriteria();
        if (insuranceNews.getTitle() != null && !insuranceNews.getTitle().equals(""))
            criteria.andTitleLike("%" + insuranceNews.getTitle() + "%");
        if (insuranceNews.getShortContent() != null && !insuranceNews.getShortContent().equals(""))
            criteria.andShortContentLike("%" + insuranceNews.getShortContent() + "%");
        if (insuranceNews.getUrl() != null && !insuranceNews.getUrl().equals(""))
            criteria.andUrlLike("%" + insuranceNews.getUrl() + "%");
        if (insuranceNews.getReleaseTimeFrom() != null && insuranceNews.getReleaseTimeTo() != null && !insuranceNews.getReleaseTimeFrom().equals("") && !insuranceNews.getReleaseTimeTo().equals(""))
            criteria.andReleaseTimeBetween(
                    LocalDateTime.parse(insuranceNews.getReleaseTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceNews.getReleaseTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        if (insuranceNews.getCreateTimeFrom() != null && insuranceNews.getCreateTimeTo() != null && !insuranceNews.getCreateTimeFrom().equals("") && !insuranceNews.getCreateTimeTo().equals(""))
            criteria.andCreateTimeBetween(
                    LocalDateTime.parse(insuranceNews.getCreateTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceNews.getCreateTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        criteria.andIsDeletedEqualTo(false);
        return example;
    }
}
