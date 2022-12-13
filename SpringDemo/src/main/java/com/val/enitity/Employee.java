package com.val.enitity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@Builder
public class Employee {
	
	private int id;
	private String name;
	private String email;
	public static void main(String[] args) {
		Employee emp=new Employee();
		
		
	}

}
