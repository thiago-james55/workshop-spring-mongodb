package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {

        User maria = new User("1","Maria","maria@gmail.com");
        User mario = new User("2","Mario","mario@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(maria,mario));

        return ResponseEntity.ok().body(list);

    }

}
