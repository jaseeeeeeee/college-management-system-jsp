package com.college.test;

import java.sql.Connection;
import com.college.util.DBConnection;

public class DBTest {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("Connection SUCCESS");
        } else {
            System.out.println("Connection FAILED");
        }
    }
}
