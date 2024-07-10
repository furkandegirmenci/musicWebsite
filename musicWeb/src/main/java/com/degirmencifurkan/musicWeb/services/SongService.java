package com.degirmencifurkan.musicWeb.services;

import com.degirmencifurkan.musicWeb.model.Song;
import com.degirmencifurkan.musicWeb.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    public void addMusic(String fileName, byte[] bytes) {
        Song song = new Song();
        song.setArtist("Temp");
        song.setFavorited(true);
        song.setTitle("title");
        song.setFileName(fileName);

        byte[] data = new byte[50];
        System.arraycopy(bytes,0,data, 0,50);
        song.setContent(data);

        songRepository.save(song);
    }

    public List<Song> getAllMusicsByArtist(String artist) {

        return songRepository.getAllByArtist(artist);
    }
    public List<Song> getAllMusics() {

        return songRepository.findAll();
    }
}
