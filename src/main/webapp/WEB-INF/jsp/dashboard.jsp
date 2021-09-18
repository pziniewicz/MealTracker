<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="components/header.jsp"/>
<jsp:include page="components/menu_right.jsp"/>

<jsp:include page="components/topsection.jsp"/>

<section>
    <div class="main-content">
        <div class="section__content section__content--p10">
            <!-- TASK PROGRESS-->
            <div class="task-progress">
                <div class="au-skill-container">
                    <h3 class="title-5 m-b-35">
                        ${date}
                    </h3>
                    <div class="au-progress">
                        <span class="au-progress__title">Kalorie - ${data.calories} /<b>${data.calDemand}</b></span>
                        <div class="au-progress__bar">
                            <div class="progress mb-2">
                                <div class="progress-bar bg-info" role="progressbar"
                                     style="width: ${data.caloriesPercent}%" aria-valuenow="${data.caloriesPercent}%"
                                     aria-valuemin="0" aria-valuemax="100">${data.caloriesPercent}%
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Białko - ${data.protein} /<b>${data.proteinDemand}</b></span>
                        <div class="au-progress__bar">
                        <div class="progress mb-2">
                            <div class="progress-bar bg-warning" role="progressbar"
                                 style="width: ${data.proteinPercent}%" aria-valuenow="${data.proteinPercent}%"
                                 aria-valuemin="0" aria-valuemax="100">${data.proteinPercent}%
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Węglowodany - ${data.carbs} /<b>${data.carbsDemand}</b></span>
                        <div class="au-progress__bar">
                        <div class="progress mb-2">
                            <div class="progress-bar bg-success" role="progressbar" style="width: ${data.carbsPercent}%"
                                 aria-valuenow="${data.carbsPercent}%" aria-valuemin="0"
                                 aria-valuemax="100">${data.carbsPercent}%
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="au-progress">
                        <span class="au-progress__title">Tłuszcze  - ${data.fat} /<b>${data.fatDemand} </b></span>
                        <div class="au-progress__bar">
                        <div class="progress mb-2">
                            <div class="progress-bar bg-danger" role="progressbar" style="width: ${data.fatPercent}%"
                                 aria-valuenow="${data.fatPercent}%" aria-valuemin="0"
                                 aria-valuemax="100">${data.fatPercent}%
                            </div>
                        </div>
                        </div>
                    </div>
                    <br><br>
                    <a href="/meal?date=${date}">Przejdź do szczegółów</a>
                </div>
            </div>
            <!-- END TASK PROGRESS-->
</section>

<jsp:include page="components/footer.jsp"/>
