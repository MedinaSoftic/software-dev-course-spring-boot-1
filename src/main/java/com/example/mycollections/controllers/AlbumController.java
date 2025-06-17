package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private final List<Album> album = new ArrayList<>() {{
        add(new Album("I Said I Love You First", "Selena Gomez",2025, 14));
        add(new Album("Rare", "Selena Gomez", 2020, 13));
        add(new Album("For You", "Selena Gomez", 2014, 15));
    }};

    @GetMapping("/json")
    public List<Album> getAlbumJson() {
        return album;
    }

    @GetMapping("/html")
    public String getAlbumHtml() {
        String albumList = "<ul>";
        for (Album album : album) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Album</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }

}
