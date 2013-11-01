package com.img;

import com.tool.FileOperator;
import com.tool.ReadFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: edward
 * Date: 11/1/13
 * Time: 10:49 AM
 */
public class ImgCompare {
    Map StandardMap = new HashMap();
    String InputImg = new String();
    ImgOperator io = new TiffReader();
    FileOperator fo = new ReadFile();
    //Identification the input image
    public String IdentifiImg(String InputImg,Map Standard){
        LoadStandardImg();
        String result = "";
        this.InputImg = InputImg;
        GetImgArray(2);
        while(true){

            if(true){
                break;
            }
        }
        return null;
    }
    private void LoadStandardImg(){
        StandardCreater sc = new LoadStandardImg();
        StandardMap = sc.getStandard();
    }
    //to read R+G value into an int array from getted location
    private int[] GetImgArray(int location){
        fo.ReadConfile();
        int Width = Integer.parseInt(fo.ReadConfile("ImgWidth"));
        int Tail = Integer.parseInt(fo.ReadConfile("TailPixel"));
        int HButton = Integer.parseInt(fo.ReadConfile("HButton"));
        int Htop =Integer.parseInt(fo.ReadConfile("HTop"));
        int[] ImgArray = new int[HButton-Htop];
        for(int i=Htop;i<HButton;i++){
            int[] ReadedPixel = io.ReadImg(Tail-location*Width,i,InputImg);
            ImgArray[i-Htop]=ReadedPixel[2]+ReadedPixel[1];
        }
        System.out.println(Arrays.toString(ImgArray));
        return ImgArray;
    }
    private boolean LikeEach(int[] bro,int[] younger){
        if(bro.length==younger.length){

        }
        //TODO:add here
        return true;
    }
}
