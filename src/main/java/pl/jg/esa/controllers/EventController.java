package pl.jg.esa.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.jg.esa.dto.EventDto;

import java.util.List;

@Controller
public class EventController {

    private final RestTemplate restTemplate;

    public EventController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/search-events")
    public String showEventsFromEAS(
            @RequestParam(required = false) String after,
            @RequestParam(required = false) String before,
            Model model
    ) {
        String url = String.format("http://localhost:8080/api/events?dateFilter=true&after=%s&before=%s", after, before);

        List<EventDto> eventList = restTemplate.getForObject(url, List.class);

        model.addAttribute("after", after);
        model.addAttribute("before", before);
        model.addAttribute("events", eventList);

        return "showFoundEventsView";
    }
}
