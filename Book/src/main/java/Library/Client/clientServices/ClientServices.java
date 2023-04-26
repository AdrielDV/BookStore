package Library.Client.clientServices;

import Library.Client.clientDomain.Client;
import Library.Client.clientRepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {



    @Autowired
    private ClientRepository repository;


    public void newClient(Client client){
        repository.save(client);
    }

    public void deleteClientById(Long id){
        repository.deleteById(id);
    }
    public List<Client> allClients(){

       return repository.findAll();
    }

    public boolean authenticatedUser(String login, String password){

       Optional<Client>  opClient = repository.findByLogin(login);
        if (opClient.isPresent() && opClient.get().getPassword().equals(password)) {

            System.out.println("Login autenticado com sucesso para o usuário: " + opClient.get().getLogin());
            return true;
        } else {
            // Log para verificar se o login falhou
            System.out.println("Login falhou para o usuário: " + opClient.get().getLogin()+ " senha: "+ opClient.get().getPassword());
            return false;
        }



    }



}

