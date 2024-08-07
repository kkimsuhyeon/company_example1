package demo.scheduler.controller;

import demo.scheduler.dto.common.UploadedFileDto;
import demo.scheduler.dto.request.RequestUploadFile;
import demo.scheduler.service.UploadedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        uploadedFileService.uploadFile(request.getFiles().get(0), 1L);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
