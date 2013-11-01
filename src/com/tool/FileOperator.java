package com.tool;

import java.util.Map;

/**
 * User: edward
 * Date: 10/24/13
 * Time: 2:59 PM
 */
public interface FileOperator {
    public void ReadConfile();
    public String ReadConfile(String ArgName);
    public Map GetArgMap();
}
