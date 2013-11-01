package com.img;

/**
 * User: edward
 * Date: 10/25/13
 * Time: 2:46 PM
 */
public interface ImgOperator {
    //read ImgName x,y RGB
    public int[] ReadImg(int x,int y,String ImgName);
    public void PrintSupportImgType();
}
