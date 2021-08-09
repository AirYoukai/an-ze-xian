package com.anzexian.demo.util;

import com.anzexian.demo.entity.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExportPrintUtils {
    public static ResponseEntity<byte[]> getReturnFile(String filePathName, String fileNameInPage) throws IOException {
        try {
            File file = new File(filePathName);
            byte[] body = null;
            InputStream is = new FileInputStream(file);
            body = new byte[is.available()];
            is.read(body);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attchement;filename=" + java.net.URLEncoder.encode(fileNameInPage,"utf-8"));;
            HttpStatus statusCode = HttpStatus.OK;
            ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
            file.delete();
            File toDelete = new File(filePathName);
            toDelete.delete();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //返回的是文件路径
    public static String createUserExcel(String title,String[] rowsName,List<Object> objectList){
        HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
        HSSFSheet sheet = workbook.createSheet(title);                     // 创建工作表
        List<Object[]> dataList = new ArrayList<Object[]>();
//        Object[] objs = null;
        String[] objs = null;
        for (int i = 0; i< objectList.size(); i++) {
            UserManage data = (UserManage)objectList.get(i);
            objs = new String[rowsName.length];
            objs[0] = data.getId()+"";
            objs[1] = data.getUserName();
            objs[2] = (data.getPassword()==null)?("    "):(data.getPassword());
            objs[3] = (data.getOpenId()==null)?("    "):(data.getOpenId());
            objs[4] = (data.getUserRole()==null)?("    "):(data.getUserRole()+"");
            objs[5] = (data.getUserRealName()==null)?("    "):(data.getUserRealName());
            objs[6] =(data.getUserAge()==null)?("    "):(data.getUserAge()+"");
            objs[7] = (data.getUserSex()==null)?("    "):(data.getUserSex());
            objs[8] = (data.getCreateTime()==null)?("    "):(data.getCreateTime()+"");
            if(data.getIsDeleted())objs[9] ="已删除" ;
            else if(data.getIsActive())objs[9] ="激活";
            else objs[9] ="冻结";
            dataList.add(objs);
        }
        ExportExcel ex = new ExportExcel(title, rowsName, dataList);
        String filePathName="";
        try {
            filePathName=ex.export(workbook, sheet, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePathName;
    }

    //返回的是文件路径
    public static String createInsuranceWxpayExcel(String title,String[] rowsName,List<Object> objectList){
        HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
        HSSFSheet sheet = workbook.createSheet(title);                     // 创建工作表
        List<Object[]> dataList = new ArrayList<Object[]>();
//        Object[] objs = null;
        String[] objs = null;
        for (int i = 0; i< objectList.size(); i++) {
            InsuranceWxpay data = (InsuranceWxpay)objectList.get(i);
            objs = new String[rowsName.length];
            objs[0] = data.getId()+"";
            objs[1] = (data.getOpenId()==null)?("    "):(data.getOpenId());
            objs[2] = (data.getAppId()==null)?("    "):(data.getAppId());
            objs[3] = (data.getMchId()==null)?("    "):(data.getMchId());
            objs[4] =(data.getNonceStr()==null)?("    "):(data.getNonceStr());
            objs[5] =(data.getBody()==null)?("    "):(data.getBody());
            objs[6] =(data.getOutTradeNo()==null)?("    "):(data.getOutTradeNo());
            objs[7] = (data.getTotalFee()==null)?("    "):(data.getTotalFee());
            objs[8] = (data.getSpbillCreateIp()==null)?("    "):(data.getSpbillCreateIp());
            objs[9] =(data.getNotifyUrl()==null)?("    "):(data.getNotifyUrl());
            objs[10] = (data.getTradeType()==null)?("    "):(data.getTradeType());
            objs[11] = (data.getReturnCode()==null)?("    "):(data.getReturnCode());
            objs[12] = (data.getResultCode()==null)?("    "):(data.getResultCode());
            objs[13] =(data.getPrepayId()==null)?("    "):(data.getPrepayId());
            objs[14] =(data.getSignType()==null)?("    "):(data.getSignType());
            objs[15] =(data.getTimeStamp()==null)?("    "):(data.getTimeStamp());
            objs[16] = (data.getPaySign()==null)?("    "):(data.getPaySign());
            objs[17]=(data.getUnifiedorderSucceed())?("下单成功"):("下单失败");
            objs[18] =(data.getPaySucceed())?("支付成功"):("支付失败");
            objs[19] =(data.getUnifiedorderTime()==null)?("    "):(""+data.getUnifiedorderTime());
            objs[20] = (data.getPayTime()==null)?("    "):(data.getPayTime()+"");
            objs[21] = (data.getCreateTime()==null)?("    "):(data.getCreateTime()+"");
            dataList.add(objs);
        }
        ExportExcel ex = new ExportExcel(title, rowsName, dataList);
        String filePathName="";
        try {
            filePathName=ex.export(workbook, sheet, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePathName;
    }


    public static String createOrderExcel(String title, String[] rowsName, List objectList) {
        return "";
    }

    public static String createInsuranceServiceExcel(String title, String[] rowsName, List objectList) {
        HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
        HSSFSheet sheet = workbook.createSheet(title);                     // 创建工作表
        List<Object[]> dataList = new ArrayList<Object[]>();
//        Object[] objs = null;
        String[] objs = null;
        for (int i = 0; i< objectList.size(); i++) {
            InsuranceService data = (InsuranceService)objectList.get(i);
            objs = new String[rowsName.length];
            objs[0] = data.getId()+"";
            objs[1] = (data.getServiceName()==null)?("    "):(data.getServiceName());
            objs[2] = (data.getServicePremium()==null)?("    "):(""+data.getServicePremium());
            objs[3] = (data.getServicePrice()==null)?("    "):(""+data.getServicePrice());
            objs[4] =(data.getServiceDuration()==null)?("    "):(""+data.getServiceDuration());
//            ,"适用行业","联系人","理赔方式",
            objs[5] = (data.getIndustry()==null)?("    "):(data.getIndustry()+"");
            objs[6] = (data.getContactName()==null)?("    "):(data.getContactName()+"");
            objs[7] = (data.getClaimMethod()==null)?("    "):(data.getClaimMethod()+"");
            objs[8] = (data.getCreateTime()==null)?("    "):(data.getCreateTime()+"");
            dataList.add(objs);
        }
        ExportExcel ex = new ExportExcel(title, rowsName, dataList);
        String filePathName="";
        try {
            filePathName=ex.export(workbook, sheet, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePathName;
    }

    public static String createInsuranceOrderExcel(String title, String[] rowsName, List objectList) {
        HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
        HSSFSheet sheet = workbook.createSheet(title);                     // 创建工作表
        List<Object[]> dataList = new ArrayList<Object[]>();
//        Object[] objs = null;
        String[] objs = null;
        for (int i = 0; i< objectList.size(); i++) {
            InsuranceOrder data = (InsuranceOrder)objectList.get(i);
            objs = new String[rowsName.length];
            objs[0] = data.getId()+"";
            objs[1] = (data.getInsuranceService().getServiceName()==null)?("    "):(data.getInsuranceService().getServiceName());
            objs[2] = (data.getInsuranceService().getInsuranceCompany().getCompanyName()==null)?("    "):(data.getInsuranceService().getInsuranceCompany().getCompanyName());
            objs[3] = (data.getInsuranceService().getIndustry()==null)?("    "):(data.getInsuranceService().getIndustry());
            objs[4]=(data.getIsActive())?("未到期"):("已过期");
            objs[5] = (data.getExpireTime()==null)?("    "):(data.getExpireTime()+"");
            objs[6] = (data.getCreateTime()==null)?("    "):(data.getCreateTime()+"");
            dataList.add(objs);
        }
        ExportExcel ex = new ExportExcel(title, rowsName, dataList);
        String filePathName="";
        try {
            filePathName=ex.export(workbook, sheet, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePathName;
    }

    public static String createInsuranceNewsExcel(String title, String[] rowsName, List objectList) {
        HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
        HSSFSheet sheet = workbook.createSheet(title);                     // 创建工作表
        List<Object[]> dataList = new ArrayList<Object[]>();
//        Object[] objs = null;
        String[] objs = null;
        for (int i = 0; i< objectList.size(); i++) {
            InsuranceNews data = (InsuranceNews)objectList.get(i);
            objs = new String[rowsName.length]; 
            objs[0] = data.getId()+"";
            objs[1] = (data.getTitle()==null)?("    "):(data.getTitle());
            objs[2] = (data.getShortContent()==null)?("    "):(""+data.getShortContent());
            objs[3] = (data.getUrl()==null)?("    "):(""+data.getUrl());
            objs[4] =(data.getReleaseTime()==null)?("    "):(""+data.getReleaseTime());
            objs[5] = (data.getCreateTime()==null)?("    "):(data.getCreateTime()+"");
            dataList.add(objs);
        }
        ExportExcel ex = new ExportExcel(title, rowsName, dataList);
        String filePathName="";
        try {
            filePathName=ex.export(workbook, sheet, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePathName;
    }

    public static String createInsuranceClaimExcel(String 套餐列表, String[] rowsName, List list) {
        return "";
    }
}
