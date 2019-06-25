package com.yuanjing.web.util;

import org.apache.hadoop.conf.Configuration;

/**
 * @author Poseidon
 * @date 2019/6/6 10:58
 * @descrition 获取configuration
 */
public class Constants {

    //NAMENODEG1 RPC 地址
    public static String RPCNODE1 = "192.168.16.6:8020";

    //NAMENODEG1 RPC 地址
    public static String RPCNODE2 = "192.168.16.5:8020";

    //HDFS
    public static  String HDFSPATH = "/webhdfs/yuanjing";

    //defaultFS
    public static String  DEFAUTFS = "hdfs://bmr-cluster";

    //DFs Nameservices
    public static String NAMESERVICES = "bmr-cluster";

    //NAMENODE1
    public static String NAMENODE1 = "nn1";

    //NAMENODE2
    public static String NAMENODE2 = "nn2";


    /**
     *  Hadoop Configuration
     * @return Configuration
     */
    public static Configuration   getConfiguration() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", DEFAUTFS);
        conf.set("dfs.nameservices",NAMESERVICES);
        conf.set("dfs.ha.namenodes." + NAMESERVICES,NAMENODE1 + "," + NAMENODE2);
        conf.set("dfs.namenode.rpc-address." + NAMESERVICES + "." + NAMENODE1,RPCNODE1);
        conf.set("dfs.namenode.rpc-address." + NAMESERVICES + "." + NAMENODE2,RPCNODE2);
        conf.set("dfs.client.failover.proxy.provider." + NAMESERVICES ,"org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
        return conf;
    }



}
