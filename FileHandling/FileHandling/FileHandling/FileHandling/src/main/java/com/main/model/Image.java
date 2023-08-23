package com.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Image {

	@Id
	private String id;
	private String imgPath;
	private String imgName;
	private boolean markedForDeletion;

	@ManyToOne
	private User user;
}
