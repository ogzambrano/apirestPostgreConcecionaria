package com.example.apirestpostgreconcecionaria.rest;


import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String index() {


        return """
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="ISO-8859-1">
				<title>Awesome API REST</title>
				</head>
				<body>
				<h1 style="color:red;">Bienvenido a la API extraterrestre</h1>
				<a href="/api/cars">Cars Database</a>
				
				</body>
				</html>
				""";
    }

    @GetMapping("/api/hello")
    public String hello() {
        log.info("Executing hello world method from logger");
        // diferentes niveles de logger:
        // log.warn("Executing hello world method from logger");
        // log.error("Executing hello world method from logger");
        return "Hola mundo";
    }

    @GetMapping("/api/bye")
    public String bye() {
        log.info("Executing bye world method from logger");
        // diferentes niveles de logger:
        // log.warn("Executing hello world method from logger");
        // log.error("Executing hello world method from logger");
        return "Adios mundo";
    }
}
