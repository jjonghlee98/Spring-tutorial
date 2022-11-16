package org.jdbcex.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {

        todoDAO = new TodoDAO();

    }

    @Test
    public void testGetTime() throws Exception {

        System.out.println(todoDAO.getTime());

    }

    @Test
    public void testGetTime2() throws Exception {

        System.out.println(todoDAO.getTime2());

    }

    @Test
    public void testInsert() throws Exception {

        TodoVO vo = TodoVO.builder()
                .title("Sample...Todo")
                .dueDate(LocalDate.now())
                .build();

        System.out.println(vo);

        todoDAO.insert(vo);

    }

    @Test
    public void testSelectAll() throws Exception {

        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));

    }

    @Test
    public void testSelectOne() throws Exception {

        Long tno = 3L;

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);

    }

    @Test
    public void testUpdateOne() throws Exception {

        TodoVO vo = TodoVO.builder()
                .tno((long) 1)
                .title("Update Todo")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        todoDAO.updateOne(vo);

    }

}
