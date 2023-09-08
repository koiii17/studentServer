package com.studentDemo.pickCourse;

import com.sun.source.tree.CatchTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestSqlite
{
//    private static Connection c = null;


    public static void main( String args[] ) {

        try {
            Connection c = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Connection connection;

    public static void initialize() {
        try {
            // 加载SQLite驱动程序，确保您已将相应的驱动程序库文件添加到项目中
            Class.forName("org.sqlite.JDBC");

            // 构建数据库连接字符串
            String connectionString = "jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite"; // 根据实际路径修改

            // 建立数据库连接
            connection = DriverManager.getConnection(connectionString);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertStu(int id, String name, String major, String courses, int score1, int score) {
        try {
            Connection c = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            String sql = "INSERT INTO StuMessage (id, name, major, courses, score1, score) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, major);
            pstmt.setString(4, courses);
            pstmt.setInt(5, score1);
            pstmt.setInt(6, score);

            pstmt.executeUpdate();
            pstmt.close();
            c.close();

            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertCou(int cid, String cname, String time, String place, int score,String  teacher, int members,int total,String bixuanxiu,int zhou,int jie) {
        try {
            Connection c = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            String sql = "INSERT INTO CouMessage (cid, cname, time, place,score, teacher,members,total,课程类型,zhou,jie) " +
                    "VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";

            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, cid);
            pstmt.setString(2, cname);
            pstmt.setString(3, time);
            pstmt.setString(4, place);
            pstmt.setInt(5, score);
            pstmt.setString(6,teacher);
            pstmt.setInt(7, members);
            pstmt.setInt(8,total);
            pstmt.setString(9,bixuanxiu);
            pstmt.setInt(10,zhou);
            pstmt.setInt(11,jie);
            pstmt.executeUpdate();
            pstmt.close();
            c.close();

            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readcourse()
    {
        try
        {
            Statement statement = null;
            ResultSet resultSet = null;
            Connection connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            String sql = "SELECT * FROM CouMessage ";
            statement = connection.createStatement();
            // 执行查询语句
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                // 输出课程信息
                System.out.println("以下是所有课程信息，供参考选择");
                do {
                    int cId = resultSet.getInt("cid");
                    String cName = resultSet.getString("cname");
                    String time = resultSet.getString("time");
                    String place = resultSet.getString("place");
                    int score = resultSet.getInt("score");
                    String teacher = resultSet.getString("teacher");
                    int members = resultSet.getInt("members");
                    int total = resultSet.getInt("total");
                    String bixuanxiu = resultSet.getString("课程类型");
                    System.out.println("编号: " + cId + " | 课程名称: " + cName + " | 授课老师: " + teacher + " | 上课时间: " +
                            time + " | 上课地点: " + place + " | 课程学分: " + score + "分 | 已选课人数: " + members +
                            " | 允许选课人数: " + total+" | 课程类型: " + bixuanxiu);
                } while (resultSet.next());
            } else {
                System.out.println("当前没有课程录入，请去录入课程！");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readbixiucourse()
    {
        try
        {
            Statement statement = null;
            ResultSet resultSet = null;
            Connection connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            String sql = "SELECT * FROM CouMessage WHERE 课程类型 = '必修'";
            statement = connection.createStatement();
            // 执行查询语句
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                // 输出课程信息
                System.out.println("以下是所有课程信息，供参考选择");
                do {
                    int cId = resultSet.getInt("cid");
                    String cName = resultSet.getString("cname");
                    String time = resultSet.getString("time");
                    String place = resultSet.getString("place");
                    int score = resultSet.getInt("score");
                    String teacher = resultSet.getString("teacher");
                    int members = resultSet.getInt("members");
                    int total = resultSet.getInt("total");

                    System.out.println("编号: " + cId + " | 课程名称: " + cName + " | 授课老师: " + teacher + " | 上课时间: " +
                            time + " | 上课地点: " + place + " | 课程学分: " + score + "分 | 已选课人数: " + members +
                            " | 允许选课人数: " + total);
                } while (resultSet.next());
            } else {
                System.out.println("当前没有课程录入，请去录入课程！");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readxuanxiucourse()
    {
        try
        {
            Statement statement = null;
            ResultSet resultSet = null;
            Connection connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            String sql = "SELECT * FROM CouMessage WHERE 课程类型 = '选修'";
            statement = connection.createStatement();
            // 执行查询语句
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                // 输出课程信息
                System.out.println("以下是所有课程信息，供参考选择");
                do {
                    int cId = resultSet.getInt("cid");
                    String cName = resultSet.getString("cname");
                    String time = resultSet.getString("time");
                    String place = resultSet.getString("place");
                    int score = resultSet.getInt("score");
                    String teacher = resultSet.getString("teacher");
                    int members = resultSet.getInt("members");
                    int total = resultSet.getInt("total");

                    System.out.println("编号: " + cId + " | 课程名称: " + cName + " | 授课老师: " + teacher + " | 上课时间: " +
                            time + " | 上课地点: " + place + " | 课程学分: " + score + "分 | 已选课人数: " + members +
                            " | 允许选课人数: " + total);
                } while (resultSet.next());
            } else {
                System.out.println("当前没有课程录入，请去录入课程！");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readstudents() {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            Connection connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            String sql = "SELECT * FROM StuMessage";
            statement = connection.createStatement();
            // 执行查询语句
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                // 输出课程信息
                System.out.println("以下是所有学生信息，供参考选择");
                do {
                    int Id = resultSet.getInt("id");
                    String Name = resultSet.getString("name");
                    String major = resultSet.getString("major");
                    String courses = resultSet.getString("courses");
                    int score1 = resultSet.getInt("score1");
                    int score = resultSet.getInt("score");

                    System.out.println("学号: " + Id + " | 学生名字: " + Name + " | 专业: " + major + " | 已选科目: " +
                            courses + " | 应选学分: " + score1 + " | 已选学分: " + score);
                } while (resultSet.next());
            } else {
                System.out.println("当前没有学生信息，请去录入课程！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static <T> T selectOne(String tableName, String columnName, String condition,Class<T> returnType){
        T result = null;

        try {
            // 连接数据库
            Connection conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");


            // 创建 SQL 语句
            String query = "SELECT " + columnName + " FROM " + tableName + " WHERE " + condition + " LIMIT 1";

            // 创建查询语句
            Statement stmt = conn.createStatement();

            // 执行查询
            ResultSet rs = stmt.executeQuery(query);

            // 获取结果
//            if (rs.next()) {
//                result = returnType.cast(rs.getObject(1));
//            }
            if (rs.next()) {
                if (returnType.equals(String.class)) {
                    result = returnType.cast(rs.getString(1));
                } else if (returnType.equals(Integer.class)) {
                    result = returnType.cast(rs.getInt(1));
                } else if (returnType.equals(Double.class)) {
                    result = returnType.cast(rs.getDouble(1));
                } else if (returnType.equals(Boolean.class)) {
                    result = returnType.cast(rs.getBoolean(1));
                } else {
                    // 处理其他类型的转换
                    // ...
                }
            }
            // 关闭连接
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void changeOne (String tableName, String columnName, Object newValue, String condition){
        try {
            // 连接数据库
            Connection conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");

            // 创建 SQL 语句
            String query;
            if (newValue instanceof String || newValue instanceof Date) {
                query = "UPDATE " + tableName + " SET " + columnName + " = '" + newValue + "' WHERE " + condition;
            } else {
                query = "UPDATE " + tableName + " SET " + columnName + " = " + newValue + " WHERE " + condition;
            }
            // 创建查询语句
            Statement stmt = conn.createStatement();

            // 执行更新
            stmt.executeUpdate(query);

            // 关闭连接
            stmt.close();
            conn.close();
            System.out.println("数据修改成功！");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("数据修改失败： " + e.getMessage());
        }
    }
    public static void delete(String tableName, String condition) {
        String sql = "DELETE FROM " + tableName + " WHERE " + condition;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            System.out.println("成功删除行！");

        } catch (SQLException e) {
            System.out.println("删除行失败：" + e.getMessage());
        }
    }
    public static void addline(String tableName, Map<String, Object> values) {
        // 拼接 SQL 插入语句
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO ").append(tableName).append(" (");

        StringBuilder placeholders = new StringBuilder();
        for (String column : values.keySet()) {
            sqlBuilder.append(column).append(", ");
            placeholders.append("?, ");
        }
        sqlBuilder.setLength(sqlBuilder.length() - 2);  // 去除最后一个逗号和空格
        placeholders.setLength(placeholders.length() - 2);  // 去除最后一个逗号和空格

        sqlBuilder.append(") VALUES (").append(placeholders).append(")");
//        try (
//                Connection conn = getConnection();
//                PreparedStatement pstmt = conn.prepareStatement(sqlBuilder.toString())) {
        // 插入数据
        try  {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\soft\\studentServer-main\\src\\main\\resources\\MyDB.sqlite");
            PreparedStatement stmt = conn.prepareStatement(sqlBuilder.toString());

            int index = 1;
            for (Object value : values.values()) {
                stmt.setObject(index++, value);
            }

            stmt.executeUpdate();

            System.out.println("成功添加一行数据！");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("添加数据失败：" + e.getMessage());
        }
    }
}



