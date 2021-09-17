<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/menu_right.jsp"/>
<jsp:include page="../components/topsection.jsp"/>


<section>
    <div class="main-content">
        <div class="section__content section__content--p10">
            <!-- TASK PROGRESS-->
            <div class="task-progress">
            </div>
            <!-- END TASK PROGRESS-->
            <div class="container-fluid">
                <!-- DATA TABLE -->
                <form method="get">
                    <div class="alert alert-primary">
                        <h2><input type="text" name="search" value="${param.search}">
                            <button type="submit" class="btn btn-primary">Wyszukaj</button>
                        </h2>
                    </div>
                </form>
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
                            <th><a href="/plan/create">
                                <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                    <i class="zmdi zmdi-plus"></i></button>
                            </a></th>
                        </tr>
                        <c:forEach items="${productList}" var="p">
                            <tr class="tr-shadow">
                                <td><b><c:out value="${empty p.name ? p.name2 : p.name}" /></b><br>${p.brand}</td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.proteins}"/></td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.carbs}"/></td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.fat}"/></td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.calories}"/></td>
                                <td>
                                    <div class="table-data-feature">
                                            <%--                                    <a href="/plan/create?id=${p.id}">--%>
                                        <a href="/meal/add/${date}/${mealId}/${empty p.name ? p.name2 : p.name}/
                                        ${p.brand}/${p.calories}/${p.carbs}/${p.proteins}/${p.fat}/${p.id}"> <button class="item" type="submit" data-toggle="tooltip" data-placement="top" title="Edit">
                                            <i class="zmdi zmdi-edit"></i>
                                        </button></a>
                                        </a>
                                            <%--                                    <a href="/plan/delete/${p.id}">--%>
                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                            <i class="zmdi zmdi-delete"></i>
                                        </button>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <br>
                <!-- END DATA TABLE -->
            </div>
        </div>
    </div>
</section>

<jsp:include page="../components/footer.jsp"/>