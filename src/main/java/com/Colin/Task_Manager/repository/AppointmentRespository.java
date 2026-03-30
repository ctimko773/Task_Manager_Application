package com.Colin.Task_Manager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Colin.Task_Manager.model.Appointment;

@Repository
public interface AppointmentRespository extends MongoRepository<Appointment, String> {
    List<Appointment> findByAppointmentID(String appointmentID);

}
