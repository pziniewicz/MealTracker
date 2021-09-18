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
                <div class="au-skill-container">
                    <h3 class="title-1 m-b-5">
                        Wyszukiwarka Produktów
<%--                        <button type="button" class="btn btn-secondary">poprzedni</button>--%>
<%--                        <button type="button" class="btn btn-primary">następny</button>--%>
                    </h3>
                </div>
            </div>
            <!-- END TASK PROGRESS-->
            <div class="container-fluid">
                <!-- DATA TABLE -->
                <form method="get">
                <div class="alert alert-primary">
                    <h3><input type="text" name="search" value="${param.search}">
                        <button type="submit" class="btn btn-primary">Wyszukaj</button>
                    </h3>
                </div>
                </form>
                <div class="table-responsive table-responsive-data2">
                    <table class="table table-data2">
                        <tbody>
                        <%--                        <thead>--%>
                        <tr>
                            <th>Produkt (wartości w 100g)</th>
                            <th>Białka</th>
                            <th>Węglowodany</th>
                            <th>Tłuszcze</th>
                            <th>Kcal</th>
                        </tr>
                        <c:forEach items="${productList}" var="p">
                            <tr class="tr-shadow">
                                <td><b><c:out value="${empty p.name ? p.name2 : p.name}" /></b><br>${p.brand}</td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.proteins}"/></td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.carbs}"/></td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.fat}"/></td>
                                <td><fmt:formatNumber maxFractionDigits="2" value="${p.calories}"/></td>
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