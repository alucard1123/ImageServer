package com.tool;

import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 3:27 PM
 */
public interface LineOperator {
    public String[] Splitter(String intput);
    public String SpliceValue(String[] input);
    public String GetArg(String ArgName,Map inputMap);
}
