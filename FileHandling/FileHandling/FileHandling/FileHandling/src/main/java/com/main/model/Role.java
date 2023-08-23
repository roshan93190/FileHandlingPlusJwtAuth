package com.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Role {

	@Id
	private String id;

	private String name;
}
