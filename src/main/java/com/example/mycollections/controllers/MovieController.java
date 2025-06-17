package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final List<Movie> movie = new ArrayList<>() {{
        add(new Movie("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
        add(new Movie("To Kill a Mockingbird", "Harper Lee", 1960, 281));
        add(new Movie("1984", "George Orwell", 1949, 328));
    }};

    @GetMapping("/json")
    public List<Movie> getMovieJson() {
        return movie;
    }

    @GetMapping("/html")
    public String getMovieHtml() {
        String movieList = "<ul>";
        for (Movie movie : movie) {
            movieList += "<li>" + movie + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }

}