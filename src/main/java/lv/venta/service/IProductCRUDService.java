package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductCRUDService {
	//CRUD - Create, Retrieve, Update, Delete;
	
	public abstract void create(Product product);
	
	public abstract Product retrieveById(int id) throws Exception;
	
	public abstract ArrayList<Product> retrieveAll() throws Exception;
	
	public abstract void update(int id, Product product) throws Exception;
	
	public abstract void deleteById(int id) throws Exception;

}
