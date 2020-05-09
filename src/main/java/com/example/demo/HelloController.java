package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


        @GetMapping("/hello/{name}")
        public String index(@PathVariable(name = "name") String name) {

            return "Hola " + name;
        }


}
