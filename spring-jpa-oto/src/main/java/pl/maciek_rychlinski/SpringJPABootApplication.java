package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.maciek_rychlinski.dao.UserDao;
import pl.maciek_rychlinski.dao.UserDetailsDao;
import pl.maciek_rychlinski.models.User;
import pl.maciek_rychlinski.models.UserDetails;

@SpringBootApplication
public class SpringJPABootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx= SpringApplication.run(SpringJPABootApplication.class, args);

        UserDao userDao=ctx.getBean(UserDao.class);
        User user =new User("Liguli14","liguli12314","dupa14@wp.pl");
        // zapisanie informacji dodatkowych:
        UserDetails userDetails=new UserDetails("Maciek","Rychlinski","Polna");
        user.setDetails(userDetails);
        //zapisanie podstawowych informacji o uzytkowniku:
        userDao.save(user);




        //aktualizacja imienia i hasła:
        user.setPassword("dupa12");
        user.getDetails().setFirstName("Andrzej");
        userDao.upload(user);

        //pobieramy aktualny stan i wyswietlamy:
        User userFromDb=userDao.read(1L);
        System.out.println(userFromDb);

        UserDetailsDao userDetailsDao=ctx.getBean(UserDetailsDao.class);
        UserDetails getUserDetails=userDetailsDao.get(1L);
        System.out.println(getUserDetails.getUser());

        //usuawamy obiekt z bazy danych:
        userDao.delete(user);

        // Ponowne wyswietlenie stanu:
        userFromDb=userDao.read(1L);
        System.out.println(userFromDb);

        ctx.close();
    }

}
