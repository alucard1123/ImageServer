package com.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
 * edward.wu coding tools
 * @author:edward.wu
 * @copyright:edward.wu
 * @safty:checked
 */

public class StringSplitter
{
    public Vector<String> spliter(String iptWord)
    {	
    	String word = null;
        word = iptWord;
        String regex = "[:]";
        String[] starts = word.split(regex);
        Vector<String> vec = new Vector<String>();
        Vector<String> gets = new Vector<String>();
        //System.out.println(starts);
        
        int begin,end;
        
        //System.out.println(word);
        
        for (String s: starts) {
            if (!s.equals("")) {
                vec.add(s);
            }
        }
        begin = 0;
        
        for (String s: vec) {
            begin = word.indexOf(s,begin);
            end = word.indexOf(s,begin);
            gets.add(word.substring(begin,end));
            begin = end;
        }
        
        return vec;
        
    }
    public void printPoint(int num) throws Exception{

    	for(int icoin=0;icoin<num;icoin++){
    		Thread.sleep(20);
    		System.out.print(".");
    	}
    	System.out.println(".");
		Thread.sleep(200);
    }
    public void printDush(int num) throws Exception{
    	
    	for(int icoin=0;icoin<num;icoin++){
    		Thread.sleep(10);
    		System.out.print("-");
    	}
    	System.out.println("-");
		Thread.sleep(10);
    }
    public void printSummary(long time,int dushTime,String context,boolean infile) throws Exception{
    	String printedTime = "total time(count in ms):"+time;
    	String printedDetail = "\ndetail(s):\n"+context;
    	
    	if(infile){
    		FileWriter fw = new FileWriter("log.txt");
    		BufferedWriter bw = new BufferedWriter(fw);
    		bw.write(printedTime);
    		bw.write(printedDetail);
    		bw.flush();
    		bw.close();
    		fw.close();
    		printLitter("writing into log file:log.txt");
    		printPoint(3);
    	}
    	else{
    	printLitter("\nTest Summary");
    	printDush(dushTime);	
    	printLitter(printedTime);
    	printLitter(printedDetail);
    	printLitter("\nTest Summary");
    	printDush(dushTime);
    	}
    }
    public void printLitter(String inputString) throws Exception{
    	for(int i=0;i<inputString.length();i++){
    		System.out.print(inputString.charAt(i));
    		Thread.sleep(10);
    	}
    	//System.out.println();
    }
    public void printDebug(String inputString) throws Exception{
    	System.out.println("^v^v^v^v*****WUYGDEBUG****v^v^v^v^");
    	System.out.println(inputString);
    	System.out.println("^v^v^v^v*****WUYGDEBUG****v^v^v^v^");
    }
    public Vector<String> readConfiger(String configMark,String filename) throws Exception{
    	Vector<String> resault = new Vector<String>();
    	resault.clear();
    	try{
    		FileReader reader =  new FileReader(filename);
    		@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(reader);
    		
    		String readLine = null;

    		while(buffer.ready()){
    			readLine = buffer.readLine();
    			resault=spliter(readLine);
    			if(resault.elementAt(0).equals(configMark)){
    				return resault;
    			}
    		}
    		
    			//return counter;
    			buffer.close();
    			reader.close();
    		
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    	System.out.println("arg(s) not found,check configer");
		return null;
    }
    public static void writeLog(String logFile,String content){
    	try{
    		File f= new File(logFile);
    		if(!f.exists()){
    			if(f.createNewFile()){
    				System.out.println("create logFile");
    			}
    			else{
    				System.out.println("failed to create logFile");
    				return;
    			}
    		}
    		FileWriter writer = new FileWriter(logFile,true);
    		writer.write(content);
    		writer.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
}