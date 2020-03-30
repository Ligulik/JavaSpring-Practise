package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.maciek_rychlinski.dao.ProductDao;
import pl.maciek_rychlinski.model.Product;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaDynamicQueriesApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaDynamicQueriesApplication.class, args);

        List<Product> Products=new ArrayList<>();
        Products.add(new Product("Telewizor","Samsung",1200.0));
        Products.add(new Product("Komputer","Acer",5000.0));
        Products.add(new Product("Telefon","Samsung",2000.0));
        Products.add(new Product("Monitor","Benq",1223.0));

        ProductDao productDao=ctx.getBean(ProductDao.class);
        Products.forEach(productDao::save);

        System.out.println("All Products:");
        List<Product> allProduct=productDao.getAll();
        allProduct.forEach(System.out::println);

        System.out.println("Products more expensive than 1500");
        List<Product> expensiveProduct=productDao.getCustom("SELECT p FROM Product p WHERE p.price>3000");
        expensiveProduct.forEach(System.out::println);

        System.out.println("All products ordered by price");
        List<Product> orderedProduct=productDao.getCustom("SELECT p FROM Product p ORDER BY p.price ASC");
        orderedProduct.forEach(System.out::println);

        System.out.println("All poducts from Samsung more expensive tha 1500");
        List<Product> expensiveSamsungProduct=productDao.getCustom("SELECT p FROM Product p WHERE p.producer='Samsung' AND p.price >1500");
        expensiveSamsungProduct.forEach(System.out::println);

        System.out.println("****************************************************");

        System.out.println("Monitory");
        List<Product> findProduct=productDao.findByName("Monitor");
        System.out.println(findProduct);

        productDao.deleteByProducer("Samsung");
        System.out.println("Product without Samsung");
        productDao.getAll().forEach(System.out::println);


        productDao.deleteAll();

        ctx.close();
    }


}
