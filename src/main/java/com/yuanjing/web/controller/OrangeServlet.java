package com.yuanjing.web.controller;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author Poseidon
 * @date 2019/6/6 15:30
 * @descrition
 */
public class OrangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            //preview(req, resp);
            String file = req.getSession().getServletContext().getRealPath("/background.jpg");

            FileInputStream inStream = new FileInputStream(file);
            //byte数组用于存放图片字节数据
            byte[] buff = new byte[inStream.available()];

            inStream.read(buff);
            inStream.close();
            //设置发送到客户端的响应内容类型
            resp.setContentType("image/jpeg");

            OutputStream outStream = resp.getOutputStream();
            outStream.write(buff);
            outStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
