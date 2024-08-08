package demo.scheduler.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Attachment {
    private Long id;
    private String originName;
    private String storedName;
    private String path;
    private Long scheduleId;
}
