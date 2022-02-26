package com.banyibu.springboot01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class JDBCIntegrateController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/get_all")
    public List<Map<String, Object>> getAllData(){
        String sql = "select * from account";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/add")
    public String add(){
        String sql = "insert into account(id,name,money) values(4,'张三', 10000)";
        int r = jdbcTemplate.update(sql);
        return "OK"+r;
    }

    @GetMapping("/update")
    public String update(@RequestParam(name = "id") int id){
        String sql = "update account set name = ?, money = ? where id ="+id;
        Object[] objects = new Object[2];
        objects[0] = "李四";
        objects[1] = 2333;
        int r = jdbcTemplate.update(sql, objects);
        return "OK" + r;
    }

    @GetMapping("/delete")
    public String deleteOne(@RequestParam(name = "id") int id){
        String sql = "delete from account where id =?";
        int r = jdbcTemplate.update(sql, id);
        return "OK" + r;
    }

}
