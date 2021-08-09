package com.anzexian.demo.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileUtils {
    public static ResponseEntity<byte[]> downloadFile(String filePathName,String fileNameInPage) {
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
}
