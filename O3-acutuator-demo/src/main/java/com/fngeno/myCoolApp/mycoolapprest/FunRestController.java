package com.fngeno.myCoolApp.mycoolapprest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello world! Time on server is "
                + LocalDateTime.now();
    }
    @GetMapping("/workout")
    public String dailyWorkout(){
        return "run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String dailyFortune(){
        return "Today is your Lucky Day!";
    }

}
