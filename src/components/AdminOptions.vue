<template>

<div class="row row-cols-1 row-cols-md-2 g-4">
  <div class="col">
    <div class="card">
      <img src="./media/show.jpg" class="card-img-top" alt="...">
      <div class="card-body" style="background-color: rgb(184, 150, 122);">
    <a href="./Accounts" id="title" >Show All Accounts</a>

        <p class="card-text">Display of all honourable users at Heritage Trust Bank ltd</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="./media/signup.jpg" class="card-img-top" alt="...">
      <div class="card-body"  style="background-color: rgb(184, 150, 122);">
    <a href="./AccountForm" id="title" >Create Account</a>
        <p class="card-text">Empower Your Team: Administering Excellence at Heritage Trust Bank</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="./media/signup.jpg" class="card-img-top" alt="...">
      <div class="card-body" style="background-color: rgb(184, 150, 122);">
    <a href="./DeleteAccount" id="title" >Delete Account</a>
        <p class="card-text">Streamline the Financial Journey: Closure Options at Heritage Trust Bank</p>
      </div>
    </div>
  </div> <div class="col"   >
            <div class="card" >
              <img src="./media/delete.jpg" class="card-img-top" alt="..."  >
              <div class="card-body" style="background-color: rgb(184, 150, 122);">
                <a href="./ShowBalances" id="title" >Show Balance</a>

                <p class="card-text">Check your balance
               and stay up-to date free of cost!</p>
              </div>
            </div>
          </div>
  <div class="col">
      <div class="card">
        <img src="./media/signup.jpg" class="card-img-top" alt="...">
        <div class="card-body" style="background-color: rgb(184, 150, 122);">
    <a href="./UpdateForm" id="title" >Update Account</a>
          <p class="card-text">Revive Financial Experience: Elevate User Account at Heritage Trust Bank</p>
        </div>
      </div>
    </div>
</div>

</template>


<script>

export default {
  name: 'AdminOptions',
 mounted() {
    // Initialize the Bootstrap carousel
  //  $('.carousel').carousel();
  },



};


</script>




<style>
.card{
width : 13cm;
margin-left : 3cm;
margin-bottom:1cm;
}
#title{



}



</style>