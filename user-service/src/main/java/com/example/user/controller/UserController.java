package com.example.user.controller;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.Userd;
import com.example.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    public static final String USER_SERVICE= "userService";
    @PostMapping("/")
    public Userd saveUser(@RequestBody Userd user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableDeparments")
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserController:" +userId);


            ResponseTemplateVO resp= userService.getUserWithDepartment(userId);

            log.error("Resp is "+resp);

            return resp;
    }

    public ResponseTemplateVO getAllAvailableDeparments(Exception e){

        log.error("Inside fallback method with exception :"+e);

        ResponseTemplateVO vo= new ResponseTemplateVO(); //hard-coded
        Userd user= new Userd(20L,"Shinchan","Nohara","shinchan.nohara@hungama.com", 1L);
        Department department =  new Department(20L, "Success Factors", "Kundalahalli","SFPAY");
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
