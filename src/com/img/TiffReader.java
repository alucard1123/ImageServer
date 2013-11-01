package com.img;

import com.main.RunTimeConf;
import com.tool.FileOperator;
import com.tool.ReadFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * User: edward
 * Date: 10/25/13
 * Time: 3:02 PM
 */
public class TiffReader implements ImgOperator{
    private Boolean debug = RunTimeConf.isDebug();
    FileOperator fo = new ReadFile();
    public TiffReader() {
        fo.ReadConfile();
    }

    public int[] ReadImg(int x,int y,String ImgName){

        String DirName = fo.ReadConfile("path");
        File image = new File(DirName+ImgName);
        int[] RGB;
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(image));
            BufferedImage bi = ImageIO.read(is);
            RGB = getRGBSplit(bi.getRGB(x, y));
            if(debug){
                //System.out.print(Arrays.toString(RGB)+"\t");
            }
            return RGB;
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
        int[] SplitedRGB= new int[3];
        SplitedRGB[0]=c.getBlue();
        SplitedRGB[1]=c.getGreen();
        SplitedRGB[2]=c.getRed();
        return SplitedRGB;
    }

}
