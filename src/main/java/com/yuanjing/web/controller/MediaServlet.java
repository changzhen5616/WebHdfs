package com.yuanjing.web.controller;

import com.yuanjing.web.util.Constants;
import com.yuanjing.web.util.Result;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;

/**
 * @author Poseidon
 * @date 2019/6/6 10:58
 * @descrition 负责处理图片、视频请求处理
 */
public class MediaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Result result = new Result();
        try {
            this.preview(req, resp);
        } catch (RuntimeException e) {
            //e.printStackTrace();
            result.setCode(1);
            result.setMsg(e.getMessage());
        } catch (IOException e) {
            result.setCode(1);
            result.setMsg(e.getMessage());
        }

        System.out.printf(result.toString());
    }

    public void preview(HttpServletRequest req, HttpServletResponse resp) throws RuntimeException, IOException {

        String filename = req.getParameter("media");

        if (filename == null) {
            throw new RuntimeException("所传参数有误");
        }

        //获取文件绝对路径
        String file = Constants.HDFSPATH + filename;
        //获取HDFS配置对象
        Configuration conf = Constants.getConfiguration();
        FileSystem fs = null;
        FSDataInputStream in = null;
        try {
            fs = FileSystem.get(URI.create(file), conf);
            in = fs.open(new Path(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取文件长度
        long fileLen = fs.getFileStatus(new Path(file)).getLen();

        //设置返回
        resp.setContentType("application/octet-stream");
        long time = System.currentTimeMillis() + 10 * 60;
        resp.setHeader("expries", String.valueOf(time));
        OutputStream out = resp.getOutputStream();
        IOUtils.copyBytes(in, out, fileLen, false);
        in.close();
        in = null;
        out.close();
        out = null;
    }

}