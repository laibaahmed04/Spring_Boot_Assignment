import { createRouter, createWebHistory } from 'vue-router';
import FormLogin from './components/FormLogin.vue';
import Accounts from './components/Accounts.vue';
import DeleteAccount from './components/DeleteAccount.vue';
import UpdateForm from './components/UpdateForm.vue';
import AccountForm from './components/AccountForm.vue';
import WelcomeForm from './components/WelcomeForm.vue';
import AdminOptions from './components/AdminOptions.vue';
import UserOptions from './components/UserOptions.vue';
import ShowBalances from './components/ShowBalances.vue';
import PerformTransaction from './components/PerformTransaction.vue';

const routes = [

{
     path: '/Welcome',
     name: 'WelcomeForm',
     component: WelcomeForm,
   },

  {
    path: '/login',
    name: 'FormLogin',
    component: FormLogin,
  },
  {
    path: '/AccountForm',
    name: 'AccountForm',
    component: AccountForm,
  },
   {
      path: '/Accounts',
      name: 'Accounts',
      component: Accounts,
    },
     {
        path: '/DeleteAccount',
        name: 'DeleteAccount',
        component: DeleteAccount,
      },
      {
         path: '/UpdateForm',
         name: 'UpdateForm',
         component: UpdateForm,
       },
       {
         path: '/AdminOptions',
         name: 'AdminOptions',
         component: AdminOptions,
       },
       {
         path: '/UserOptions',
         name: 'UserOptions',
         component:UserOptions,
              },
{
         path: '/ShowBalances',
         name: 'ShowBalances',
         component:ShowBalances,
              },{
                         path: '/PerformTransaction',
                         name: 'PerformTransaction',
                         component:PerformTransaction,
                              },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
