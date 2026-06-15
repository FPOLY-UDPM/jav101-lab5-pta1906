package com.lab5.servlet;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    String encoded = cookie.getValue();
                    byte[] bytes = Base64.decodeBase64(encoded);
                    String[] userInfo = new String(bytes).split(",");
                    req.setAttribute("username", userInfo[0]);
                    req.setAttribute("password", userInfo[1]);
                }
            }
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");

        if (username.equalsIgnoreCase("FPT") && password.equals("poly")) {
            req.setAttribute("message", "Login successfully!");
            req.getSession().setAttribute("username", username); // session

            if (remember != null) {
                byte[] bytes = (username + "," + password).getBytes();
                String userInfo = Base64.encodeBase64String(bytes);
                Cookie cookie = new Cookie("user", userInfo);
                cookie.setMaxAge(30 * 24 * 60 * 60); // hiệu lực 30 ngày
                cookie.setPath("/"); // hiệu lực toàn ứng dụng
                // Gửi về trình duyệt
                resp.addCookie(cookie); // cookie
            }
        } else {
            req.setAttribute("message", "Invalid login info!");
        }

        req.setAttribute("username", username);
        req.setAttribute("password", password);

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
