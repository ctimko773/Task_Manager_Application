package com.Colin.Task_Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Colin.Task_Manager.model.Appointment;
import com.Colin.Task_Manager.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")

public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public java.util.List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);

        return appointment; // Placeholder return statement
    }
}
