<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
>>>>>>> main

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Register</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">
    <div class="page-content--bge5">
        <div class="container">
            <div class="login-wrap">
                <div class="login-content">
                    <div class="login-logo">
                        <a href="#">
                            <img src="images/logo.png" alt="MealTracker">
                        </a>
                    </div>
                    <div class="login-form">
<<<<<<< HEAD
                        <form:form action="" method="post" modelAttribute="user">
                            <div class="form-group">
                                <form:label path="firstName">Imię</form:label>
                                <form:input path="firstName" class="au-input au-input--full" placeholder="Imię"/>
                                <form:errors path="firstName" cssClass="error" element="div"/>
                            </div>
                            <div class="form-group">
                                <form:label path="lastName">Nazwisko</form:label>
                                <form:input path="lastName" class="au-input au-input--full" placeholder="Nazwisko"/>
                                <form:errors path="lastName" cssClass="error" element="div"/>
                            </div>
                            <div class="form-group">
                                <form:label path="email">Email</form:label>
                                <form:input path="email" type="email" class="au-input au-input--full" placeholder="Email"/>
                                <form:errors path="email" cssClass="error" element="div"/>
                            </div>
                            <div class="form-group">
                                <form:label path="password">Hasło</form:label>
                                <form:input path="password" type="password"  class="au-input au-input--full" placeholder="Hasło"/>
                                <form:errors path="password" cssClass="error" element="div"/>
                            </div>

                            <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">Utwórz konto
                            </button>
                            <!-- <div class="social-login-content">-->
                            <!-- <div class="social-button">-->
                            <!-- <button class="au-btn au-btn&#45;&#45;block au-btn&#45;&#45;blue m-b-20">register with facebook</button>-->
                            <!-- <button class="au-btn au-btn&#45;&#45;block au-btn&#45;&#45;blue2">register with twitter</button>-->
                            <!-- </div>-->
                            <!-- </div>-->
                        </form:form>
=======
                        <form action="" method="post">
                            <div class="form-group">
                                <label>Imię</label>
                                <input class="au-input au-input--full" type="text" name="firstName" placeholder="Imię">
                            </div>
                            <div class="form-group">
                                <label>Nazwisko</label>
                                <input class="au-input au-input--full" type="text" name="lastName" placeholder="Nazwisko">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input class="au-input au-input--full" type="email" name="email" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <label>Hasło</label>
                                <input class="au-input au-input--full" type="password" name="password" placeholder="Hasło">
                            </div>
                            <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">Utwórz konto</button>
                            <!--                                <div class="social-login-content">-->
                            <!--                                    <div class="social-button">-->
                            <!--                                        <button class="au-btn au-btn&#45;&#45;block au-btn&#45;&#45;blue m-b-20">register with facebook</button>-->
                            <!--                                        <button class="au-btn au-btn&#45;&#45;block au-btn&#45;&#45;blue2">register with twitter</button>-->
                            <!--                                    </div>-->
                            <!--                                </div>-->
                        </form>
>>>>>>> main
                        <div class="register-link">
                            <p>
                                Już masz konto?
                                <a href="/login">Zaloguj</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Jquery JS-->
<script src="vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="vendor/bootstrap-4.1/popper.min.js"></script>
<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
<<<<<<< HEAD
<!-- Vendor JS -->
=======
<!-- Vendor JS       -->
>>>>>>> main
<script src="vendor/slick/slick.min.js">
</script>
<script src="vendor/wow/wow.min.js"></script>
<script src="vendor/animsition/animsition.min.js"></script>
<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="vendor/circle-progress/circle-progress.min.js"></script>
<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="vendor/chartjs/Chart.bundle.min.js"></script>
<script src="vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="js/main.js"></script>

</body>

</html>
<!-- end document-->