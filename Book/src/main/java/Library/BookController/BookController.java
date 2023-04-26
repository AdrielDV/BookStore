package Library.BookController;


import Library.BookDomain.Book;
import Library.BookServices.BookServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/book")
@Controller
public class BookController {


    @Autowired
    private BookServices services;


    @GetMapping
    public String initialPage(){
        return "initialPage";
    }

    @GetMapping("/bookStore")
    public String bookStore(Model model){
       ResponseEntity<List<Book>> responseEntity = services.getBook();
       List<Book> books = responseEntity.getBody();
       model.addAttribute("books", books);

        return "bookStore";

    }

    @GetMapping("/refreshPage")
    public String refreshPage(){
        return "redirect:/book/bookStore";
    }







    @GetMapping("/bookById/{id}")
    public String getBookById(Model model, @PathVariable Long id) {
        ResponseEntity<Book> response = services.getBookById(id);
        Book book = response.getBody();

        model.addAttribute("book", book);
        return "editBook";


    }



    @GetMapping("/allBooks")
    public String getBook(Model model) {
        ResponseEntity<List<Book>> response=  services.getBook();
        List<Book> bookList = response.getBody();
        model.addAttribute("bookList", bookList);

        return "bookDisplay";
    }


@GetMapping("/deleteById/{id}")
public String deleteBook(@PathVariable Long id) {
        services.deleteById(id);

        return "redirect:/book/allBooks";

}

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book) {


        services.addNewBook(book);

        return "redirect:/book/allBooks";
    }



}
