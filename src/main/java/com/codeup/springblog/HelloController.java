package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //Use curly braces to establish Path Variables in the mapping definition
    @GetMapping("/hello")
    @ResponseBody
    //
    public String hello(@PathVariable String name){
        return "Hello, " + name + " ! ";
    }
    @GetMapping("/test")
    @ResponseBody
    public  String test(){
        return "test";
    }

    // Request Mapping
    //@GetMapping("/increment/{number}")
    @RequestMapping(path = )
}
