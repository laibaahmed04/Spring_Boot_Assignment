<template>


  <div>
      <section class="vh-100" style="background-color: rgb(184, 150, 122); ">
        <div class="container py-5 h-100" >
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
              <div class="card" style="border-radius: 1rem; width: 24cm; height:12cm;">
                <div class="row g-0">
                  <div class="col-md-6 col-lg-5 d-none d-md-block">
                    <img src="./media/login2.jpg"
                      alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; height:12cm; width:12cm;  " />
                  </div>
                  <div class="col-md-6 col-lg-7 d-flex align-items-center">
                    <div class="card-body p-4 p-lg-5 text-black">

                      <form>

                        <div class="d-flex align-items-center mb-3 pb-1">
                          <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                          <span class="h1 fw-bold mb-0"></span>
                        </div>

                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Delete Account</h5>

                        <div class="form-outline mb-4">
                       <input type="text" id="accountId" v-model="accountId" style="height:1.2cm; width:8cm;"/>
                        </div>

                        <div class="pt-1 mb-4">
                          <button class="btn btn-dark btn-lg btn-block" type="button" @click="deleteAccount" >Delete Account</button>
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
import AccountService from '../services/AccountService';
import router from '../index';

export default {
  name: 'DeleteAccount',
  data() {
    return {
      accountId: '', // Holds the user-entered account ID
    };
  },
  methods: {
    deleteAccount() {
      const accountId = this.accountId;
      console.log('Account ID to delete:', this.accountId);



      AccountService.deleteAccount(accountId)
        .then(() => {
          router.push({ name: 'Accounts' });
        })
      .catch((error) => {
        console.error("Error deleting account:", error);
        window.alert("You've not logged in");
      });
    },
  },
};
</script>
