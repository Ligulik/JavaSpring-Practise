package pl.maciek_rychlinski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.maciek_rychlinski.Components.ShoppingCartComponent;

@Controller
public class PrintProductsController {

    private ShoppingCartComponent cart;

    @Autowired
    public PrintProductsController(ShoppingCartComponent cart){
        this.cart=cart;
    }

    @GetMapping("/print")
        public String printProducts(){
            for(String product:cart.getProducts()){
                System.out.println(product);
            }
        return "index.jsp";
        }


}
