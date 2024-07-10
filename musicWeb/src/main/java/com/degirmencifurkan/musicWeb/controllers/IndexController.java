package com.degirmencifurkan.musicWeb.controllers;

import com.degirmencifurkan.musicWeb.model.Song;
import com.degirmencifurkan.musicWeb.model.SongDTO;
import com.degirmencifurkan.musicWeb.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "music")
public class IndexController {

    private static final Object UPLOADED_FOLDER = "/files/";
    private SongService songService;

    IndexController(SongService songService) {
        this.songService = songService;
    }


    @PostMapping(path = "/add")
    public String addMusic(Model model, @RequestParam("file")MultipartFile file/*, @RequestBody SongDTO song*/) throws IOException {
        songService.addMusic(file.getOriginalFilename(), file.getBytes());
        System.out.println("success add");
        model.addAttribute("message", "success");
        List<Song> songList = songService.getAllMusics();
        model.addAttribute("list", songList);
        return "index";
    }

    @PostMapping(path = "/getAllByArtist")
    public List<Song> getAllMusicByArtist(@RequestBody SongDTO song) {
        return songService.getAllMusicsByArtist(song.getArtist());

    }

    @GetMapping(path = "/getAll")
    public List<Song> getAllMusic() {
        return songService.getAllMusics();
    }






/*
    private final StorageService storageService;

    @Autowired
    public IndexController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("songs", storageService.getSongFileNames());
        return "index";

    }

    @PostMapping
    public String handleFileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        storageService.uploadSong(file);
        return "redirect:/";
    }*/
}
