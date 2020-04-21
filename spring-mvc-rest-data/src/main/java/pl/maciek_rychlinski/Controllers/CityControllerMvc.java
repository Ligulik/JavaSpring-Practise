package pl.maciek_rychlinski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.maciek_rychlinski.model.City;
import pl.maciek_rychlinski.repository.CityRepository;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityControllerMvc {

public CityRepository cityRepository;

@Autowired CityControllerMvc(CityRepository cityRepository){
    this.cityRepository=cityRepository;
}


@GetMapping
    public String listCities(Model model){
    List<City> cities=cityRepository.findAll();
    model.addAttribute("cityList",cities);
    return "list";
}

@PostMapping
    public String addCities(@ModelAttribute City cityModel, RedirectAttributes redirectAttributes){
    cityRepository.save(cityModel);
    redirectAttributes.addFlashAttribute("message", "Miasto dodano pomyślnie");
    return "redirect:/";
}
}
