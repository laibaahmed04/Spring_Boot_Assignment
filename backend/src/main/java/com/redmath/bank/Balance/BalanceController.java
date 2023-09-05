package com.redmath.bank.Balance;
import com.redmath.bank.Account.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/bank/balance")
public class BalanceController {

private final BalanceService service;

BalanceController(BalanceService service){
    this.service=service;
}
    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Balance>> find_all_accounts(){

        return ResponseEntity.ok(service.find_All());
    }





}
