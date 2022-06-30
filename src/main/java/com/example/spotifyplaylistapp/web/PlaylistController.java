package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class PlaylistController {

    private SongService songService;

    public PlaylistController(SongService songService) {
        this.songService = songService;
    }

    @ModelAttribute("addSongModel")
    public void initSongModel(Model model){
        model.addAttribute("addSongModel", new SongAddDTO());
    }

    @GetMapping("/song-add")
    public String addSong(){
        return "song-add";
    }

    @PostMapping("/song-add")
    public String addSong(@Valid SongAddDTO addSongModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) throws ParseException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addSongModel", addSongModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongModel", bindingResult);

            return "redirect:/song-add";
        }
        songService.addSong(addSongModel);
        return "redirect:/home";
    }

}
