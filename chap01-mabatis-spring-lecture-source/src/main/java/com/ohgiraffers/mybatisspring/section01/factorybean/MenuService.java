package com.ohgiraffers.mybatisspring.section01.factorybean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service                    // bean이 될 수 있는 이유(component scan 범위 이내에 있어야함. => 같은 패키지 안의 Chap01MybatisSpringLectureSourceApplication의 @SpringbootApplication 어노테이션에 componentscan 기능이 있음)
public class MenuService {

    private final SqlSessionTemplate sqlSession;        //getSession을 할 필요가 없음

    @Autowired
    public MenuService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus){
        return sqlSession.getMapper(MenuMapper.class).selectAllMenuByOrderableStatus(orderableStatus);
    }
}
