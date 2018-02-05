package com.facemash;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public Database() {
        picturelist = new ArrayList<>();
    }

    static int count;

    private List<PictureForm> picturelist;

//    public static final Logger LOG = Logger.getLogger(com.facemash.Database.class.getName());

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "karina";
    private static final String password = "ilovejava";


    private PictureForm getpicture(int num, Statement stmt) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String query = "select way, rating from picture where id=" + num;
        try (
                ResultSet rs = stmt.executeQuery(query)
        ) {
            PictureForm form = new PictureForm();
            while (rs.next()) {
                form.set(num, rs.getString("way"), rs.getFloat("rating"));
            }
            return form;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }

    public List<PictureForm> getlist() throws ClassNotFoundException, SQLException {
        String query = "select COUNT(*) as total from picture";
        Integer random1 = (int) (Math.random() * count) + 1;
        Integer random2 = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                count = rs.getInt("total");
            }
            rs.close();
            do {
                random2 = (int) (Math.random() * count) + 1;
            } while (random1.equals(random2));

            try {
                picturelist.add(getpicture(random1, stmt));
                picturelist.add(getpicture(random2, stmt));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            connection.close();
        }
        return picturelist;
    }

    public void changepicturerait(Integer id, boolean flag) throws ClassNotFoundException, SQLException {
        String query;
        float rate = 0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement();
            query = "SELECT rating FROM picture WHERE id=" + id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                rate = rs.getFloat("rating");
            }
            rs.close();
            rate = (flag) ? rate + 1 : rate - 1;
            query = "UPDATE picture SET rating=" + rate + "WHERE id=" + id;
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            connection.close();
        }
    }

}

