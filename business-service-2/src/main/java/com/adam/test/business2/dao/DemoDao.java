package com.adam.test.business2.dao;

import com.adam.test.business2.model.Demo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Adam.Zhang on 2017/9/13.
 */
@Component
public class DemoDao {

    private SqlSession sqlSession;

    public DemoDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Demo> findAll() {
        return sqlSession.selectList("findAll");
    }

    public void insert(Demo demo) {
        sqlSession.insert("insertDemo", demo);
    }

}
