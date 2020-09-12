package by.tms.dao;

import by.tms.entity.User;
import by.tms.entity.UserOperation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDaoImpl implements OperationDao {
    private Connection connection;
    private static OperationDao instance = null;

    private OperationDaoImpl(Connection connection){
        this.connection = connection;
    }

    public static OperationDao getInstance(Connection connection) {
        if (instance == null) {
            instance = new OperationDaoImpl(connection);
        }
        return instance;
    }

    @Override
    public List<UserOperation> getOperationListByUserId(long userId) {
        List<UserOperation> operations = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(GET_USERS_BY_ID);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                operations.add(new UserOperation(
                        resultSet.getInt("user_id"),
                        resultSet.getDate("date"),
                        resultSet.getDouble("num_1"),
                        resultSet.getDouble("num_2"),
                        resultSet.getString("operation"),
                        resultSet.getDouble("result")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (operations.isEmpty()) {
            throw new NoResultException();
        }
        return operations;
    }

    @Override
    public void setOperationList(List<UserOperation> operations) {
        PreparedStatement statement = null;
        for (UserOperation operation : operations) {
            try {
                statement = connection.prepareStatement(SET_USER);
                statement.setLong(1, operation.getUserId());
                statement.addBatch();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            statement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteOperationListByUserId(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USERS_BY_ID);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean operationListByUserIdIsEmpty(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(GET_USERS_BY_ID);
            return !statement.executeQuery().next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
