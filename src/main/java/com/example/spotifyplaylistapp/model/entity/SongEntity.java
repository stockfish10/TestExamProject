package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "songs")
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String performer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double duration;

    @Column(name = "release_date")
    private Date releaseDate;

    @OneToMany(fetch = FetchType.EAGER)
    private List<StyleEntity> style = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public SongEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongEntity setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public Double getDuration() {
        return duration;
    }

    public SongEntity setDuration(Double duration) {
        this.duration = duration;
        return this;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public SongEntity setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }
}
