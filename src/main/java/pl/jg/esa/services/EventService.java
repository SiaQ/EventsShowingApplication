package pl.jg.esa.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.jg.esa.dto.EventDto;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    public List<EventDto> getEvents() {
        RestTemplate restTemplate = new RestTemplate();
        List<EventDto> events = restTemplate.getForObject("http://localhost:8080/future-events", List.class);

        return events;
    }

    public List<EventDto> getEventsBetween(String after, String before) {
        RestTemplate restTemplate = new RestTemplate();

        String URL = String.format("http://localhost:8080/future-events?dateFilter=true&after=%s&before=%s", after, before);

        List<EventDto> events = restTemplate.getForObject(URL, List.class);

        return events;
    }
}
