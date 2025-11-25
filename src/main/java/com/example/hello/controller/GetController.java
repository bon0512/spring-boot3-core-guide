package com.example.hello.controller;


import com.example.hello.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        log.info("get hello 메서드가 출력 되었습니다.");
        return "Hello world";
    }

    @GetMapping(value = "/name")
    public String getName(){

        log.info("getName 메서드가 호출 되었습니다.");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping(value = "/request1")
    public String getRequestParm1(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return name + " " + email + " "+ organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder();
        param.forEach((key,value)-> sb.append(key+" : "+value+"\n"));

        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public MemberDto getRequestParam3(MemberDto memberDto){

        return memberDto;
    }
}
