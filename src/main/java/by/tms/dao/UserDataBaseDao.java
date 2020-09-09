package by.tms.dao;

import by.tms.entity.User;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDataBaseDao implements UserDao {
    private Connection connection;
    private static final String CREATE_USER = "INSERT INTO users VALUES (default, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String UPDATE_BY_ID = "UPDATE users SET login = ?, name = ?, password = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";

    private static UserDao instance = null;

    private UserDataBaseDao(Connection connection) {
        this.connection = connection;
    }

    public static UserDao getInstance(Connection connection){
        if (instance == null){
            return new UserDataBaseDao(connection);
        }else {
            return instance;
        }
    }

    @Override
    public void create(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(CREATE_USER);
            st.setString(1,user.getLogin());
            st.setString(2,user.getName());
            st.setString(3,user.getPassword());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_ID);
            st.setLong(1, id);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getByLogin(String login) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_LOGIN);
            st.setString(1,login);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()){
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new UserNotFoundException();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(GET_ALL);
            while (resultSet.next()) {
                users.add(new User(
                                resultSet.getString("name"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (users.isEmpty()) {
            throw new NoResultException();
        }
        return users;
    }

    @Override
    public void updateById(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(UPDATE_BY_ID);
            st.setString(1, user.getLogin());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setLong(4, user.getId());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(DELETE_BY_ID);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean containsById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_ID);
            st.setLong(1, id);
            return st.executeQuery().next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsByLogin(String login) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_LOGIN);
            st.setString(1, login);
            return st.executeQuery().next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
        UserDao userDao = new UserDataBaseDao(connection);
//        System.out.println(userDao.getAll());
        userDao.create(new User("Vasia@12", "Vasilij", "13579"));
        userDao.create(new User("Sasha@12", "Aleksandr", "02468"));
        System.out.println(userDao.containsById(9));
        System.out.println(userDao.containsByLogin("Sasdasd"));
    }
}
