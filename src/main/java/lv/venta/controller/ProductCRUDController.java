
package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {

	@Autowired
	private IProductCRUDService crudService;

	@GetMapping("/all") //localhost:8080/product/crud/all
	public String getProductCRUDAll(Model model) 
	{
		try {
			model.addAttribute("mydata", crudService.retrieveAll());
			return "product-show-all-page";//tiks parādīta producty-show-all-page.html ar visiem produktiem
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/all/{id}") //localhost:8080/product/crud/one?id=2
	public String getproductCRUDOne(@RequestParam("id") int id, Model model) {
		try {
			Product foundProduct = crudService.retrieveById(id);
			model.addAttribute("mydata", foundProduct);
			return "product-show-one-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/insert") //localhost:8080/product/crud/insert
	public String getProductCrudInsert(Model model) {
		model.addAttribute("product)", new Product());
	}
	
	

}