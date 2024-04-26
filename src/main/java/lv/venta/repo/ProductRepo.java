package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{

	//public abstract pec noklusejuma
	//SELECT * FROM product_table WHERE title= 1 arguments AND description= 2 arguments AND price= 3 arguments
	Product findByTitleAndDescriptionAndPrice(String title, String description, float price);

}
