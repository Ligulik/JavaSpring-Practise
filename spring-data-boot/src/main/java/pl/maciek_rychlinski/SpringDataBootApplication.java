package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.maciek_rychlinski.model.Car;
import pl.maciek_rychlinski.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) throws InterruptedException{

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataBootApplication.class, args);

        List<Car> cars=new ArrayList<>();
        cars.add(new Car("Leon","Seat",10000.));
        cars.add(new Car("Golf","Volkswagen",20500.));
        cars.add(new Car("Supra","Toyota",100000.));
        cars.add(new Car("Fabia","Skoda",3000.));
        cars.add(new Car("Octavia","Skoda",3500.));
        cars.add(new Car("Omega","Opel",2200.));

        //Zapisuje samochody
        CarRepository carRepository=ctx.getBean(CarRepository.class);
        cars.forEach(carRepository::save);

        //Usunięcie pierwszego
        Car firstCar=carRepository.findById(1L).get();
        carRepository.delete(firstCar);

        //Wyświetlenie pozostałych:
        carRepository.findAll().forEach(System.out::println);

        // FindBy
        //Wszystkie samochody skody:
        System.out.println("Samochody skody ***********************************");
        List<Car> testList=carRepository.findByBrand("Skoda");
        System.out.println(testList);

        // Pierwszy element FindFirstBy
        System.out.println("Pierwszy samochód z list Skody *************************");
        Car firstSkodaCar=carRepository.findFirstByBrand("Skoda");
        System.out.println(firstSkodaCar);

        // Operatory logiczne AND i OR

        System.out.println("Samochody marki Skoda i Opel*******************************");
        carRepository.findAllByBrandOrBrand("Skoda","Opel").forEach(System.out::println);

        System.out.println("Samochody, zaczynające się na litere \"O\"");
        carRepository.findAllByNameLike("O%").forEach(System.out::println);


        System.out.println("Widełki cenowe**************************");
        carRepository.findAllByPriceBetween(2000.,4000.).forEach(System.out::println);

        //Sortowanie

        System.out.println("Posortowane ceny rosnąco dla skody");
        carRepository.findAllByBrandOrderByPriceAsc("Skoda").forEach(System.out::println);

        System.out.println("Zanlezienie Skody fabi");
        carRepository.findByNameAndBrand("Fabia","Skoda").forEach(System.out::println);



        ctx.close();
    }

}
