package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {

        Optional<Post> Post = repository.findById(id);

        if ( Post.isPresent() ) { return Post.get(); }
        else { throw new ObjectNotFoundException("Post not found! ID: " + id); }

    }

    public List<Post> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 *1000 ) );
        return repository.fullSearch(text,minDate,maxDate);
    }



}
