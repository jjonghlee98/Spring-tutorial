package org.zerock.w2.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.zerock.w2.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public class MemberDAO {

    public MemberVO getWithMember(String mid, String mpw) throws Exception {

        String query = "select * from tbl_member where mid = ? and mpw = ?";

//        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();

        return memberVO;

    }

}
