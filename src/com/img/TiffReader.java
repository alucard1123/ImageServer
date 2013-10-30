package com.img;

import com.main.RunTimeConf;
import com.tool.FileOperator;
import com.tool.ReadFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

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
                System.out.println(bi.getRGB(x, y));
                System.out.println(bi.getWidth());
                System.out.println(bi.getHeight());
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

}
