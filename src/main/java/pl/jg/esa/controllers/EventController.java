package pl.jg.esa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jg.esa.services.EventService;

import java.time.LocalDate;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/search-events")
    public String showEventsFromEAS(
            @RequestParam(required = false) String after,
            @RequestParam(required = false) String before,
            Model model
    ) {
        model.addAttribute("after", after);
        model.addAttribute("before", before);
        model.addAttribute("events", eventService.getEventsBetween(after, before));

        return "showFoundEventsView";
    }
}
