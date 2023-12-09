package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    public static List<Map<String, String>> fetch(String query) {

        List<Map<String, String>> tableData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASS_WORD)) {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();


            // This loop iterates through the result set rows
            while (rs.next()) {
                // Create a new Map to store column names and values for the current row
                Map<String, String> rowMap = new HashMap<>();

                // This loop iterates through each column of the result set
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    // Get the name of the column (key in the map)
                    String key = rsmd.getColumnName(i);

                    // Get the value of the current column for the current row
                    String value = rs.getString(i);

                    // Add the column name and value to the rowMap
                    rowMap.put(key, value);
                }
                tableData.add(rowMap);
                // At this point, rowMap contains the column names and values for the current row
            }
            return tableData;
            //hash no duplicate
            //tree alphabetical
            // linked maintains the order
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;
    }
}
