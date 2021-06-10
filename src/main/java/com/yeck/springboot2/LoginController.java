package com.yeck.springboot2;

import entity.LoginBack;
import entity.TestClass;
import net.minidev.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


@RestController
public class LoginController {
    String resource = "conf.xml";
    InputStream is = Resources.getResourceAsStream(resource);
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
    SqlSession session = sessionFactory.openSession();

    public LoginController() throws IOException {
    }

    @PostMapping("/login")
    public LoginBack login(@RequestBody JSONObject jsonParam) {
        String statement = "com.yeck.springboot2.Mapper.userMapper.getUser";
        user user1 = session.selectOne(statement, jsonParam.get("username"));
        if (user1 == null){
            return new LoginBack("false");
        }
        if (user1.getPassword().equals(jsonParam.get("password"))) {
            return new LoginBack("true");
        } else {
            return new LoginBack("false");
        }
    }

    @PostMapping("/reg")
    public LoginBack reg(@RequestBody JSONObject jsonParam) {
        String statement = "com.yeck.springboot2.Mapper.userMapper.regUser";
        String statement2 = "com.yeck.springboot2.Mapper.userMapper.getUser";

        user try1 = session.selectOne(statement2, jsonParam.get("username"));
        if (try1 != null){
            return new LoginBack("false");
        }

        int res = session.insert(statement, jsonParam);
        session.commit();
        if (res == 1){
            return new LoginBack("true");
        } else {
            return new LoginBack("false");
        }
    }
}
