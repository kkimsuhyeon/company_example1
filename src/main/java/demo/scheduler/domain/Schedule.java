package demo.scheduler.domain;

import demo.scheduler.domain.constant.Color;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Schedule {

    private Long id;

    private String title;

    private String content;

    private Color color;
}
