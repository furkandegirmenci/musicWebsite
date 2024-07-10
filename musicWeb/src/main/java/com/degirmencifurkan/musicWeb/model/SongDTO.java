package com.degirmencifurkan.musicWeb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    private String fileName;

    private String title;

    private String artist;

    private boolean isFavorited;

}
