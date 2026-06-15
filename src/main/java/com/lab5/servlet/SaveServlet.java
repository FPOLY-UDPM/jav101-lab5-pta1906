package com.lab5.servlet;

import com.lab5.bean.Staff;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/staff-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Staff bean = new Staff(); // dùng để chứa dữ liệu form
        try {
            // Khai báo định dạng ngày
            DateConverter dtc = new DateConverter();
            dtc.setPattern("MM/dd/yyyy");
            ConvertUtils.register(dtc, Date.class);

            // đọc và chuyển đổi tham số vào bean
            BeanUtils.populate(bean, req.getParameterMap());

            System.out.println(bean);
            System.out.println("Fullname: " + bean.getFullname());
            System.out.println("Birthday: " + bean.getBirthday());
            System.out.println("Gender: " + bean.isGender());
            System.out.println("Hobbies: " + java.util.Arrays.toString(bean.getHobbies()));
            System.out.println("Country: " + bean.getCountry());
            System.out.println("Salary: " + bean.getSalary());
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("staff", bean);
        req.getRequestDispatcher("/staff-result.jsp").forward(req, resp);
    }
}
