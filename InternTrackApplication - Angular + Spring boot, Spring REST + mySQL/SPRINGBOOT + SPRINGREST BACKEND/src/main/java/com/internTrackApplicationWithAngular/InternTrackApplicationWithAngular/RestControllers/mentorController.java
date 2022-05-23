package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.RestControllers;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Assignment;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.DailyStatus;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Intern;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Mentor;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service.AssignmentServiceImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service.DailyStatusServiceImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service.InternServiceImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service.MentorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/mentor")
public class mentorController {
    @Autowired
    private MentorServiceImpl mentorService;

    @Autowired
    private InternServiceImpl internService;

    @Autowired
    private AssignmentServiceImpl assignmentService;

    @Autowired
    private DailyStatusServiceImpl dailyStatusService;


    //Expose /mentorList and return list of all Mentors
    @GetMapping("/mentorsList")
    public List<Mentor> listInterns(){
        return mentorService.listMentors();
    }

    @GetMapping("/allAssignmentsOfIntern/{internId}")
    public List<Assignment> allAssignmentOfIntern(@PathVariable String internId){
        return assignmentService.listAssignmentsByInternId(internId);
    }

    @GetMapping("/internDailyStatuses/{internId}")
    public List<DailyStatus> internDailyStatuses(@PathVariable String internId){
        return dailyStatusService.listDailyStatusByInternId(internId);
    }

    @GetMapping("/getInternDetails/{internId}")
    public List<Intern> getInternById(@PathVariable String internId){
        System.out.println(internService.getInternById(internId));
        List<Intern> intern = new LinkedList<>();
        intern.add(internService.getInternById(internId));
        return intern;
    }

    @GetMapping("/giveAssignment/{assignment}/{givenBy}/{givenTo}")
    public boolean giveAssignment(@PathVariable String assignment, @PathVariable String givenBy, @PathVariable String givenTo){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = dtf.format(now);        //  2021/03/22 16:37:15

        Assignment assignment1 = new Assignment(assignment, givenBy, givenTo, timeStamp);
        System.out.println(assignment1);
        assignmentService.addAssignment(assignment1);
        return true;
    }

    @GetMapping("/saveNewMentor/{mentorName}/{mentorId}/{mentorPassword}/{mentorOf}")
    public boolean saveNewMentor(@PathVariable String mentorName, @PathVariable String mentorId, @PathVariable String mentorPassword, @PathVariable String mentorOf){
        Mentor mentor = new Mentor(mentorName, mentorId, mentorPassword, mentorOf);
        mentorService.addMentor(mentor);
        return true;
    }

    @GetMapping("/internsWithoutAnyMentor")
    public List<Intern> internsWithoutMentor(){
        List<String> internNameListFromMentorDetails = new ArrayList<>();
        mentorService.listMentors().forEach(x -> internNameListFromMentorDetails.add(x.getMentorOf()));

        return internService.listInterns().stream().filter(x -> !internNameListFromMentorDetails.contains(x.getInternId())).collect(Collectors.toList());
    }
}
