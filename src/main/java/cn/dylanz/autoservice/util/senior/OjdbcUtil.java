package cn.dylanz.autoservice.util.senior;

/**
 * @author : dylanz
 * @since : 06/15/2020
 **/
public class OjdbcUtil {
    /*private static String driverName;
    private static String username;
    private static String password;
    private static String url;
    private static Statement statement;
    private static Connection conn;

    OjdbcUtil() {
        try {
            String env = EnvUtil.convertAll(ConfigUtil.getEnv());
            String filePath = String.format("./src/test/resources/ojdbc/%s/ojdbc.properties", env);
            File file = new File(filePath);
            if (!file.exists()) {
                filePath = String.format("./src/test/resources/ojdbc/%s/ojdbc.properties.pt", env);
                file = new File(filePath);
            }
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            Properties properties = new Properties();
            properties.load(inputStream);

            driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            String defaultUserName = properties.getProperty("defaultUserName");
            String defaultPassword = properties.getProperty("defaultPassword");

            username = (username.startsWith("{{") && username.contains("}}")) ? defaultUserName : username;
            password = (password.startsWith("{{") && password.contains("}}")) ? defaultPassword : EncryptUtil.decrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Connection getConnection() {
        try {
            System.out.println("Connect to oracle db...");
            Class.forName(driverName);
            Driver driver = new OracleDriver();
            DriverManager.deregisterDriver(driver);

            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    static JSONArray query(String sql) {
        if (conn == null || statement == null) {
            new OjdbcUtil();
            getConnection();
        }

        JSONArray queryResult = new JSONArray();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            if (columnCount == 0) {
                return queryResult;
            }

            while (rs.next()) {
                JSONObject rowData = new JSONObject();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getString(i));
                }
                queryResult.add(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return queryResult;
        }
        return queryResult;
    }

    public static void close() {
        try {
            if (conn == null || statement == null) {
                return;
            }
            System.out.println("Close oracle db connection...");
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
