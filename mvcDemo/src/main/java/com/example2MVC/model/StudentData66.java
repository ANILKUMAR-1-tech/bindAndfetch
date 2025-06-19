package com.example2MVC.model;

import java.util.List;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class StudentData66 {

   @Id
    private int id;

    private String name;
    private String email;
    private String course;

   @ElementCollection(fetch = FetchType.EAGER)
   @CollectionTable(name = "student_timings", joinColumns =@JoinColumn(name="id"))
   @Column(name="timinings")

    private List<String> timings;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}

public List<String> getTimings() {
	return timings;
}

public void setTimings(List<String> timings) {
	this.timings = timings;
}


   
   
}
