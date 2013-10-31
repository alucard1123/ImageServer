package com.main;

import com.img.ImgOperator;
import com.img.TiffReader;
import com.tool.ConvertString;
import com.tool.FileOperator;
import com.tool.LineOperator;
import com.tool.ReadFile;

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
        for(int i=0;i<10;i++){
            for(int j =11;j<22;j++){
                iop.ReadImg(68+8*i,j,"test.png");
            }
        System.out.println();
        }
    }
}
