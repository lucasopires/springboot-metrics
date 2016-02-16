package br.com.javamagazine.metrics.controller;

import br.com.javamagazine.metrics.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lucaso on 16/02/16.
 */
@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

//    @Autowired
//    private CounterService counterService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {

        //counterService.increment("tete");

        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

}