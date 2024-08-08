package demo.scheduler.controller;

import demo.scheduler.domain.UploadedFile;
import demo.scheduler.dto.request.RequestUploadFile;
import demo.scheduler.service.UploadedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/files")
public class UploadedFileController {

    private final UploadedFileService uploadedFileService;

    @Autowired
    public UploadedFileController(UploadedFileService uploadedFileService) {
        this.uploadedFileService = uploadedFileService;
    }

    @PostMapping
    public ResponseEntity<?> uploadFile(RequestUploadFile request) {
        uploadedFileService.uploadFiles(request.getFiles(), 1L);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<?> downloadFile(@PathVariable(value = "fileId") Long fileId) {
        try {
            UploadedFile uploadedFile = uploadedFileService.downloadFile(fileId);


            UrlResource urlResource = new UrlResource("file:" + uploadedFile.getPath());

            String encodedUploadFileName = UriUtils.encode(uploadedFile.getOriginName(), StandardCharsets.UTF_8);
            String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .body(urlResource);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
