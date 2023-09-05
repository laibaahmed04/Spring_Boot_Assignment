package com.redmath.bank.Account;
import java.util.List;
import java.util.Optional;


import com.redmath.bank.User.User;
import com.redmath.bank.User.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
@CrossOrigin
public class AccountController {
    private final AccountService service;
    AccountController(AccountService service ){
    this.service=service;
   }
// @CrossOrigin("http://localhost:8080")

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping
  public ResponseEntity<List<Account>> find_all_accounts(){

        return ResponseEntity.ok(service.find_All());
  }



//    @CrossOrigin("http://localhost:8080")
@PreAuthorize("hasAuthority('Admin')")
@GetMapping("/{id}")
   public ResponseEntity<Account> Find_by_id(@PathVariable("id") Long id)
   {
       Optional<Account> account = service.Find_by_Id(id);
       if(account.isEmpty()){

            return ResponseEntity.notFound().build();

       }

    else{
    return ResponseEntity.ok(account.get());
       }
  }
//    @PreAuthorize("hasAuthority('Admin')")


    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping()
    public ResponseEntity<Account> Create_Account(@RequestBody Account account){
       Account account_created = service.create_account(account);

       if(account_created!=null){
        return ResponseEntity.ok(account_created);
    }
    else{
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

  }

  @PreAuthorize("hasAuthority('Admin')")
  @DeleteMapping("/{id}")
    public void delete_by_id(@PathVariable("id") Long id)
    {
        service.delete(id);
    }



//    @CrossOrigin("http://localhost:8080")


    @PreAuthorize("hasAuthority('Admin')")
    @PutMapping("/{id}")
    public ResponseEntity<Account> Update_Account(@PathVariable Long id, @RequestBody Account account)
{
    Account acc = service.update_account(id,account);

    if(acc!=null)
    {

        return ResponseEntity.ok(acc);
    }
   return ResponseEntity.notFound().build();


}

}
