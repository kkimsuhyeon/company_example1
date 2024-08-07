package demo.scheduler.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UploadedFile {
    private Long id;
    private String originName;
    private String storedName;
    private String path;
    private Long scheduleId;
}
