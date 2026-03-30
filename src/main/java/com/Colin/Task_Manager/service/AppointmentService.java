package com.Colin.Task_Manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Colin.Task_Manager.model.Appointment;
import com.Colin.Task_Manager.repository.AppointmentRespository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRespository repo;

    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        boolean exists = repo.findByAppointmentID(appointment.getAppointmentID()).stream()
            .anyMatch(existingAppointment -> existingAppointment.getAppointmentDate().equals(appointment.getAppointmentDate()));
        if (!exists) {
            repo.save(appointment);
        }
        return appointment;
    }
    
}
