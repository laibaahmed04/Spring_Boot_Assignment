
package com.redmath.bank.User;

import com.redmath.bank.Account.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static jakarta.transaction.Status.STATUS_ACTIVE;
import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.enabled;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository repository;


    UserService(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid user: " + userName);
        }
//        boolean enabled = STATUS_ACTIVE.equals(user.getStatus());
//        boolean notLocked = user.getLoginAttempts() == null || user.getLoginAttempts() < loginAttemptsMax;
        return new org.springframework.security.core.userdetails.User(user.getuserName(), user.getPassword(),AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole()));
    }
    public User findByUsername(String username) {
        return repository.findByUserName(username);
    }

    public StatusLogin login_service(LoginDto user) {
     StatusLogin statusLogin=null;
        User user_from_repo = repository.findByUserName(user.getUserName());
        if (user_from_repo != null) {
            System.out.println("repo user found");
            if (user.getPassword().equals(user_from_repo.getPassword())) {
                System.out.println("repo user found password match");
                if (user_from_repo.getRole().equals("Admin")) {
                    System.out.println("repo admin found password match");

                   statusLogin = new StatusLogin("Login Succeed", true, "Admin");
                }
                if (user_from_repo.getRole().equals("Account_Holder")) {
                    statusLogin = new StatusLogin("Login Succeed", true, "Account_Holder");
                }
            }
            else {
                statusLogin = new StatusLogin("Login Failed", false, "s");
            }
        }
        return statusLogin;
    }
    public User create_account(User user){
            System.out.println("user created");
        if(user.getId()!= null && repository.existsById(user.getId())) {
            return null;
        }
        System.out.println(user.getId());
        System.out.println(user.getuserName());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());


        return repository.save(user);


    }





}