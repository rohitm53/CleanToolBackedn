package com.indiacleantool.cleantool.web.companymodules.timeslots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company/static/time-slots")
public class TimeSlotController {

    @Autowired
    private TimeSlotsService timeSlotsService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateCompanyTimeSlots(){
        timeSlotsService.generateTimeSlots();
        return new ResponseEntity<>("Time Slots Generated", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllStaticTimeSlots(){
        return new ResponseEntity<>(timeSlotsService.findAll(),HttpStatus.OK);
    }

}
