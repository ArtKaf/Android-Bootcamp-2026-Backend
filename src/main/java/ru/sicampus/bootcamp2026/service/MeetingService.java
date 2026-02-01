package ru.sicampus.bootcamp2026.service;
import ru.sicampus.bootcamp2026.entity.Meeting;
import ru.sicampus.bootcamp2026.entity.Person;
import ru.sicampus.bootcamp2026.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final PersonService personService;

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public Meeting getMeetingById(Long id) {
        return meetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meeting not found with id: " + id));
    }

    public Meeting createMeeting(Meeting meeting) {
        // Проверяем существование участников
        Person participantOne = personService.getPersonById(
                meeting.getParticipantOne().getId()
        );
        Person participantTwo = personService.getPersonById(
                meeting.getParticipantTwo().getId()
        );

        meeting.setParticipantOne(participantOne);
        meeting.setParticipantTwo(participantTwo);

        return meetingRepository.save(meeting);
    }

    public Meeting updateMeeting(Long id, Meeting meetingDetails) {
        Meeting meeting = getMeetingById(id);

        if (meetingDetails.getParticipantOne() != null) {
            Person participantOne = personService.getPersonById(
                    meetingDetails.getParticipantOne().getId()
            );
            meeting.setParticipantOne(participantOne);
        }

        if (meetingDetails.getParticipantTwo() != null) {
            Person participantTwo = personService.getPersonById(
                    meetingDetails.getParticipantTwo().getId()
            );
            meeting.setParticipantTwo(participantTwo);
        }

        if (meetingDetails.getTime() != null) {
            meeting.setTime(meetingDetails.getTime());
        }

        if (meetingDetails.getIsAccepted() != null) {
            meeting.setIsAccepted(meetingDetails.getIsAccepted());
        }

        return meetingRepository.save(meeting);
    }

    public void deleteMeeting(Long id) {
        Meeting meeting = getMeetingById(id);
        meetingRepository.delete(meeting);
    }

    public Meeting acceptMeeting(Long id) {
        Meeting meeting = getMeetingById(id);
        meeting.setIsAccepted(true);
        return meetingRepository.save(meeting);
    }
}