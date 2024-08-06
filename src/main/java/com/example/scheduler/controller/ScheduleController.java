package com.example.scheduler.controller;

import com.example.scheduler.dto.request.RequestCreateSchedule;
import com.example.scheduler.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<?> createSchedule(@ModelAttribute @Valid RequestCreateSchedule request) {
        scheduleService.createSchedule(request.toDto());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
