package com.ganesh.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection connection = null;

    static
    {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "ganesh", "ganesh");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return connection;
    }

    public static void close()
    {
        try {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
