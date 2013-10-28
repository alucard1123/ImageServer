package com.tool;

import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 3:28 PM
 */
public class ConvertString implements LineOperator {
    public String[] Splitter(String intput){
        String[] CuttedString;
        CuttedString = intput.split(":");
        return CuttedString;
    }
    public String SpliceValue(String[] input) throws NullPointerException{
        String Spliced = "";
        for(int i=1;i<input.length-1;i++){
            Spliced = Spliced+input[i]+":";
        }
        Spliced = Spliced+input[input.length-1];
        return Spliced;
    }
    //return value of arg read from a config file etc. return null if there is an error
    public String GetArg(String ArgName,Map inputMap){
        FileOperator fo = new ReadFile();
        String ArgValue= null;
        try {
            ArgValue = (String)inputMap.get(ArgName);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ArgValue;
    }
}
