package com.img;

import com.main.RunTimeConf;
import com.tool.FileOperator;
import com.tool.ReadFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

/**
 * User: edward
 * Date: 10/25/13
 * Time: 3:02 PM
 */
public class TiffReader implements ImgOperator{
    private Boolean debug = RunTimeConf.isDebug();
    public String[] ReadImg(int x,int y,String ImgName){
        FileOperator fo = new ReadFile();
        String DirName = fo.ReadConfile("path");
        File image = new File(DirName+ImgName);
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(image));
            BufferedImage bi = ImageIO.read(is);
            if(debug){
                int[] RGB;
                RGB = getRGBSplit(bi.getRGB(x, y));
                //System.out.print(Arrays.toString(RGB)+"\t");
                System.out.print(RGB[3]+"\t");
            }
        } catch (FileNotFoundException e) {
            //may cause read-file exception
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void PrintSupportImgType(){
        try{
            String[] SupportType = ImageIO.getReaderFormatNames();
            for(int i=0;i<SupportType.length;i++){
                System.out.println(SupportType[i]);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private int[] getRGBSplit(int input){
        Color c = new Color(input);
        int[] SplitedRGB= new int[4];
        SplitedRGB[0]=c.getBlue();
        SplitedRGB[1]=c.getGreen();
        SplitedRGB[2]=c.getRed();
        SplitedRGB[3]=SplitedRGB[2]+SplitedRGB[1];
        return SplitedRGB;
    }

}
