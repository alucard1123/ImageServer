package com.img;

import com.tool.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 2:43 PM
 * this class can load the standard file from config file to a Hash Map
 */
public class LoadStandardImg implements StandardCreater{
    private Map StandardMap = new HashMap();
    @Override
    public Map getStandard(){
        return StandardMap;
    }
    @Override
    public void LoadStandardImg(String ImgName){
        FileOperator fo = new ReadFile();
        fo.ReadConfile();
        String HTop = fo.ReadConfile("HTop");
        String HButton = fo.ReadConfile("HButton");
        String ImgWidth = fo.ReadConfile("ImgWidth");
        String Pixel = fo.ReadConfile("ImgStartPixel");
        ImgOperator io = new TiffReader();
        try {
            int iHTop = Integer.parseInt(HTop);
            int iHButton = Integer.parseInt(HButton);
            int iImgWidth = Integer.parseInt(ImgWidth);
            int iPixel = Integer.parseInt(Pixel);
            if(iHTop>iHButton){
                System.out.println("Error:iHtop must less than iHButton");
                System.exit(8);
            }
            int[] ResultArray = new int[iHButton-iHTop];
            for(int i=0;i<10;i++){
                ResultArray = new int[iHButton-iHTop];
                for(int j=iHTop;j<iHButton;j++){
                    //get RGB Value,here I plus R with G
                    int[] CachArray = (io.ReadImg(iPixel+iImgWidth*i,j,ImgName));
                    int RplusG = CachArray[1]+CachArray[2];
                    ResultArray[(j-iHTop)]=RplusG;
                }
                if(i==9){
                    StandardMap.put(0,ResultArray);
                }else{
                    StandardMap.put((i+1),ResultArray);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }



    }
}
