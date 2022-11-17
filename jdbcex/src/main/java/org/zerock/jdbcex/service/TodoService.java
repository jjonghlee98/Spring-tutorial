package org.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {

    INSTANCE;

    private TodoDAO dao;

    private ModelMapper modelMapper;

    TodoService() {

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    public void register(TodoDTO todoDTO) throws Exception {

        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);

        log.info(vo);

        dao.insert(vo);

    }

    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = dao.selectAll();

        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;

    }

    public TodoDTO read(Long tno) throws Exception {

        TodoVO vo = dao.selectOne(tno);

        log.info(vo);

        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);

        return dto;

    }

    public void remove(Long tno) throws Exception {

        log.info("----- delete -----");

        dao.deleteOne(tno);

    }

    public void modify(TodoDTO todoDTO) throws Exception {

        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);

        log.info(vo);

        dao.updateOne(vo);

    }


}
