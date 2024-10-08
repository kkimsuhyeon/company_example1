package demo.scheduler.controller;

import demo.scheduler.dto.common.Attachment;
import demo.scheduler.dto.request.RequestUploadAttachment;
import demo.scheduler.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping
    public ResponseEntity<?> uploadAttachment(RequestUploadAttachment request , Long scheduleId) {
        attachmentService.uploadAttachment(request, scheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<?> downloadFile(@PathVariable(value = "fileId") Long fileId) {
        try {
            Attachment attachment = attachmentService.downloadAttachment(fileId);
            UrlResource urlResource = new UrlResource("file:" + attachment.getPath());

            String encodedUploadFileName = UriUtils.encode(attachment.getOriginName(), StandardCharsets.UTF_8);
            String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .body(urlResource);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<?> deleteFile(@PathVariable(value = "fileId") Long fileId) throws IOException {
        try {
            attachmentService.removeAttachment(fileId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
}
