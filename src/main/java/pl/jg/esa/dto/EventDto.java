package pl.jg.esa.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
public class EventDto implements Serializable {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String shortDescription;

    @Override
    public String toString() {
        return "EventDto{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
