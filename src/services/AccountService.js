import axios from 'axios';

const ACCOUNT_API_BASE_URL = '/api/bank';
const BALANCE_API_BASE_URL = '/api/bank/balance';
const TRANSACTION_API_BASE_URL ='/api/bank/transaction';

export default {
  getAccounts() {
    return axios.get(ACCOUNT_API_BASE_URL);
  },
  createAccount(account) {
    return axios.post(ACCOUNT_API_BASE_URL, account);
  },
  deleteAccount(accountId) {
      return axios.delete(`${ACCOUNT_API_BASE_URL}/${accountId}`);
    },
  UpdateForm(accountId, updatedAccount) {
        return axios.put(`${ACCOUNT_API_BASE_URL}/${accountId}`, updatedAccount);
      },

         FormLogin() {
 return axios.post("http://localhost:9080/login");
     },
      getBalance() {
         return axios.get(BALANCE_API_BASE_URL);
       },
performTransaction(transaction) {
    return axios.post(TRANSACTION_API_BASE_URL, transaction);
  },
};