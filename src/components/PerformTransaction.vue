<template>
   <div class="container p-0">
           <div class="card px-4"  style="height:16cm;  "  >
               <p class="h8 py-3">Transaction Details</p>
               <div class="row gx-3">
                   <div class="col-12">
                       <div class="d-flex flex-column">
                           <p class="text mb-1">Transaction Id</p>

                           <input class="form-control mb-3" type="text" placeholder="  Enter your Id" v-model="transaction.transactionId">
                       </div>
                   </div>
                   <div class="col-12">
                       <div class="d-flex flex-column">
                           <p class="text mb-1">Account Id</p>
                          <input class="form-control mb-3" type="text" placeholder="  Enter your Account Id" v-model="transaction.account_ID">
                       </div>
                   </div> <div class="col-12">
                       <div class="d-flex flex-column">
                      <p class="text mb-1">Description</p>
                         <input class="form-control mb-3" type="text" placeholder="  Enter Details of Transaction" v-model="transaction.description">
               </div>
                                             </div>
                   <div class="col-6">
                       <div class="d-flex flex-column">
                           <p class="text mb-1">Amount</p>
                          <input class="form-control mb-3" type="text" placeholder="  Enter Amount" v-model="transaction.amount">
                       </div>
                   </div>
                   <div class="col-6">
                       <div class="d-flex flex-column">
                           <p class="text mb-1">Indicator</p>
                          <input class="form-control mb-3" type="text" placeholder="  DB/CR" v-model="transaction.indicator">
                       </div>
                   </div>


                   <div class="col-12">
                          <button class="btn btn-primary mb-3" type="button" @click="PerformTransaction" >Transact</button>
                           <span class="fas fa-arrow-right"></span>

                   </div>
               </div>
           </div>
       </div>
</template>

<script>
import AccountService from '../services/AccountService';
import router from '../index';

export default {
  name: 'PerformTransaction',
  data() {
    return {
        transaction: {
           account_ID: "",
           transactionId: "",
           description: "",
           amount: "",
           indicator: "",
         },
      isAuthenticated: true,
      errorMessage: '',
    };
  },
 methods: {
     PerformTransaction() {
       console.log("Account object before POST:", this.transaction);
       console.log("id object before POST:", this.transaction.transactionId);
       AccountService.performTransaction(this.transaction)
       .then((response) => {
       console.log("Account updated successfully:", response.data);
       router.push({ name: "Accounts" });
         })
         .catch(() => {
           window.alert("You've not logged in");

         });
     },
   },
};
</script>



<style>
</style>