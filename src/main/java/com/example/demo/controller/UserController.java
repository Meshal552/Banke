package com.example.demo.controller;


import com.example.demo.Form.AddManye;
import com.example.demo.Form.BankMany;
import com.example.demo.Form.Loan;
import com.example.demo.Form.WithdrewForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


import static java.lang.Integer.parseInt;

@RestController
public class UserController {
    ArrayList<UserUU> user = new ArrayList<>();
  double loan=100000;
    @GetMapping("users")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(user);
    }
      //add user
    @PostMapping("users")
    public  ResponseEntity<String> createUser(@RequestBody UserUU userUU) {
        if(!chack(userUU)){
            return ResponseEntity.status(400).body("not create");
        }
        if (userUU.getPassword().length() <=7)
        {
            return ResponseEntity.status(400).body(" you enter number last then 8");
        }
        for (int i=0; i<user.size(); i++)
        {
            if (user.get(i).getEmail().equals(userUU.getEmail()))
            {
              return ResponseEntity.status(400).body("chang the email")  ;
            }
        }
        user.add(userUU);
        return ResponseEntity.status(200).body("cerate");
    }
   //add Many
    @PostMapping("addManye")
    public ResponseEntity addMayne(@RequestBody AddManye addManye)
    {

        for (int i = 0; i <user.size() ; i++)
        {
            if(user.get(i).getId().equals(addManye.getId()))
            {
                if (user.get(i).getPassword().equals(addManye.getPassword()))
              user.get(i).setBalance(addManye.getBalance() + user.get(i).getBalance());
            }
        }
        return ResponseEntity.status(200).body(addManye);
    }
   //withdrew
    @PostMapping("withdrew")
    public  ResponseEntity withdrew(@RequestBody WithdrewForm withdrewForm)
    {
       for(int i=0; i<user.size(); i++)
       {
           if(user.get(i).getId().equals(withdrewForm.getId()))
           {
               if(user.get(i).getBalance()<withdrewForm.getWithdrewAmount()){
                   return ResponseEntity.status(400).body("you dont hahe many");
               }
               user.get(i).setBalance(user.get(i).getBalance()-withdrewForm.getWithdrewAmount());
               return ResponseEntity.status(200).body("withdrewAmount");
           }
       }
     return ResponseEntity.status(400).body("Not fund");
    }
 //take a loan
    @PostMapping("paymentLoanAmount")
    public ResponseEntity payment(@RequestBody  BankMany bankMany)
    {
        if(bankMany.getId()==null || bankMany.getPassword()==null || bankMany.getPayment() == 0){
            return ResponseEntity.status(400).body("fields are empty");
        }

        for (int i = 0; i < user.size(); i++) {
            UserUU u=user.get(i);
            if(u.getId().equals(bankMany.getId())){
                if(!(u.getPassword().equals(bankMany.getPassword()))){
                    return ResponseEntity.status(400).body(" password is incorrect ");
                }

                if(loan-bankMany.getPayment()<0){
                    return ResponseEntity.status(400).body("There is no money in the bank");
                }
                loan=loan-bankMany.getPayment();
                double oldLoan=u.getLoanAmount();
                double oldBalance=u.getBalance();
                u.setLoanAmount(bankMany.getPayment()+oldLoan);
                u.setBalance(bankMany.getPayment()+oldBalance);
                return ResponseEntity.status(200).body("Taking loan confirmed");
            }
        }
        return ResponseEntity.status(400).body("invalid card");
    }





    @PutMapping("users/{id}")
    public ResponseEntity rename(@PathVariable String id, @RequestBody UserUU userUU) {
        for(int i =0; i<user.size(); i++){
            if(user.get(i).getId().equals(id)){
                user.set(i , userUU);
                break;
            }

        }
        for (int i=0; i<user.size(); i++){
            if(user.get(i).getEmail().equals(userUU.getEmail())){
                return ResponseEntity.status(400).body("email cj");
            }
        }
        return ResponseEntity.status(200).body(" ubdate");
    }
// delete account
    @DeleteMapping("users/{id}")
    public ResponseEntity<String> Delete(@PathVariable String id) {
        boolean isFound=false;
        for (int i = 0; i < user.size() ; i++) {
            if(user.get(i).getId().equals(id)){
                if(user.get(i).getLoanAmount()>0){
                    return ResponseEntity.status(400).body("The loan must be paid off");
                }
                user.remove(i);
                break;
            }
            if(!isFound){
                return ResponseEntity.status(400).body("Verify identity");
            }
        }
        return ResponseEntity.status(200).body("ok deleted");
    }
    public  boolean chack(UserUU userUU){
        if (userUU.getId() == null  || userUU.getName() == null || userUU.getEmail() == null
                ) {
            return false;
        }
        return true;
    }
}