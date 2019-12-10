package com.cqu.recommendation.service.spark;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.launcher.SparkLauncher;
import org.apache.spark.rdd.RDD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class initSystem {
    private static String master = "spark://192.168.217.132:7077";

    public static List<String> getStringsByTXT(String txtFilePath, Configuration conf, String userID) {
        List<String> lines = new ArrayList<>();
        FSDataInputStream fsr = null;
        BufferedReader bufferedReader = null;
        String lineTxt = null;
        try {
            FileSystem fs = FileSystem.get(URI.create(txtFilePath), conf);
            fsr = fs.open(new Path(txtFilePath));
            bufferedReader = new BufferedReader(new InputStreamReader(fsr));
            while ((lineTxt = bufferedReader.readLine()) != null) {
                if (lineTxt.contains(userID))
                    lines.add(lineTxt);
                System.out.println(lineTxt);
            }
            return lines;
        } catch (Exception e) {
            return lines;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public static void main(String[] args) {
        //1、测试HDFS文件访问
        Configuration conf1 = new Configuration();
        String txtFilePath = "hdfs://192.168.1.112:9000/users/part-r-00000";
        List<String> lines = getStringsByTXT(txtFilePath, conf1, "");

        //2、测试Spark访问
        SparkConf conf = new SparkConf().setAppName("Spark Java API 学习")
                .setMaster("spark://192.168.1.112:7077")
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> users = sc.textFile("hdfs://192.168.1.112:9000/users");
        System.out.println(users.first());
    }
}
