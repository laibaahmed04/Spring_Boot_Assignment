package com.redmath.bank.Account;

import com.redmath.bank.User.User;
import com.redmath.bank.User.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
  //  Authentication author;
   private final AccountRepository repository;
   private final UserService uservice;
   User user=null;
    AccountService(AccountRepository repository,UserService uservice){
        this.repository=repository;
        this.uservice=uservice;

    }

     public List<Account> find_All(){
        return repository.findAll();
     }

    public Optional<Account> Find_by_Id(Long id){

        return repository.findById(id);

    }

    public Account create_account(Account account){
            if(account.getId()!= null && repository.existsById(account.getId())) {
                return null;
            }
           //account.setId(3L);
        System.out.println("user banny lga");
        System.out.println(account.getId());


       user = new User(account.getId(), account.getName(), account.getPassword(),"Account_Holder");

//        user.setId(account.getId());
//        user.setuserName(account.getName());
//        user.setPassword(account.getPassword());
//        user.setRole("Account_Holder");
             uservice.create_account(user);
            return repository.save(account);


    }

    public void delete(Long id)
    {
        repository.deleteById(id);
    }

    public Account update_account(Long id, Account account)
    {
    Optional<Account> existing_account = repository.findById(id);

    if(existing_account.isPresent()){

        Account existing_acc = existing_account.get();
        existing_acc.setName(account.getName());
        existing_acc.setAddress(account.getAddress());
        existing_acc.setEmail(account.getEmail());
        existing_acc.setPassword(account.getPassword());
        return repository.save(existing_acc);

    }

else{
    return null;
    }

    }

}

