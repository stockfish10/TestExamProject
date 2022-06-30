package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.model.enums.StyleEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class SongAddDTO {

    @NotEmpty(message = "Performer name is required")
    @Size(min = 3,max = 20, message = "Name must be between 3 and 20 characters")
    private String performer;

    @NotEmpty(message = "Song title is required")
    @Size(min = 2,max = 20, message = "Song title must be between 2 and 20 characters")
    private String title;

    private String releaseDate;

    @NotNull(message = "Duration is required")
    @Min(value = 1,message = "Duration time must be positive")
    private Double duration;

    @NotNull(message = "Style must be selected")
    private StyleEnum style;

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public StyleEnum getStyle() {
        return style;
    }

    public void setStyle(StyleEnum style) {
        this.style = style;
    }
}
