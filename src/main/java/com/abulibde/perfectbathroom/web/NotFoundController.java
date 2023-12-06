package com.abulibde.perfectbathroom.web;

import com.abulibde.perfectbathroom.exception.ObjectNotFoundException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NotFoundController {

    @GetMapping("/not-found/{id}")
    public String notFound(@PathVariable("id") String id) {
        throw new ObjectNotFoundException("Object with id " + id + " was not found!", id);
    }
}
