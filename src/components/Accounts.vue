<template>
    <div class = "container" style="height:50cm; weight:69cm;"    >

                <h1 class = "text-center"  id="table"> Accounts List</h1>

                <table class = "table" >
                    <thead>
                        <tr>
                            <th> Account Id</th>
                            <th> Name</th>
                            <th> Password</th>
                            <th> Email</th>
                            <th> Address</th>
                        </tr>

                    </thead>
                    <tbody>
                        <tr v-for="account in accounts" v-bind:key="account.id">

                            <td> {{account.name}}</td>
                             <td> {{account.id}}</td>
                            <td> {{account.password}}</td>
                                  <td> {{account.address}}</td>
                            <td> {{account.email}}</td>

                        </tr>
                    </tbody>
                </table>
            </div>

</template>

<script>
import AccountService from '../services/AccountService';

export default {
  name: 'AccountsList',
  data() {
    return {
      accounts: [],
      isAuthenticated: true,
      errorMessage: '',
      webSocketError: '',
    };
  },
  methods: {
    getAccounts() {
      AccountService.getAccounts()
        .then((response) => {
          this.accounts = response.data;
        })
        .catch((error) => {
      window.alert("You've not logged in");
        console.error("Error deleting account:", error);
        });
    },
    handleWebSocketError(event) {
      this.webSocketError = "WebSocket Error: " + event.message;
      window.alert(this.webSocketError);
    },
  },
  created() {
    this.getAccounts();

    // Create a WebSocket and handle its errors
    const webSocket = new WebSocket('ws://192.168.100.8:8080/ws');
    webSocket.addEventListener('error', this.handleWebSocketError);
  },
};
</script>



<style>
#table{
background-color: rgb(184, 150, 122);
color:black;
 font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
height: 1.6cm;

}


</style>