package com.main;

import com.img.*;
import com.tool.ConvertString;
import com.tool.FileOperator;
import com.tool.LineOperator;
import com.tool.ReadFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 3:31 PM
 */
public class Main {
    public static void main(String args[]) throws Exception{
        Boolean Debug = RunTimeConf.isDebug();
        FileOperator fo = new ReadFile();
        LineOperator lo = new ConvertString();
        ImgOperator iop = new TiffReader();
        StandardCreater sc = new LoadStandardImg();
        sc.LoadStandardImg("test.png");
        Map testMap = new HashMap();
        testMap= sc.getStandard();
        fo.ReadConfile();
        //testMap=fo.GetArgMap();
        //debug all members in testMap

        Iterator it = testMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            //System.out.println(key+":"+Arrays.toString((int[])value));
        }
        ImgCompare ic = new ImgCompare();
        String testStr = ic.IdentifiImg("test1.png",testMap);
        System.out.println(testStr);



    }
}
