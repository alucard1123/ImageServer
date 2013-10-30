package com.img;

import com.tool.*;

import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 2:43 PM
 * this class can load the standard file from config file to a Hash Map
 */
public class LoadStandardImg implements StandardCreater{
    @Override
    public Map getStandard(){

        return null;
    }
    @Override
    public void LoadStandardImg(){
        //load standard img path
        FileOperator fo = new ReadFile();
        LineOperator lo = new ConvertString();
        Map ConMap = fo.ReadConfile();
        String ImgPath = lo.GetArg("path",ConMap);

    }
}
