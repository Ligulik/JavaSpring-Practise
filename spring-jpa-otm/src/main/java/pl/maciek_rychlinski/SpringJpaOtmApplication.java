package pl.maciek_rychlinski;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.maciek_rychlinski.dao.ClientDao;
import pl.maciek_rychlinski.dao.OrderDao;
import pl.maciek_rychlinski.dao.ProductDao;
import pl.maciek_rychlinski.models.Client;
import pl.maciek_rychlinski.models.Order;
import pl.maciek_rychlinski.models.Product;

@SpringBootApplication
public class SpringJpaOtmApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=SpringApplication.run(SpringJpaOtmApplication.class, args);


        /**
         * Wersja 1:
         */
//        ClientDao clientDao=ctx.getBean(ClientDao.class);
//
//        //Tworze klienta 1:
//        Client client=new Client("Maciej","Rychlinski","Polna");
//        clientDao.save(client);
//        System.out.println(client);
//
//        // Tworze zamówienie:
//        Order order=new Order("Z dostawą do domu:");
//        order.setClient(client);
//        OrderDao orderDao=ctx.getBean(OrderDao.class);
//        orderDao.save(order);
//
//        //Tworze zamówione produkty:
//        Product product=new Product("Komputer",2000,"Dobry");
//        Product product1=new Product("Telewizor",5000,"Duży");
//        ProductDao productDao=ctx.getBean(ProductDao.class);
//        productDao.save(product);
//        productDao.save(product1);
//
//        //Dodanie produktów do zamówienia:
//        orderDao.addProductToOrder(order.getId(),product,product1);
//
//        //Tworze klienta 2:
//        Client client1=new Client("Agata","Bartnikowska","Małkocin");
//        clientDao.save(client1);
//
//        Order order1=new Order("Do odbioru");
//        order1.setClient(client1);
//        orderDao.save(order1);
//
//        Product product2=new Product("Samochód",100000,"Szbki");
//        productDao.save(product2);
//
//        orderDao.addProductToOrder(order1.getId(),product1,product2);
//
//        //Informacje o kliencie i jego zamówieniu:
//        Client getClient=clientDao.get(client1.getId());
//        System.out.println(getClient);


        /**
         * Wersja 2:
         */

        Client client = new Client("Trzcinsko","Maciejo","Rychlinski");
        Order order=new Order("Zamówienie z dostawą do domu");
        Product product=new Product("Dobry",300,"Super");
        Product product2=new Product("Dobry2",3002,"Super2");
        order.getProducts().add(product);
        order.getProducts().add(product2);
        client.addOrder(order);

        ClientDao clientDao=ctx.getBean(ClientDao.class);
        clientDao.save(client);

        Client getClient=clientDao.get(client.getId());
        System.out.println(getClient);

        clientDao.remove(client);

        ctx.close();
    }

}
