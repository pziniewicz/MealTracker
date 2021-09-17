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
                                    <a href="ingredient/${param.date}/${meal.id}/">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                            <i class="zmdi zmdi-plus"></i></button>
                                    </a>
                                </th>
                            </tr>
                            <c:forEach items="${meal.ingredients}" var="ingredients">
                                <tr class="tr-shadow">
                                    <td>${ingredients.name}</td>
                                    <td>${ingredients.protein}</td>
                                    <td>${ingredients.carbs}</td>
                                    <td>${ingredients.fat}</td>
                                    <td>${ingredients.calories}</td>
                                    <td>10g</td>
                                    <td>
                                        <div class="table-data-feature">
                                            <button class="item" data-toggle="tooltip" data-placement="top"
                                                    title="Edit">
                                                <i class="zmdi zmdi-edit"></i>
                                            </button>
                                            </a>
                                            <button class="item" data-toggle="tooltip" data-placement="top"
                                                    title="Delete">
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