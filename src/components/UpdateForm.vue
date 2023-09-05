
<template>

      <div>
      <section class="vh-100" style="background-color: rgb(184, 150, 122); ">
        <div class="container py-5 h-100" >
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
              <div class="card" style="border-radius: 1rem; width: 24cm;">
                <div class="row g-0">
                  <div class="col-md-6 col-lg-5 d-none d-md-block">
                    <img src="./media/login2.jpg"
                      alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                  </div>
                  <div class="col-md-6 col-lg-7 d-flex align-items-center">
                    <div class="card-body p-4 p-lg-5 text-black">

                      <form>

                        <div class="d-flex align-items-center mb-3 pb-1">
                          <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                          <span class="h1 fw-bold mb-0"></span>
                        </div>

                        <h2 id="title"  class="fw-normal mb-3 pb-3" >Update your Account</h2>


                        <div class="form-outline mb-4">
                     <input type="text" placeholder="  Enter your Id"    name="id" v-model="account.id" style="height:1cm; width:8cm;"/>
                        </div>

                   <div class="form-outline mb-4">
                       <input type="text" placeholder="  Enter your Name"  name="name" v-model="account.name" style="height:1cm; width:8cm;"/>
                        </div>

                      <div class="form-outline mb-4">
                   <input type="text"  placeholder="  Enter your Address" name="address" v-model="account.address" style="height:1cm; width:8cm;" />
                          </div>

                          <div class="form-outline mb-4">
                       <input type="text" placeholder="  Enter your Email" name="email" v-model="account.email" style="height:1cm; width:8cm;"/>
                          </div>


                          <div class="form-outline mb-4">
                    <input type="text" placeholder="  Enter your Password" name="password" v-model="account.password" style="height:1cm; width:8cm;"/>
                            </div>

                        <div class="pt-1 mb-4">
                          <button class="btn btn-dark btn-lg btn-block" type="button" @click="UpdateForm" >Update</button>
                        </div>
                      </form>

                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
  </div>

</template>

<script>
import AccountService from "../services/AccountService";
import router from '../index';

export default {
  name: 'UpdateForm',
  data() {
    return {
      account: {
        name: "",
        id: "",
        address: "",
        email: "",
        password: "",
      },
    };
  },
  methods: {
    UpdateForm() {
      console.log("Account object before POST:", this.account);
      const account_update = this.account;
      console.log("id object before POST:", account_update.id);
      AccountService.UpdateForm(account_update.id, this.account)
        .then((response) => {
          console.log("Account updated successfully:", response.data);
          router.push({ name: "Accounts" });
        })
        .catch(() => {
          window.alert("You've not logged im");

        });
    },
  },
};
</script>
<style>

#title{
margin-left : -1cm;
font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
font-size :45px;
}



</style>
