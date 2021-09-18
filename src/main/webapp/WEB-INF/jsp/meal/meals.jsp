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
                        <span class="au-progress__title">Kalorie - ${data.calories} /<b>${data.calDemand}</b></span>
                        <div class="au-progress__bar">
                            <div class="progress mb-2">
                                <div class="progress-bar bg-success" role="progressbar" style="width: ${data.caloriesPercent}%" aria-valuenow="${data.caloriesPercent}%" aria-valuemin="0" aria-valuemax="100">${data.caloriesPercent}%</div>
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Białko - ${data.protein} /<b>${data.proteinDemand}</b></span>
                        <div class="progress mb-2">
                            <div class="progress-bar bg-success" role="progressbar" style="width: ${data.proteinPercent}%" aria-valuenow="${data.proteinPercent}%" aria-valuemin="0" aria-valuemax="100">${data.proteinPercent}%</div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Węglowodany - ${data.carbs} /<b>${data.carbsDemand}</b></span>
                        <div class="progress mb-2">
                            <div class="progress-bar bg-success" role="progressbar" style="width: ${data.carbsPercent}%" aria-valuenow="${data.carbsPercent}%" aria-valuemin="0" aria-valuemax="100">${data.carbsPercent}%</div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Tłuszcze  - ${data.fat} /<b>${data.fatDemand} </b></span>
                        <div class="progress mb-2">
                            <div class="progress-bar bg-success" role="progressbar" style="width: ${data.fatPercent}%" aria-valuenow="${data.fatPercent}%" aria-valuemin="0" aria-valuemax="100">${data.fatPercent}%</div>
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
                            <th class="col col-md-5">Produkt</th>
                            <th class="col col-md-3">Białka</th>
                            <th class="col col-md-3">Węglowodany</th>
                            <th class="col col-md-3">Tłuszcze</th>
                            <th class="col col-md-3">Kcal</th>
                            <th class="col col-md-3">Gramatura</th>
                            <th>
                                <a href="ingredient/search/${param.date}/${meal.id}/">
                                    <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                        <i class="zmdi zmdi-plus"></i></button>
                                </a>
                            </th>
                        </tr>
                        <c:forEach items="${meal.ingredients}" var="ingredient">
                        <tr class="tr-shadow">
                            <td class="col col-md-5"><b>${ingredient.name}</b><br>${ingredient.brand}</td>
                            <td class="col col-md-3"><b>${ingredient.protein}</b><br>${ingredient.proteinPer100g}<br><small>w 100g</small></r></td>
                            <td class="col col-md-3"><b>${ingredient.carbs}</b><br>${ingredient.carbsPer100g}<br><small>w 100g</small></td>
                            <td class="col col-md-3"><b>${ingredient.fat}</b><br>${ingredient.fatPer100g}<br><small>w 100g</small></td>
                            <td class="col col-md-3"><b>${ingredient.calories}</b><br>${ingredient.caloriesPer100g}<br><small>w 100g</small></td>
                            <form method="get" action="/ingredient/edit">
                                <td><b><big><div class="col col-md-2" >wartość<br><input type="text" name="quantity" pattern="\d+" min="0" style="background-color: #00a2e3" value="${ingredient.quantity} "/></div></big></b></td>
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