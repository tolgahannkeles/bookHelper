package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseTransactions {
    String url = "jdbc:mysql://localhost:3306/books";
    String username = "root";
    String password = "123456";

    Connection connection;

    public DatabaseTransactions() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insertLanguages(int id, String language) {
        String sql = "INSERT INTO language (id,language) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, language);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertAuthors(int id, String name, String surname, String biography, String imageLink) {
        String sql = "INSERT INTO author (id,name,surname,biography,imageLink) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, biography);
            preparedStatement.setString(5, imageLink);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertCategories(int id, String category, String imageLink) {
        String sql = "INSERT INTO category (id,name,imageLink) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, imageLink);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertPublishers(int id, String name) {
        String sql = "INSERT INTO publisher (id,name) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertTypes(int id, String name) {
        String sql = "INSERT INTO type (id,name) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    void insertBooks(String authorId, String publisherId, String languageId, String name, String description, String isbn, String imageLink, String releaseYear, int pageCount) {
        String sql = "INSERT INTO book (authorId, publisherId, languageId, name, description, isbn, imageLink, releaseDate, pageCount) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, authorId);
            preparedStatement.setString(2, publisherId);
            preparedStatement.setString(3, languageId);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, description);
            preparedStatement.setString(6, isbn);
            preparedStatement.setString(7, imageLink);
            preparedStatement.setString(8, releaseYear);
            preparedStatement.setInt(9, pageCount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertCategoryJun(int bookId, int categoryId) {
        String sql = "INSERT INTO categoryJunction (bookId, categoryId) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertTypeJun(int bookId, int typeId) {
        String sql = "INSERT INTO typeJunction (bookId, typeId) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, typeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}