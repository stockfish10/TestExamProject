package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    private StyleRepository styleRepository;

    @Autowired
    public StyleService(StyleRepository styleRepository){
        this.styleRepository =styleRepository;
    }


}


