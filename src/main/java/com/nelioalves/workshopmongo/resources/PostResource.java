package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findbyId(@PathVariable String id) {

        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);

    }

}
