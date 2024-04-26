package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.repo.ProductRepo;

@SpringBootApplication
public class ProgInzSeminars1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminars1Application.class, args);
	}
	
	//TEST
	@Bean //funkcija tiks izsaukta automatiski, lidz ko palaizas sistēma.
	public CommandLineRunner testDatabase(ProductRepo productRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				//TODO: izvediot 3 produktus ar save funckciju saglabat repo
				
				Product p1 = new Product("Zeķes", 3.50f, "Siltas un pūkainas zeķes", 1);
				Product p2 = new Product("Cimdi", 2.30f, "Silti un pūkaini Cimdi", 4);
				Product p3 = new Product("Šalle", 5.99f, "Gara un silta Šalle", 5);
				
				productRepo.save(p1);
				productRepo.save(p2);
				productRepo.save(p3);
				
				System.out.println("How Many products: " + productRepo.count());
				//izsaukt caur repo findById()
				//System.out.println("Get product by id (2):" + productRepo.findById(1).get());

				//System.out.println("All products: " + productRepo.findAll());
				//pamegināt dzesānu
				//Product productForDeleting = productRepo.findById(1).get();
				//productRepo.delete(productForDeleting);
				//iztisīt update caur repo
				//Product productForUpdating = productRepo.findById(53).get();
				//productForUpdating.setPrice(0.55f);
				//productRepo.save(productForUpdating);
				
			}
		};
	}

}
