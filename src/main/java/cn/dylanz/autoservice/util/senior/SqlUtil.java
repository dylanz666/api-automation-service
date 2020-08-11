package cn.dylanz.autoservice.util.senior;

import cn.dylanz.autoservice.util.base.FileUtil;
import com.alibaba.fastjson.JSONPath;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
public class SqlUtil {
    @Autowired
    private FileUtil fileUtil;

    public String getSql(String sourceFileName, String sqlName) throws Exception {
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
        String bodyString = fileUtil.readSqlFromFile(sourceFileName);
        return JSONPath.read(bodyString, "$." + sqlName).toString();
    }
}
