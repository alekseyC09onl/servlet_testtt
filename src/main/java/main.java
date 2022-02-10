import dao.UserDAO;
import dto.UserDTO;
import entity.User;
import service.UserService;
import util.ConnectionManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class main {
    public static void main(String[] args) {
//        UserService USER_SERVICE = UserService.getInstance();
//        List<UserDTO> listUserDTO = USER_SERVICE.getAllOwners();
//        if (!listUserDTO.isEmpty()) {
//            listUserDTO.stream()
//                    .forEach(userDTO -> System.out.println(userDTO.getFirstName() + userDTO.getLastName()));
//        } else {
//            System.out.println("empty");
//        }
//        UserDAO userDAO = UserDAO.getInstance();
//        userDAO.getUsers().stream()
//                .forEach(user -> user.toString());
        Properties properties = new Properties();
        Connection connection = null;
        String url;
        String user;
        String password;
        try (InputStream inputStream = Files.newInputStream(Path.of("C:\\Users\\Admin\\IdeaProjects\\servlet_testtt\\src\\main\\resources\\application.properties"))) {
            properties.load(inputStream);
            url = properties.getProperty("dbUrl");
            user = properties.getProperty("dbUser");
            password = properties.getProperty("dbPassword");
            connection = DriverManager.getConnection(url, user, password);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        List<User> listUser = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, firstName, lastName, phoneModel, mobileOperator from schema_servlet_phonebase.owners");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listUser.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phoneModel"),
                        resultSet.getString("mobileOperator")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        listUser.stream()
                .forEach(user1 -> System.out.println(user1.toString()));


//        public User mapUser(ResultSet resultSet) {
//            try {
//                return new User(
//                        resultSet.getInt("id"),
//                        resultSet.getString("firstName"),
//                        resultSet.getString("lastName"),
//                        resultSet.getString("phoneModel"),
//                        resultSet.getString("mobilOperator")
//                );
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
    }
}
