package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.maciek_rychlinski.model.Project;
import pl.maciek_rychlinski.service.ProjectService;

import javax.validation.Validator;
import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class SpringValidatorGroupsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringValidatorGroupsApplication.class, args);
        ProjectService projectService=ctx.getBean(ProjectService.class);

        // 1 faza budowania projektu - przpuszczam tylko przez 1 grupę validacji:

        Project project=new Project();
        project.setTitle("Pociąg indukcyjny");
        project.setDate(Date.from(Instant.now()));

        boolean validateDraft=projectService.validateDraft(project);
        System.out.println("Is Draft Project valid ? " + validateDraft);

        // 2 faza - dodaje koljne informacje, przepuszczam prz sekwencję grup - najpierw draft.class potem complete.class

        project.setDescription("Budowa pociągu niedotykającego fizycznie torów");
        project.setOwner("Maciek");

        boolean validateFull=projectService.validateFull(project);
        System.out.println("Is Completed Project valid ? " +validateFull);

        ctx.close();




        // Przypadek 2 -celowe źle podane dane:

        Project project1=new Project();
        project1.setTitle(null);
        project1.setDate(Date.from(Instant.now()));

        boolean validateDraft1=projectService.validateDraft(project1);
        System.out.println("Is Draft Project valid ? " + validateDraft1);

        project1.setDescription("Miał być super projekt ale zabrakło tytułu");
        project1.setOwner("Smutny Maciek");

        boolean validateFull2=projectService.validateFull(project1);
        System.out.println("Is Completed Project valid ? " +validateFull2);

    }


    // Nie zapominam o dodaniu ziarna walidatora, ktore zostanie dodanie autowiązaniem do klasy person service ;)

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
