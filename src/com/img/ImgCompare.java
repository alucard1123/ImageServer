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
    int blind = 0;
    //Identification the input image
    public String IdentifiImg(String InputImg,Map Standard){
        LoadStandardImg();
        String result = "";
        this.InputImg = InputImg;
        int Position=0;
        int BreadMark=0;
        GetImgArray(2);
        while(true){
            BreadMark=0;
            for(int Si = 0;Si<10;Si++){
                if(LikeEach((int[])Standard.get(Si),GetImgArray(Position))){
                    result=Si+result;
                    continue;
                }else{
                    BreadMark++;
                }
            }
            if(BreadMark==10){
                break;
            }
            Position++;

        }
        return result;
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
        int HTop =Integer.parseInt(fo.ReadConfile("HTop"));
        blind = Integer.parseInt(fo.ReadConfile("Blind"));
        int[] ImgArray = new int[HButton-HTop];
        for(int i=HTop;i<HButton;i++){
            int[] ReadedPixel = io.ReadImg(Tail-location*Width,i,InputImg);
            ImgArray[i-HTop]=ReadedPixel[2]+ReadedPixel[1];
        }
        //System.out.println(Arrays.toString(ImgArray));
        return ImgArray;
    }
    private boolean LikeEach(int[] bro,int[] younger){
        if(bro.length==younger.length){
            int StringLenth = bro.length;
            for(int i=0;i<StringLenth;i++){
                if((bro[i]-this.blind)<younger[i]&&younger[i]<(bro[i]+this.blind)){

                }
                else {
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
