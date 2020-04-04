package pl.maciek_rychlinski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciek_rychlinski.Components.ShoppingCartComponent;

@Controller
public class AddProductsConroller {

    private ShoppingCartComponent cart;

    @Autowired
    public AddProductsConroller(ShoppingCartComponent cart){
        this.cart=cart;
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String product){
        cart.addProduct(product);
        return "index.jsp";
    }

}
