package pl.jg.esa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jg.esa.services.EventService;

@Controller
public class HomePageController {

    private final EventService eventService;

    public HomePageController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String showHomePage(
            Model model
    ) {
        model.addAttribute("events", eventService.getEvents());
        return "homePage";
    }
}
