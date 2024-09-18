package org.payment.gui.test;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {


    @QueryMapping
    List<Post> findAllPosts() {
        return Arrays.asList(
                new Post("1", "First Post", "first-post", LocalDate.now(), 5, "spring, graphql", 1),
                new Post("2", "Second Post", "second-post", LocalDate.now(), 10, "spring, graphql", 1),
                new Post("3", "Third Post", "third-post", LocalDate.now(), 15, "spring, graphql", 1)
        );
    }

    @QueryMapping
    Optional<Post> findPostById(@Argument String id) {
        Post post = new Post("1", "First Post", "first-post", null, 5, "spring, graphql", 1);
        return Optional.of(post);
    }

}

