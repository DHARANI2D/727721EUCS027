package com.example.demo.Controller;

import com.example.demo.Service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/numbers")
public class CalcController {

    @Autowired
    private CalcService service;

    @GetMapping("/{numberid}")
    public Map<String, Object> getNumbers(@PathVariable String numberid) {
        return service.getNumbers(numberid);
    }
}
