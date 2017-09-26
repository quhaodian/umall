package com.quhaodian.umall.utils;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 *
 * @author 张浩伟
 * @version 1.01 2017年08月30日
 */
public class FileUtils {

    public static class FileTree{
        /**
         * name
         */
        public String name;
        /**
         * path
         */
        public String path;
        /**
         * open 
         */
        public Boolean open;

        /**
         * dir是否是文件夹
         */
        public Boolean dir;

        /**
         * children 
         */
        public List<FileTree> children;
        
    }

    public static List<FileTree> getTree(String path, String parent){
        List<FileTree> result = new ArrayList<FileTree>();
        List<FileTree> childs = new ArrayList<FileTree>();
        File file = new File(path);
        FileTree tree = new FileTree();
        tree.name = file.getName();
        tree.open = false;
        tree.path = parent;
        tree.dir = false;
        if (file.isDirectory()){
            tree.dir = true;
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return result;
            }
            for (File listFile : listFiles) {
                FileTree child = new FileTree();
                child.name = listFile.getName();
                child.open = false;
                child.path = parent + "/" + listFile.getName();
                if (listFile.isDirectory()) {
                    System.out.println("path = " +path + "/" + child.name + "  parent = " + child.path);
                    childs.addAll(getTree(path + "/" + child.name, child.path));
                    child.dir = true;
                }else {
                    childs.add(child);
                    child.dir = false;
                }
            }
            tree.children = childs;
        }
        result.add(tree);
        return result;
    }

    /**
     * 读取文件
     * @param path
     *      文件路径
     * @return
     */
    public static String readFile(String path) {
        StringBuilder result= new StringBuilder();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine())!= null){
                result.append(System.lineSeparator()).append(s);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }


    /**
     * 保存文件
     * @param path 路径
     * @return
     */
    public static boolean saveFile(String path, String content) {
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file, false);
            fw.write(content);
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        List<FileTree> tree = getTree("E:\\javasrc7\\usite\\web\\src\\main\\webapp\\upload\\file\\201708\\","");
        String s = new Gson().toJson(tree);
        System.out.println(s);
//        String file = readFile("D:\\workspace\\java\\usite\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin\\solution\\add.html");
//        System.out.println(file);
    }

}
