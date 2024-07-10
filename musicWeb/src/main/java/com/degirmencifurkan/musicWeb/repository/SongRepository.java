package com.degirmencifurkan.musicWeb.repository;

import com.degirmencifurkan.musicWeb.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> getAllByArtist(String artist);

//    boolean existsSongByTitle(String title);

}
