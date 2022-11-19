package org.zerock.w2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("/todo/register");

        HttpSession session = req.getSession();

        if (session.isNew()) {

            log.info("JSESSIONID 쿠기가 새로 만들어진 사용자");
            resp.sendRedirect("/login");
            return;

        }

        if (session.getAttribute("loginInfo") == null) {

            log.info("로그인 정보가 없는 사용자");
            resp.sendRedirect("/login");
            return;

        }

        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();

        log.info("/todo/register....POST");
        log.info(todoDTO);

        try {

            todoService.register(todoDTO);

        } catch (Exception e) {

            e.printStackTrace();

        }

        resp.sendRedirect("/todo/list");

    }
}
