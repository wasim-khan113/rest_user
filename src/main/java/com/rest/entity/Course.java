package com.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int cId;
private String cName;
private String duration;
@ManyToOne
@JoinColumn(name = "course_user_id", nullable = false )
private User user;
public Course(int cId, String cName, String duration) {
	super();
	this.cId = cId;
	this.cName = cName;
	this.duration = duration;
	
}
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
public int getcId() {
	return cId;
}
public void setcId(int cId) {
	this.cId = cId;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}

}
