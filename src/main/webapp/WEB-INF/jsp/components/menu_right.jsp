<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<body class="animsition">
<div class="page-wrapper">
    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar2">
        <div class="logo">
            <a href="/">
                <img src="/images/logo.png" alt="Meal Tracker" />
            </a>
        </div>
        <div class="menu-sidebar2__content js-scrollbar1">
            <div class="account2">
                <div class="image img-cir img-120">
                    <img src="#" alt="" />
                </div>
                <h4><center><security:authorize access="isAuthenticated()">
                    <security:authentication property="principal.Username" />
                </security:authorize></center></h4>
                <a href="/logout">Wyloguj</a>
            </div>
            <nav class="navbar-sidebar2">
                <ul class="list-unstyled navbar__list">
                    <li>
                        <a href="/meal?date=<%= (java.time.LocalDate.now())%>">
                            <i class="fas fa-tasks"></i>Posilki</a>
                    </li>
<%--                    <li>--%>
<%--                        <a href="/new">--%>
<%--                            <i class="fas fa-calendar-alt"></i>Kalendarz</a>--%>
<%--                    </li>--%>
                    <li>
                        <a href="/plan">
                            <i class="far fa-check-square"></i>Plany</a>
                    </li>
                    <li>
                        <a href="/product">
                            <i class="fas fa-shopping-basket"></i>Wyszukaj produkt</a>
                    </li>
                    <li></li>
                    <li>
                        <a href="/user">
                            <i class="fas fa-user"></i>Uzytkownicy</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->