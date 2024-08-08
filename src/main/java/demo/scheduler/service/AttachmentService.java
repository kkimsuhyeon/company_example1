package demo.scheduler.service;

import demo.scheduler.dto.common.Attachment;
import demo.scheduler.dto.request.RequestUploadAttachment;
import demo.scheduler.repository.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class AttachmentService {

    private final AttachmentMapper uploadedFileMapper;

    @Autowired
    public AttachmentService(AttachmentMapper uploadedFileMapper) {
        this.uploadedFileMapper = uploadedFileMapper;
    }

    public void uploadAttachment(RequestUploadAttachment request, Long scheduleId) {
        if (!request.getFiles().isEmpty()) {
            request.getFiles().forEach((file) -> uploadFile(file, scheduleId));
        }
    }

    public Attachment downloadFile(Long fileId) {
        return uploadedFileMapper.selectAttachmentById(fileId);
    }

    private void uploadFile(MultipartFile file, Long scheduleId) {
        String folderPath = makeFolder();

        String originName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String storedName = uuid + "_" + originName;
        String filePath = folderPath + File.separator + storedName;

        try {
            Path savePath = Paths.get(filePath);
            file.transferTo(savePath);

            uploadedFileMapper.insertAttachment(Attachment.builder()
                    .originName(originName)
                    .storedName(storedName)
                    .path(filePath)
                    .scheduleId(scheduleId)
                    .build());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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