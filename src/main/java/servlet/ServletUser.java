package servlet;

import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/owners")
public class ServletUser extends HttpServlet {
//    private final UserService USER_SERVICE = UserService.getInstance();
//    List<UserDTO> listUserDTO = USER_SERVICE.getAllOwners();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        try (PrintWriter writer = resp.getWriter()) {
//            writer.write("<h1>Hello world, its my second servlet!<h1>");
//        }
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Hello, World<h1/>");
//            writer.write("<ul>");
//            listUserDTO.forEach(userDTO -> writer.write("<li>" + userDTO.getFirstName() + userDTO.getLastName() + "</li>"));
//            writer.write("</ul>");
        }
    }


}
