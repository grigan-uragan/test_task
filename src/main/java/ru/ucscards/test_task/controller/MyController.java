package ru.ucscards.test_task.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ucscards.test_task.model.Data;
import ru.ucscards.test_task.model.Response;
import ru.ucscards.test_task.service.Service;

@RestController
@RequestMapping("/bykey")
public class MyController {
    @Autowired
    private Service service;

    @GetMapping("/getjson")
    public String returnJsonData(@RequestParam("key") int key) {
        Data byId = service.getDataById(key);
        Response response = new Response();
        response.setData(byId);
        if (byId == null) {
            response.setResponse("There is no data with key = " + key + " in DB");
        } else {
            response.setResponse("ok");
        }
        response.setRequest(String.valueOf(key));
        Gson gson = new GsonBuilder().create();
        return gson.toJson(response);
    }

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e) {
        Response resp = new Response();
        resp.setResponse(e.getMessage());
        Gson gson = new GsonBuilder().create();
        String response = gson.toJson(resp);
        return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
    }

}
