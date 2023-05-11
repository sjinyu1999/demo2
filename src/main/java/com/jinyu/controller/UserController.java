package com.jinyu.controller;

import com.jinyu.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
//    读取yml数据中的单一数据
    @Value("${country}")
    private String country;

    //    读取yml数据中的数组数据
    @Value("${array[0]}")
    private String array;
    //    读取yml数据中的map数据
    @Value("${map.key1}")
    private String map;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${datasource.password}")
    private String password;

//    使用自动装配的方式，将所有的配置文件中的数据都注入到一个对象中
    @Autowired
    private Environment environment;

//    定义 MyDataSource 对象，用于接收配置文件中的数据
    @Autowired
    private MyDataSource myDataSource;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        System.out.println("hello user....");
        System.out.println("country:"+country);
        System.out.println("array:"+array);
        System.out.println("map:"+map);
        System.out.println("tempDir:"+tempDir);
        System.out.println("environment:"+environment.getProperty("country"));
        System.out.println("myDataSource:"+myDataSource);
        return "{'module':'user','method':'hello'}";
    }
//    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    @PostMapping(value = "/users/{id}")
    @ResponseBody
    public String save(@PathVariable Integer id){
        System.out.println("save user....");
        return "{'module':'user','method':'save' , 'id':"+id+"}";
    }
//    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/users")
    @ResponseBody
    public String delete(){
        System.out.println("delete user....");
        return "{'module':'user','method':'delete'}";
    }
//    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @PutMapping(value = "/users")
    @ResponseBody
    public String update(){
        System.out.println("update user....");
        return "{'module':'user','method':'update'}";
    }

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping(value = "/users")
    @ResponseBody
    public String list(){
        System.out.println("list user....");
        System.out.println("password:"+password);
        return "{'module':'user','method':'list'}";
    }
}
