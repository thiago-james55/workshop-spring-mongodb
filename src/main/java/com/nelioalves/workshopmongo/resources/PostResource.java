package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.resources.exception.util.URL;
import com.nelioalves.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/titlesearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findbyTitle(@RequestParam(value = "text",defaultValue = "") String title) {

        title = URL.decodeParam(title);

        List<Post> posts = service.findByTitle(title);

        return ResponseEntity.ok().body(posts);

    }
    @RequestMapping(value = "/fullsearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text",defaultValue = "") String text,
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate) {


        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> posts = service.fullSearch(text,min,max);

        return ResponseEntity.ok().body(posts);

    }

}
