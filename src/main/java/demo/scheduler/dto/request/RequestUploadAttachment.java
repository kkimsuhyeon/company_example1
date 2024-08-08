package demo.scheduler.dto.request;

import demo.scheduler.dto.common.Attachment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
public class RequestUploadAttachment {

    private List<MultipartFile> files;

    public List<Attachment> toDto(String path, Long scheduleId) {
        return files.stream().map((file) -> {
            String originName = file.getOriginalFilename();
            String storedName = makeStoredName(originName);

            return Attachment.builder()
                    .originName(originName)
                    .storedName(storedName)
                    .path(path)
                    .scheduleId(scheduleId)
                    .build();
        }).collect(Collectors.toList());
    }

    private String makeStoredName(String fileName) {
        String uuid = UUID.randomUUID().toString();
        return uuid + "_" + fileName;
    }
}
