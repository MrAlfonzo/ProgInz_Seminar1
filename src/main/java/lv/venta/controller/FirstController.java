package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;

@Controller
public class FirstController {

	@GetMapping("/hello") //localhost:8080/hello
	public String getHello() {
		System.out.println("First controller works");
		return "hello-page"; // tiks parādīta  hello-page.html lapa
	}
	
	Random random = new Random();
	@GetMapping("/hello/msg") //localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		model.addAttribute("myData", "Zina no Alfreda ->" + random.nextInt(0, 77));
		return "hello-msg-page";
	}
	
	@GetMapping("/product/test") // localhost:8080/product/test
	public String getProductTest(Model model) {
		Product product = new Product("Zeķes", 3.50f, "Siltas un pūkainas zeķes", 1);
		model.addAttribute("myData", product);
		return "product-show-one-page"; //tiek paradita product-show-one-page.html lapa
	}
	
	@GetMapping("/product/test/all") //localhost:8080/product/test/all
	public String getProductTestAll (Model model) {
		ArrayList<Product> allProduct = new ArrayList<> (
				Arrays.asList(
				new Product("Zeķes", 3.50f, "Siltas un pūkainas zeķes", 1),
				new Product("Cimdi", 2.30f, "Silti un pūkaini Cimdi", 4),
				new Product("Šalle", 5.99f, "Gara un silta Šalle", 5)));
	
		model.addAttribute("mydata", allProduct);
		return "product-show-all-page";
}
	

}