package cn.beanbang.generator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
    /**
     * 截取路径中的不带后缀名的文件名
     * "./aaa/bbb.txt" -> "bbb"
     * @param fileName 文件路径名
     * @return 文件名
     */
    public static String subFileName(String fileName){
        String res = "";
        String pattern = "(?<=\\/)([^\\/]+)\\.([^\\.]+)$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(fileName);
        if (m.find()){
            res = m.group(1);
        }

        return res;
    }

    /**
     * 将下划线变量转换成大驼峰命名法
     * "first_name" -> "FirstName"
     * @param str 字符串
     * @return
     */
    public static String parseUpperCamel(String str){
        String pattern = "_(\\w)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()){
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);
        sb.replace(0,1, sb.substring(0, 1).toUpperCase());
        return sb.toString();
    }
}
