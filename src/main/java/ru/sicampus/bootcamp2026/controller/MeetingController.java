package ru.sicampus.bootcamp2026.controller;

import ru.sicampus.bootcamp2026.entity.Meeting;
import ru.sicampus.bootcamp2026.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @GetMapping
    public ResponseEntity<List<Meeting>> getAllMeetings() {
        return ResponseEntity.ok(meetingService.getAllMeetings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.getMeetingById(id));
    }

    @PostMapping
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(meetingService.createMeeting(meeting));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> updateMeeting(
            @PathVariable Long id,
            @RequestBody Meeting meetingDetails
    ) {
        return ResponseEntity.ok(meetingService.updateMeeting(id, meetingDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/accept")
    public ResponseEntity<Meeting> acceptMeeting(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.acceptMeeting(id));
    }
}