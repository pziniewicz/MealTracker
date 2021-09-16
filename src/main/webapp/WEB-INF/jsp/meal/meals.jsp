<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/menu_right.jsp"/>

<jsp:include page="../components/topsection.jsp"/>


<section>
    <div class="main-content">
        <div class="section__content section__content--p10">
            <!-- TASK PROGRESS-->
            <div class="task-progress">
                <%--    <h3 class="title-3">task progress</h3>--%>
                <div class="au-skill-container">
                    <h3 class="title-5 m-b-35">
                        <form action="" method="get">
                            <input type="date" name="date" value="${param.date}" onchange="this.form.submit()"></form>
                    </h3>
                    <div class="au-progress">
                        <span class="au-progress__title">Kalorie</span>
                        <div class="au-progress__bar">
                            <div class="au-progress__inner js-progressbar-simple" role="progressbar"
                                 data-transitiongoal="90">
                                <span class="au-progress__value js-value"></span>
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Białko</span>
                        <div class="au-progress__bar">
                            <div class="au-progress__inner js-progressbar-simple" role="progressbar"
                                 data-transitiongoal="85">
                                <span class="au-progress__value js-value"></span>
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Węglowodany</span>
                        <div class="au-progress__bar">
                            <div class="au-progress__inner js-progressbar-simple" role="progressbar"
                                 data-transitiongoal="95">
                                <span class="au-progress__value js-value"></span>
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Tłuszcze</span>
                        <div class="au-progress__bar">
                            <div class="au-progress__inner js-progressbar-simple" role="progressbar"
                                 data-transitiongoal="95">
                                <span class="au-progress__value js-value"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END TASK PROGRESS-->
            <div class="container-fluid">


                <!-- DATA TABLE -->
                <c:forEach items="${mealNames}" var="mealname">
                <div class="alert alert-primary"><b>${mealname.name}</b></div>
                <div class="table-responsive table-responsive-data2">
                    <table class="table table-data2">
                        <tbody>
                        <%--                        <thead>--%>
                        <tr>
                            <th>
                                <center>Produkt</center>
                            </th>
                            <th>Białka</th>
                            <th>Węglowodany</th>
                            <th>Tłuszcze</th>
                            <th>Kcal</th>
                            <th>Gramatura</th>
                            <th>
                                <a href="meal/create/${param.date}/${mealname.id}">
                                    <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                     <i class="zmdi zmdi-plus"></i></button></a>
                            </th>
                        </tr>
                        <%--                        </thead>--%>
                        <%--                        <tbody>--%>
                        <%--                    <c:forEach items="${plans}" var="p">--%>
                        <tr class="tr-shadow">
                            <td>nazwa skladnika</td>
                            <td>211</td>
                            <td>44g</td>
                            <td>5g</td>
                            <td>4g</td>
                            <td>10g</td>
                            <td>
                                <div class="table-data-feature">
                                    <%--                                    <a href="/plan/create?id=${p.id}">--%>
                                    <button class="item" data-toggle="tooltip" data-placement="top" title="Edit">
                                        <i class="zmdi zmdi-edit"></i>
                                    </button>
                                    </a>
                                    <%--                                    <a href="/plan/delete/${p.id}">--%>
                                    <button class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                        <i class="zmdi zmdi-delete"></i>
                                    </button>
                                    </a>
                                </div>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                    <br>
                </div>
                </c:forEach>
                <br>
                <!-- END DATA TABLE -->


            </div>
        </div>
    </div>
</section>

<jsp:include page="../components/footer.jsp"/>