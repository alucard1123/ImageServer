package com.main;

import com.tool.FileOperator;
import com.tool.ReadFile;

/**
 * User: edward
 * Date: 10/30/13
 * Time: 3:53 PM
 */
public class RunTimeConf {
    static FileOperator fo = new ReadFile();
    public static boolean isDebug(){
        boolean DebugMark = false;
        if(fo.ReadConfile("Debug")!=null){
            DebugMark=Boolean.valueOf(fo.ReadConfile("Debug"));
        }
        return DebugMark;
    }
}
