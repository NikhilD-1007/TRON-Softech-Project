package com.app.amazon.DTO;

import java.util.List;

import com.app.amazon.Entities.Products;
import com.app.amazon.Entities.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

	private Long categoryID;
	private String categoryName;
	private String categoryDescription;
	private Status categoryStatus;
	private String imageUrl;
	
}
