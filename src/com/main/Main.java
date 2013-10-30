package com.main;

import com.img.ImgOperator;
import com.img.StandardCreater;
import com.img.TiffReader;
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
        Boolean Debug = RunTimeConf.isDebug();
        FileOperator fo = new ReadFile();
        LineOperator lo = new ConvertString();
        ImgOperator iop = new TiffReader();
        if(!Debug){
            iop.PrintSupportImgType();
        }
        iop.ReadImg(1,1,"s0.png");
    }
}
