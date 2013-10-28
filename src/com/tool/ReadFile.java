package com.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 2:59 PM
 */
public class ReadFile implements FileOperator {

    private Map ConfigMap = new HashMap();
    public ReadFile(){

    }
    @Override
    public Map ReadConfile(String filename){
        ConfigMap.clear();
        LineOperator lo = new ConvertString();
        try{
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String Line;
            String[] CuttedLine;
            while (br.ready()){
                Line = br.readLine();
                CuttedLine = lo.Splitter(Line);
                ConfigMap.put(CuttedLine[0],lo.SpliceValue(CuttedLine));
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch(NullPointerException en){
            en.printStackTrace();
        }
        return ConfigMap;
    }
    @Override
    public Map GetConMap(){
        return this.ConfigMap;
    }
}
