package demo.scheduler.dto.request;

import demo.scheduler.dto.common.UploadedFileDto;
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
public class RequestUploadFile {

    private List<MultipartFile> files;

    public List<UploadedFileDto> toDto(String folderPath, Long scheduleId) {
        return files.stream().map((file) -> {
            String originName = file.getOriginalFilename();
            String storedName = makeStoredName(originName);

            return new UploadedFileDto.Builder(originName, storedName, folderPath, scheduleId).build();
        }).collect(Collectors.toList());
    }

    private String makeStoredName(String fileName) {
        String uuid = UUID.randomUUID().toString();
        return uuid + "_" + fileName;
    }
}
