package com.vlad.thymeleaf.thymeleaf333.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_detail")
public class StudentDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String city;
	
	@Column(name="training_shema")
	private String trainingShema;
	
	public StudentDetail() {}

	public StudentDetail(String city, String trainingShema) {
		this.city = city;
		this.trainingShema = trainingShema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTrainingShema() {
		return trainingShema;
	}

	public void setTrainingShema(String trainingShema) {
		this.trainingShema = trainingShema;
	}
	
	
}
