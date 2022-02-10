package dao;

import entity.User;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements dao<Integer, User> {
    private static final UserDAO INSTANCE = new UserDAO();
    private static final String GET_USERS_QUERY = "select id, firstName, lastName, phoneModel, mobileOperator from schema_servlet_phonebase.owners";

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public User addUser(User entity) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> listUser = new ArrayList<>();
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listUser.add(mapUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public boolean deleteUser(Integer id) {

        return false;
    }

    private User mapUser(ResultSet resultSet) {
        try {
            return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("phoneModel"),
                    resultSet.getString("mobilOperator")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
