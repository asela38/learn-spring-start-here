package server.controllers;

import models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "Cheese and Wine")
                .body(Country.builder().name("France").population(67).build());

    }

    @GetMapping("/all")
    public List<Country> all() {
        return List.of(
                Country.builder().name("France").population(67).build(),
                Country.builder().name("Spain").population(47).build()
        );
    }


}
