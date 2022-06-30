package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleEnum;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class StyleEntity extends BaseEntity{

    @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private StyleEnum styleName;

    @Column
    private String description;

    public StyleEnum getStyleName() {
        return styleName;
    }

    public StyleEntity setStyleName(StyleEnum styleName) {
        this.styleName = styleName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StyleEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
