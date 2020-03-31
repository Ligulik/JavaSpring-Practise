package pl.maciek_rychlinski;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.maciek_rychlinski.model.Car;
import pl.maciek_rychlinski.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan

public class SpringDataApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDataApplication.class);

        List<Car> cars=new ArrayList<>();
        cars.add(new Car("Leon","Seat",10000.));
        cars.add(new Car("Golf","Volkswagen",20500.));
        cars.add(new Car("Supra","Toyota",100000.));


        //Zapisujemy samochody:

        CarRepository carRepository=ctx.getBean(CarRepository.class);
        cars.forEach(carRepository::save);

        System.out.println("Lista przed usunięciem pojazdu: *****************");
        carRepository.findAll().forEach(System.out::println);

        // Pobieramy samochod z indeksem 1 i go usuwamy

        Car carToDelete=carRepository.findById(1l).get();
        carRepository.delete(carToDelete);

        //Pobieramy pozostałe i je wyświetlamy:

        System.out.println("Lista po usunięciu: *************************");
        carRepository.findAll().forEach(System.out::println);
    }


}
