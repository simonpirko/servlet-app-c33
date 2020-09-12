package by.tms.dao;

import by.tms.entity.UserOperation;
import java.util.List;

public interface OperationDao {
    String SET_USER = "INSERT INTO operation VALUES (default, ?, ?, ?, ?, ?)";
    String GET_USERS_BY_ID = "SELECT * FROM operations WHERE user_id = ?";
    String DELETE_USERS_BY_ID = "DELETE FROM operations WHERE user_id = ?";

    List<UserOperation> getOperationListByUserId(long userId);
    void setOperationList(List<UserOperation> operations);
    void deleteOperationListByUserId(long id);
    boolean operationListByUserIdIsEmpty(long id);
}
