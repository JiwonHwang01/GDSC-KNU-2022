package com.example.study1.controller;

import com.example.study1.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //Localhost:9090/api 까지 매핑이 됨
public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("getParameter") //Localhost:9090/api/getParameter?id=1235&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam String password){

        System.out.println("id : " + id);
        System.out.println("pw : " + password);

        return id+password;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //{ "account" : "", "email" : "", "page" : 0}
        return searchParam;
    }
}
