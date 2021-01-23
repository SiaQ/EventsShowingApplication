package pl.jg.esa.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.jg.esa.dto.EventDto;

import java.util.List;

@Service
public class EventService {

    public List<EventDto> getEvents() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/future-events", List.class);
    }

    public List<EventDto> getEventsBetween(String after, String before) {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("http://localhost:8080/api/events?dateFilter=true&after=%s&before=%s", after, before);

        return restTemplate.getForObject(url, List.class);
    }
}
