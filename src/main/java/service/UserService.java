package service;

import dao.UserDAO;
import dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserDAO userDAO = UserDAO.getInstance();
    private static final UserService INSTANCE = new UserService();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public List<UserDTO> getAllOwners() {
        return userDAO.getUsers().stream()
                .map(user -> new UserDTO(
                        user.getFirstName(),
                        user.getLastName()
                ))
                .collect(Collectors.toList());
    }
}
