package com.main;

import com.tool.ConvertString;
import com.tool.FileOperator;
import com.tool.LineOperator;
import com.tool.ReadFile;

import java.util.HashMap;
import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 3:31 PM
 */
public class Main {
    public static void main(String args[]) throws Exception{
        Map testMap = new HashMap();
        FileOperator fo = new ReadFile();
        LineOperator lo = new ConvertString();
        testMap = fo.ReadConfile("ImgConf.txt");

    }
}
