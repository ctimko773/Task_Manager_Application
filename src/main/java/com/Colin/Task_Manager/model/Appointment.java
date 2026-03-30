package com.Colin.Task_Manager.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointments")
public class Appointment {
    

    private String appointmentID;
	private LocalDateTime appointmentDate;
	private String appointmentDisc;
	
	public Appointment(String appointmentID, String appointmentDisc, LocalDateTime appointmentDate) {
		
		if (appointmentID == null || appointmentID.length() > 50) {
			  throw new IllegalArgumentException("Invalid appointment ID");
			  }
		if (appointmentDate == null || appointmentDate.isBefore(LocalDateTime.now())) {
			  throw new IllegalArgumentException("Invalid appointment date");
			  }
		if (appointmentDisc == null || appointmentDisc.length() > 500) {
			  throw new IllegalArgumentException("Invalid description");
			  }
		
		this.appointmentDate = appointmentDate;
		this.appointmentID = appointmentID;
		this.appointmentDisc = appointmentDisc;
	}
	
	
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public String getAppointmentDisc() {
		return appointmentDisc;
	}
	
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

}