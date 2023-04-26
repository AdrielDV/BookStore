package Library.Client.clientController;

import Library.Client.clientDomain.Client;
import Library.Client.clientServices.ClientServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/client")
public class ClientController {

@Autowired
ClientServices services;

    @PostMapping("/signUpSuccess")
    public String signUpPart(@ModelAttribute("client") Client client) {
       services.newClient(client);

        return "Login";
        }




       @PostMapping("/isAValidClient")
        public String isAValidUser(@RequestParam("login") String login, @RequestParam("password") String password, HttpSession session){

        if(services.authenticatedUser(login,password)){
            session.setAttribute("authenticatedClient", login);

            return "redirect:/book/bookStore";
        }
        else {
            return "Login";
        }
        }

    @GetMapping("/signUpPage")
    public String processSignUpForm(Model model) {



        return "signUp";
    }




    @GetMapping("/loginSuccess")
    public String loginSuccess() {


        return "bookStore";
    }

    @GetMapping("/signInPage")
    public String signIn(Model model) {
        List<Client> clientList =services.allClients();
        model.addAttribute("clientList", clientList);

        return "redirect:/client/login";
    }







    @GetMapping("/login")
    public String addNewClient() {




        return "Login";
    }





}
