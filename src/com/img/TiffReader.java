package com.img;

import java.io.*;

/**
 * User: edward
 * Date: 10/25/13
 * Time: 3:02 PM
 */
public class TiffReader implements ImgOperator{
    public String[] ReadImg(int x,int y,String ImgName){
        File image = new File(ImgName);
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(image));
            TIFFImage
        } catch (FileNotFoundException e) {
            //may cause read-file exception
            e.printStackTrace();
        }
        return null;
    }

}
