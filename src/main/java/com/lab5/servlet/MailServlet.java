package com.lab5.servlet;

import com.lab5.util.Mailer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/send-mail")
public class MailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/mail-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");

        try {
            Mailer.send(from, to, subject, body);
            req.setAttribute("message", "Gửi email thành công!");
        } catch (Exception e) {
            req.setAttribute("message", "Gửi email thất bại: " + e.getMessage());
        }

        req.getRequestDispatcher("/mail-form.jsp").forward(req, resp);
    }
}
