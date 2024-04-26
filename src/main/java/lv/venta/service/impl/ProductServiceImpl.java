package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.ProductRepo;
import lv.venta.service.IProductCRUDService;
import lv.venta.service.IProductFilteringService;

@Service
public class ProductServiceImpl implements IProductCRUDService, IProductFilteringService{

	@Autowired
	private ProductRepo productRepo;
	

	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product retrieveById(int id) throws Exception {
		if(id < 0) throw new Exception("Id should be positive");
		
		if(productRepo.existsById(id)) {
		return productRepo.findById(id).get();
		}
		else {
			throw new Exception("Product with this id ("+id+") is not in the system");
		}
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(productRepo.count() == 0) throw new Exception("There is no product in the table");
		return (ArrayList<Product>) productRepo.findAll();
	}

	@Override
	public void update(int id, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Product> filterByPriceLess(float threshold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> filterByQuantity(int threshold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> filterByTitleOrDescription(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateTotalValueOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
}
