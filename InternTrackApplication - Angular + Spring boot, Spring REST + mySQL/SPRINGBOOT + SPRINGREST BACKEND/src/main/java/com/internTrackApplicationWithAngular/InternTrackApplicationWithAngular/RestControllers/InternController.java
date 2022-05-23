package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.RestControllers;

import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.DAO.InternDAOHibernateImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Assignment;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.DailyStatus;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Entities.Intern;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service.AssignmentServiceImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service.DailyStatusServiceImpl;
import com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.Service.InternServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/intern")
public class InternController {
    //Inject InternDAO
    @Autowired
    private InternServiceImpl internService;

    @Autowired
    private AssignmentServiceImpl assignmentService;

    @Autowired
    private DailyStatusServiceImpl dailyStatusService;

    //Expose /internList and return list of all Interns
    @GetMapping("/internsList")
    public List<Intern> listInterns(){
        return internService.listInterns();
    }

    @GetMapping("/assignments/{internId}")
    public List<Assignment> allInternAssignments(@PathVariable String internId){
        return assignmentService.listAssignmentsByInternId(internId);
    }

    @GetMapping("/UpdateAssignmentStatus/{assignmentId}")
    public boolean changeAssignmentStatus(@PathVariable String assignmentId){
        System.out.println(assignmentId);
        int assignmentNumber = Integer.parseInt(assignmentId);
        assignmentService.updateAssignmentStatus(assignmentNumber);
        return true;
    }

    @GetMapping("/giveDailyStatus/{statusOf}/{status}")
    public boolean giveDailyStatus(@PathVariable String statusOf, @PathVariable String status){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = dtf.format(now);        //  2021/03/22 16:37:15

        DailyStatus dailyStatus = new DailyStatus(status, statusOf, timeStamp);
        dailyStatusService.addStatus(dailyStatus);
        return true;
    }

    @GetMapping("/intern/{internId}")
    public Intern getInternById(@PathVariable String internId){
        return internService.getInternById(internId);
    }

    @GetMapping("/intern/arrayList")
    public ArrayList sendArrayList(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(internService.getInternById("aman@gmail.com"));
        arrayList.add(assignmentService.listAssignmentsByInternId("aman@gmail.com"));
        arrayList.add(2);
        return arrayList;
    }

    @PostMapping("/intern/Register")
    public Intern registerIntern(@RequestBody Intern intern){
        internService.addIntern(intern);
        return intern;
    }

    @GetMapping("/saveNewIntern/{internName}/{internId}/{internPassword}/{internGender}")
    public boolean saveNewIntern(@PathVariable String internName, @PathVariable String internId, @PathVariable String internPassword, @PathVariable String internGender ){
        Intern intern = new Intern(internName, internId, internPassword, internGender);
        internService.addIntern(intern);
        return true;

    }

}
