package cn.dylanz.autoservice.util.senior;

/**
 * @author : dylanz
 * @since : 06/15/2020
 **/
public class QueryDbUtil {
/*//    private static Logger logger = Logger.getLogger(QueryDbUtil.class);
    private static String env = ConfigUtil.getEnv();

    public static JSONArray queryDB(String sqlText, String... params) {
        if (env.equalsIgnoreCase("pr")) {
            return new JSONArray();
        }
        JSONArray queryResult = new JSONArray();
        sqlText = params.length > 0 ? String.format(sqlText, params) : sqlText;
        try {
//            logger.info(String.format("Query DB on: %s with sql: %s", env, sqlText));
            queryResult = OjdbcUtil.query(sqlText);

            if (queryResult != null) {
//                logger.info(String.format("Query result length: %s", queryResult.size() + ""));
            }
            if (queryResult != null && queryResult.size() > 0) {
//                logger.info(String.format("First row: %s", JSON.toJSONString(queryResult.get(0), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat)));
            }
            return queryResult;
        } catch (Exception e) {
//            logger.error(String.format("Failed to query DB on: %s with sql: %s", env, sqlText));
            e.printStackTrace();
            return queryResult;
        }
    }*/
}