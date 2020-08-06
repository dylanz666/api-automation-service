package cn.dylanz.autoservice.util.senior;

import cn.dylanz.autoservice.util.base.FileUtil;
import com.alibaba.fastjson.JSONPath;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
public class SqlUtil {
    public static String getSql(String sourceFileName, String sqlName) throws Exception {
        if (null == sourceFileName) {
            throw new Exception("Null source file name!");
        }
        if (null == sqlName) {
            throw new Exception("Null request sql name!");
        }
        if (sourceFileName.endsWith(".json")) {
            sourceFileName = sourceFileName.substring(0, sourceFileName.length() - 5);
        }

        sourceFileName = sourceFileName.replace(".java", "");
        String bodyString = FileUtil.readSqlFromFile(sourceFileName);
        return JSONPath.read(bodyString, "$." + sqlName).toString();
    }
}
