package demo.scheduler.controller;

import demo.scheduler.dto.common.ScheduleDto;
import demo.scheduler.dto.request.RequestCreateSchedule;
import demo.scheduler.dto.request.RequestModifySchedule;
import demo.scheduler.dto.response.ResponseScheduleDetail;
import demo.scheduler.dto.response.ResponseScheduleItem;
import demo.scheduler.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        List<ScheduleDto> schedules = scheduleService.getSchedules(month, weekly);
        List<ResponseScheduleItem> result = schedules.stream().map(ResponseScheduleItem::from).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}")
    public ResponseEntity<?> getSchedule(@PathVariable(value = "scheduleId") Long id) {
        ScheduleDto schedule = scheduleService.getScheduleById(id);
        return new ResponseEntity<>(ResponseScheduleDetail.from(schedule), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createSchedule(@ModelAttribute @Valid RequestCreateSchedule request) {
        scheduleService.createSchedule(request.of());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{scheduleId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> modifySchedule(@PathVariable(value = "scheduleId") Long id, @RequestBody @Valid RequestModifySchedule request) {
        scheduleService.modifySchedule(id, request.of(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
