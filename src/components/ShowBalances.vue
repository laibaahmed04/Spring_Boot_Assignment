<template>
    <div class = "container" style="height:50cm; weight:69cm;"    >

                <h1 class = "text-center"  id="table"> Balance List</h1>

                <table class = "table" >
                    <thead>
                        <tr>
                            <th> Account Id</th>
                            <th> Amount</th>
                            <th> Indicator</th>
                            <th> Date</th>

                        </tr>

                    </thead>
                    <tbody>
                        <tr v-for="account in Balance" v-bind:key="account.id">

                             <td> {{account.id}}</td>
                            <td> {{account.amount}}</td>
                            <td> {{account.indicator}}</td>
                            <td> {{account.date}}</td>

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
      Balance: [],
      isAuthenticated: true,
      errorMessage: '',
      webSocketError: '',
    };
  },
  methods: {
    getBalance() {
      AccountService.getBalance()
        .then((response) => {
          this.Balance = response.data;
        })
        .catch((error) => {
      window.alert("You've not logged in");
        console.error("Error deleting account:", error);
        });
    },

  },
  created() {
    this.getBalance();

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