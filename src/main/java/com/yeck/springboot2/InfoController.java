package com.yeck.springboot2;

import entity.InfoBack1;
import entity.InfoBack2;
import net.minidev.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class InfoController {
    String resource = "conf.xml";
    InputStream is = Resources.getResourceAsStream(resource);
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
    SqlSession session = sessionFactory.openSession();

    public InfoController() throws IOException {
    }

    @GetMapping("/getStudents")
    public List<InfoBack1> getStudents() {
        String statement = "com.yeck.springboot2.Mapper.infoMapper.getStudents";
        return session.selectList(statement, null);
    }

    @PostMapping("/addStudent")
    public InfoBack2 addStudents(@RequestBody JSONObject jsonParam) {
        String statement = "com.yeck.springboot2.Mapper.infoMapper.addStudents";
        int res = session.insert(statement, jsonParam);
        session.commit();
        InfoBack2 infoBack2 = new InfoBack2();
        if (res == 1) {
            infoBack2.success = "success";
        } else {
            infoBack2.success = "false";
        }
        return infoBack2;
    }

    @PostMapping("/editStudent")
    public InfoBack2 editStudents(@RequestBody JSONObject jsonParam) {
        String statement = "com.yeck.springboot2.Mapper.infoMapper.editStudent";
        int res = session.update(statement, jsonParam);
        session.commit();
        InfoBack2 infoBack2 = new InfoBack2();
        if (res == 1) {
            infoBack2.success = "success";
        } else {
            infoBack2.success = "false";
        }
        return infoBack2;
    }

    @PostMapping("/delStudent")
    public InfoBack2 delStudent(@RequestBody JSONObject jsonParam) {
        String statement = "com.yeck.springboot2.Mapper.infoMapper.delStudent";
        int res = session.delete(statement, jsonParam);
        session.commit();
        InfoBack2 infoBack2 = new InfoBack2();
        if (res == 1) {
            infoBack2.success = "success";
        } else {
            infoBack2.success = "false";
        }
        return infoBack2;
    }

    @PostMapping("/filterStudent")
    public List<InfoBack1> filterStudent(@RequestBody JSONObject jsonParam) {
        String statement = "com.yeck.springboot2.Mapper.infoMapper.filterStudent";
        jsonParam.replace("name", "%" + jsonParam.get("name") + "%");
        jsonParam.replace("type", "%" + jsonParam.get("type") + "%");
        jsonParam.replace("Sclass", "%" + jsonParam.get("Sclass") + "%");
        if (jsonParam.get("age").equals("")){
            jsonParam.replace("age", "%");
        }
        if (jsonParam.get("sex").equals("")){
            jsonParam.replace("sex", "%");
        }
        if (jsonParam.get("idNo").equals("")){
            jsonParam.replace("idNo", "%");
        }
        return session.selectList(statement, jsonParam);
    }
}
