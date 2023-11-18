package io.kai.bookcatalogservice.resources;

import io.kai.bookcatalogservice.models.Book;
import io.kai.bookcatalogservice.models.CatalogItem;
import io.kai.bookcatalogservice.models.Rating;
import io.kai.bookcatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/{userId}")
public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        UserRating ratings = restTemplate.getForObject("http://localhost:8082/ratings/users/" + userId, UserRating.class);
       return ratings.getUserRating().stream().map(rating -> {
           Book book = restTemplate.getForObject("http://localhost:8081/books/" + rating.getBookID(), Book.class);
             return new CatalogItem(book.getBookName(), "Description", rating.getRating());
        }).collect(Collectors.toList());
//       return Collections.singletonList(
//               new CatalogItem("The Alchemist", "A book about following your dreams", 4)
//       );
    }
}
