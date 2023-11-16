package io.kai.bookcatalogservice.resources;

import io.kai.bookcatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {
    @RequestMapping("/{userId}")
public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
       return Collections.singletonList(
               new CatalogItem("The Alchemist", "A book about following your dreams", 4)
       );
    }
}
