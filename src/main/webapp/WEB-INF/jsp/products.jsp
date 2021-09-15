<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>
<jsp:include page="menu_right.jsp"/>
<jsp:include page="topsection.jsp"/>


<section>
    <div class="main-content">
        <div class="section__content section__content--p10">
            <!-- TASK PROGRESS-->
            <div class="task-progress">
                <%--    <h3 class="title-3">task progress</h3>--%>
                <div class="au-skill-container">
                    <h3 class="title-1 m-b-5">
                        <button type="button" class="btn btn-secondary">poprzedni</button>
                        <button type="button" class="btn btn-primary">następny</button>
                    </h3>

                </div>
            </div>
            <!-- END TASK PROGRESS-->
            <div class="container-fluid">
                <!-- DATA TABLE -->
                <form method="get">
                <div class="alert alert-primary">
                    <h3><input type="text" name="search">
                        <button type="submit" class="btn btn-primary">Wyszukaj</button>
                    </h3>
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
                                <td>${p.name}</td>
                                <td>${p.proteins}</td>
                                <td>${p.carbs}</td>
                                <td>${p.fat}</td>
                                <td>${p.calories}</td>
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

<jsp:include page="footer.jsp"/>