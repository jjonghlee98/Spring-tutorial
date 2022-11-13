package org.jdbcex.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    TodoDAO todoDAO;

    @BeforeEach
    public void ready() {

        todoDAO = new TodoDAO();

    }

    @Test
    public void testTime() throws Exception {

        System.out.println(todoDAO.getTime2());

    }

    @Test
    public void testInsert() throws Exception {

        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2022, 11, 12))
                .build();

        todoDAO.insert(todoVO);

    }

    @Test
    public void testSelectAll() throws Exception {

        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));

    }

    @Test
    public void testSelectOne() throws Exception {

        Long tno = 1L;

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);

    }

    @Test
    public void testUpdateOne() throws Exception {

        Long tno = 1L;

        TodoVO todoVO = TodoVO.builder()
                .tno(tno)
                .title("Sample...Todo")
                .dueDate(LocalDate.of(2022, 12, 25))
                .finished(true)
                .build();


        todoDAO.updateOne(todoVO);

    }

}
