package pl.maciek_rychlinski.Components;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartComponent {

    private List<String> products;

    public ShoppingCartComponent(){
        products=new ArrayList<>();
    }

    public void addProduct(String product){
        this.products.add(product);
    }

    public List<String> getProducts(){
        return products;
    }

    @PostConstruct
    public void create(){
        System.out.println(this + "created");
    }

    @PreDestroy
    public void destroy(){
        System.out.println(this + "destroyed");
    }
}
