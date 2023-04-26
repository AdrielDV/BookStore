package Library.BookController;


import Library.BookDomain.Book;
import Library.BookServices.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/cart")
public class CartController {


    private List<Book> cart = new ArrayList<>();
    @Autowired
    private BookServices services;

    @GetMapping("/cart")
    public String cart(Model model) {

        model.addAttribute("bookID",cart);

        return "Cart";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(Model model, @PathVariable Long id) {


        ResponseEntity<Book> response = services.getBookById(id);

        cart.add(response.getBody());


        model.addAttribute("bookID", cart);

        return "redirect:/cart/cart";

    }

    @GetMapping("/deleteBookCart/{id}")
    public String deleteBookCart(Model model, @PathVariable Long id) {

        cart.remove(services.getBookById(id).getBody());

        model.addAttribute("bookID", cart);

        return "redirect:/cart/cart";
    }


}
