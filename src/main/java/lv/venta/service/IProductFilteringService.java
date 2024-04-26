package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductFilteringService {

	public abstract ArrayList<Product> filterByPriceLess(float threshold);
	
	public abstract ArrayList<Product> filterByQuantity(int threshold);
	
	public abstract ArrayList<Product> filterByTitleOrDescription (String keyword);
	
	public abstract float calculateTotalValueOfProducts();
	
}
