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
                <div class="au-skill-container">
                    <h3 class="title-5 m-b-35">
                        <form action="" method="get">
                            <input type="date" name="date" value="${param.date}" onchange="this.form.submit()"></form>
                    </h3>
                    <div class="au-progress">
                        <span class="au-progress__title">Kalorie</span>
                        <div class="progress mb-2">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 75%"
                                 aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">75%
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Białko</span>
                        <div class="progress mb-2">
                            <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50"
                                 aria-valuemin="0" aria-valuemax="100">50%
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Węglowodany</span>
                        <div class="progress mb-2">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 25%"
                                 aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Tłuszcze</span>
                        <div class="progress mb-2">
                            <div class="progress-bar bg-danger" role="progressbar" style="width: 90%" aria-valuenow="90"
                                 aria-valuemin="0" aria-valuemax="100">90%
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END TASK PROGRESS-->
            <div class="container-fluid">

                <!-- DATA TABLE -->
                <c:forEach items="${meals}" var="meal">
                <div class="alert alert-primary"><b>${meal.mealName.name}</b></div>
                <div class="table-responsive table-responsive-data2">
                    <table class="table table-data2">
                        <tr>
                            <th>Produkt</th>
                            <th>Białka</th>
                            <th>Węglowodany</th>
                            <th>Tłuszcze</th>
                            <th>Kcal</th>
                            <th>Gramatura</th>
                            <th>
                                <a href="ingredient/search/${param.date}/${meal.id}/">
                                    <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                        <i class="zmdi zmdi-plus"></i></button>
                                </a>
                            </th>
                        </tr>
                        <c:forEach items="${meal.ingredients}" var="ingredient">
                        <tr class="tr-shadow">
                            <td>${ingredient.name}</td>
                            <td>${ingredient.protein}</td>
                            <td>${ingredient.carbs}</td>
                            <td>${ingredient.fat}</td>
                            <td>${ingredient.calories}</td>
                            <form method="get" action="/ingredient/edit">
                                <td><input type="text" name="quantity" value="${ingredient.quantity}"></td>
                                <input type="hidden" name="id" value="${ingredient.id}">
                                <input type="hidden" name="date" value="${param.date}">

                                <td>
                                    <div class="table-data-feature">
                                            <%--                                        <a href="/ingredient/edit/${ingredient.id}">--%>
                                        <button class="item" type="submit" data-toggle="tooltip"
                                                data-placement="top"
                                                title="Edytuj gramaturę"><i class="zmdi zmdi-edit"></i>
                                        </button>
                            </form>
                            <a href="/ingredient/delete/${ingredient.id}/${param.date}">
                                <button class="item" data-toggle="tooltip"
                                        data-placement="top"
                                        title="Usuń produkt">
                                    <i class="zmdi zmdi-delete"></i>
                                </button>
                            </a>
                </div>
                </td>
                </tr>
                </c:forEach>
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