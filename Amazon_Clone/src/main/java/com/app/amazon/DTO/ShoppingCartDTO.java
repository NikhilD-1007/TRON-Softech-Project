package com.app.amazon.DTO;

import java.time.LocalDate;

import com.app.amazon.Entities.User;

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
public class ShoppingCartDTO {

	private Long productId;
	private Long customerId;
	//private int totalItems;
	private int quantity;
	
	
}
