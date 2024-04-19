package lv.venta.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@AllArgsConstructor
public class Product {
	@Setter(value = AccessLevel.NONE)
	private int id;
		
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĀŠĢĶĻŽČŅa-zēūīļķģšāžčņ ]+")
	private String title;
	
	@Max(10000)
	@Min(0)
	private float price;
	
	@NotNull
	@Size(min = 4, max = 100)
	@Pattern(regexp = "[A-ZĒŪĪĀŠĢĶĻŽČŅa-zēūīļķģšāžčņ.!:- ]+")
	private String description;
	
	@Max(100)
	@Min(0)
	private int quantity;
	
	private static int counter = 0;
	
	public void setId() {
		id = counter;
		counter++;
	}
	
	public Product(String title, float price, String description, int quantity) {
		setId();
		setTitle(title);
		setPrice(price);
		setDescription(description);
		setQuantity(quantity);
	}

}