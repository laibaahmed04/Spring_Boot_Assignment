
<template>

<nav class="navbar navbar-expand-lg"  >
  <div class="container-fluid">
    <a class="navbar-brand" id="title" href="#" >Heritage Trust Bank</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./AdminOptions">I am an Admin</a>
        </li>
        <li class="nav-item">
                       <a class="nav-link" href="./UserOptions">I am User</a>
                     </li>


      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<div id="carouselExample" class="carousel slide">
  <div class="carousel-inner">
    <!-- Carousel items -->
    <div class="carousel-item active">
      <img src="./media/4.jpg" class="d-block w-100" alt="...">

</div>
    <div class="carousel-item">
      <!-- Content of the second slide -->
    </div>
    <!-- Add more carousel items as needed -->
  </div>
  <!-- Carousel navigation buttons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

</template>
<style>
.navbar{
background-color: rgb(184, 150, 122);
height :2cm;
 margin-top : -1.3cm;
 margin-bottom:.5cm;
 }
 #title{
 padding-left : 1cm;
font-size :28px;
 color: black;
 font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;

 }
.nav-item{
   padding-left : 0.5cm;
font-size :23px;
 font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;

   }
</style>

<script>
import $ from 'jquery';

export default {
  name: 'WelcomeForm',
 mounted() {
    // Initialize the Bootstrap carousel
    $('.carousel').carousel();
  },



};
</script>
