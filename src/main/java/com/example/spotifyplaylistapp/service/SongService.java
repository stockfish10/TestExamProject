package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Service
public class SongService {

    private SongRepository songRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void addSong(SongAddDTO songAddDTO) throws ParseException {
        SongEntity newSong = new SongEntity()
                .setPerformer(songAddDTO.getPerformer())
                .setTitle(songAddDTO.getTitle())
                .setDuration(songAddDTO.getDuration())
                .setReleaseDate(formatter.parse(songAddDTO.getReleaseDate()));

        songRepository.save(newSong);
    }
}
