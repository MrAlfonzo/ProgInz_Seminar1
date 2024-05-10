package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

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
		
		Product existedProduct = productRepo.findByTitleAndDescriptionAndPrice(product.getTitle(), product.getDescription(), product.getPrice());
		//tads produkts jau eksiste
		if(existedProduct != null) {
			existedProduct.setQuantity(existedProduct.getQuantity() + product.getQuantity());
			productRepo.save(existedProduct);
			return;
		}
		//tomer tads produkts man anv repo un DB
		productRepo.save(product);
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
	public void update(int id, Product product) throws Exception {
		//1. atrast objektu
		Product productForUpdating = retrieveById(id);
		
		//2. rediget objektu JAVAs limeni
		productForUpdating.setTitle(product.getTitle());
		productForUpdating.setDescription(product.getDescription());
		productForUpdating.setPrice(product.getPrice());
		productForUpdating.setQuantity(product.getQuantity());
		
		//3. saglabat redigeto objektu ari repo un DB
		productRepo.save(productForUpdating); //save strada ka update
	}

	@Override
	public void deleteById(int id) throws Exception{
		//1. atrod produktu kuru grib dzest
		Product productForDeleting = retrieveById(id);
		//2. dzesam no repo un DB
		productRepo.delete(productForDeleting);
		
	}

	@Override
	public ArrayList<Product> filterByPriceLess(float threshold) throws Exception{
		if (threshold <= 0 )throw new Exception("Threshold is wrong");
		
		if (productRepo.count() == 0) throw new Exception ("There is no product in the system");
		ArrayList<Product> filteredProducts = productRepo.findByPriceLessThan(threshold);
		return filteredProducts;
	}

	@Override
	public ArrayList<Product> filterByQuantity(int threshold) throws Exception{
		if (threshold <= 0 )throw new Exception("Threshold is wrong");
		
		if (productRepo.count() == 0) throw new Exception ("There is no product in the system");
		ArrayList<Product> filteredProducts = productRepo.findByQuantityLessThan(threshold);
		return filteredProducts;
	}

	@Override
	public ArrayList<Product> filterByTitleOrDescription(String phrase) throws Exception{
		if (phrase == null )throw new Exception("Phrase is wrong");
		
		if (productRepo.count() == 0) throw new Exception ("There is no product in the system");
		ArrayList<Product> filteredProducts = productRepo.findByTitleIgnoreCaseLikeOrDescriptionIgnoreCaseContains(phrase, phrase);
		return filteredProducts;
	}

	@Override
	public float calculateTotalValueOfProducts() throws Exception {
		if (productRepo.count() == 0) throw new Exception ("There is no product in the system");
		
		float totalValue = productRepo.calculateTotalValueFromRepoProducts();
		
		return totalValue;
	}

	
	
	
	
	
}
