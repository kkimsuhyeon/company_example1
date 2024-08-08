package demo.scheduler.controller;

import demo.scheduler.dto.request.RequestCreateSchedule;
import demo.scheduler.dto.request.RequestModifySchedule;
import demo.scheduler.dto.request.RequestUploadAttachment;
import demo.scheduler.dto.response.ResponseScheduleItem;
import demo.scheduler.dto.response.ResponseScheduleWithAttachment;
import demo.scheduler.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<?> getSchedules(
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer weekly
    ) {
        List<ResponseScheduleItem> result = scheduleService.getSchedules(month, weekly);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}")
    public ResponseEntity<?> getSchedule(@PathVariable(value = "scheduleId") Long id) {
        ResponseScheduleWithAttachment schedule = scheduleService.getScheduleById(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createSchedule(
            @RequestParam @Valid RequestCreateSchedule requestCreateSchedule,
            @RequestParam(required = false) RequestUploadAttachment requestUploadAttachment) {
        scheduleService.createSchedule(requestCreateSchedule, requestUploadAttachment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/{scheduleId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> modifySchedule(
            @PathVariable(value = "scheduleId") Long id,
            @ModelAttribute @Valid RequestModifySchedule requestModifySchedule,
            @ModelAttribute RequestUploadAttachment requestUploadAttachment) {
        scheduleService.modifySchedule(id, requestModifySchedule, requestUploadAttachment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
