package com.anzexian.demo.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSONObject;

import static com.anzexian.demo.util.Constant.APP_ID;
import static com.anzexian.demo.util.Constant.MINIPRO_SECRET_KEY;
//import com.runqian.base4.util.Logger;

//import net.sf.json.JSONObject;

public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            /*
             * for (String key : map.keySet()) { System.out.println(key + "--->"
             * + map.get(key)); }
             */
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常:"+e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 单参数数据访问
     *
     */
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            /*
             * for (String key : map.keySet()) { System.out.println(key + "--->"
             * + map.get(key)); }
             */
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String doPost(String postUrl, JSONObject obj) {
        String lines = "";
        StringBuffer sb = new StringBuffer("");
        try {
            // 创建连接
            URL url = new URL(postUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            // out.writeChars(obj.toString());
            // out.write(obj.toString().getBytes("UTF-8"));
            out.write(obj.toString().getBytes());
            out.flush();
            out.close();
            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes());
                sb.append(lines);
            }
            System.out.println(sb);

            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String wxspAppid = APP_ID;
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = MINIPRO_SECRET_KEY;
        // 授权（必填）
        String grant_type2 = "authorization_code";
        String js_code="";
//	    		  1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
//        https://api.weixin.qq.com/sns/jscode2session?appid=wxe665f52060db5e0b&secret=4b8d819cbfa15deb3e69f1c056c45c19&js_code=' + res.code + '&grant_type=authorization_code
        String params2 = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code="+ js_code
                 + "&grant_type=" + grant_type2;
        // 发送请求
        String sr2 = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params2);//
        JSONObject json2 = JSONObject.parseObject(sr2);
        System.out.println("json2==" + json2.toJSONString());
        String access_token = json2.get("access_token").toString();
        System.out.println("access_token ==" + access_token );
    }

//    public static void main(String[] args) {
//        String wxspAppid = APP_ID;
//        // 小程序的 app secret (在微信小程序管理后台获取)
//        String wxspSecret = MINIPRO_SECRET_KEY;
//        // 授权（必填）
//        String grant_type2 = "client_credential";
//
////	    		  1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
//        // 请求参数
//        String params2 = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&grant_type=" + grant_type2;
//        // 发送请求
//        String sr2 = HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", params2);//
//        JSONObject json2 = JSONObject.parseObject(sr2);
//        System.out.println("json2==" + json2.toJSONString());
//        String access_token = json2.get("access_token").toString();
//        System.out.println("access_token ==" + access_token );
//    }


}