package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    public final String subtractMap = "/subtract/{number1}/from/{number2}";
    public final String addMap = "/add/{number1}/and/{number2}";
    public final String multiplyMap = "/multiply/{number1}/and/{number2}";
    public final String divideMap = "/divide/{number1}/by/{number2}";


    //add method
    @GetMapping(addMap)
    @ResponseBody
    public String add(@PathVariable int number1, @PathVariable int number2){
        return "<h3>" + number1 + " + " + number2 + " + " +(number1 + number2) + "</h3>";
    }

    //divide method
    @GetMapping(divideMap)
    @ResponseBody
    public String divide(@PathVariable int number1, @PathVariable int number2){
        return "<h3>" + number1 + " / " + number2 + " = " +(number1 / number2) + "</h3>";
    }

    //multiply method
    @GetMapping(multiplyMap)
    @ResponseBody
    public String multiply(@PathVariable int number1, @PathVariable int number2){
        return "<h3>" + number1 + " X " + number2 + " = " +(number1 * number2) + "</h3>";
    }

    //subtract method
    @GetMapping(subtractMap)
    @ResponseBody
    public String subtract(@PathVariable int number1, @PathVariable int number2){
        return "<h3>" + number1 + " - " + number2 + " = " +(number1 - number2) + "</h3>";
    }
}
