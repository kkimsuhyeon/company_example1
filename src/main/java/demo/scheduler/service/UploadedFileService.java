package demo.scheduler.service;

import demo.scheduler.domain.UploadedFile;
import demo.scheduler.dto.common.UploadedFileDto;
import demo.scheduler.repository.UploadedFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class UploadedFileService {

    private final UploadedFileMapper uploadedFileMapper;

    @Autowired
    public UploadedFileService(UploadedFileMapper uploadedFileMapper) {
        this.uploadedFileMapper = uploadedFileMapper;
    }

    public void uploadFiles(List<MultipartFile> files, Long scheduleId) {
        files.forEach((file) -> uploadFile(file, scheduleId));
    }

    public void uploadFile(MultipartFile file, Long scheduleId) {
        String folderPath = makeFolder();

        String originName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String storedName = uuid + "_" + originName;
        String filePath = folderPath + File.separator + storedName;

        UploadedFileDto uploadedFileDto = new UploadedFileDto
                .Builder(originName, storedName, filePath, scheduleId)
                .build();

        try {
            Path savePath = Paths.get(filePath);
            file.transferTo(savePath);
            uploadedFileMapper.insertFile(uploadedFileDto.toEntity());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UploadedFile downloadFile(Long fileId) throws MalformedURLException {
        UploadedFile uploadedFile = uploadedFileMapper.selectFileById(fileId);
        return uploadedFile;

    }


    private String makeFolder() {
        String folderPath = "files";

        File uploadPathFolder = new File(folderPath);
        if (!uploadPathFolder.exists()) {
            uploadPathFolder.mkdirs();
        }

        return folderPath;
    }
}
