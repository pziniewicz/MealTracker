<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../menu_right.jsp"/>

<jsp:include page="../topsection.jsp"/>

<!-- BREADCRUMB-->
<section class="au-breadcrumb m-t-40">
    <div class="section__content section__content--p30">
    </div>
</section>
<!-- END BREADCRUMB-->

<section>
    <div class="section__content section__content--p30">
        <div class="container-fluid">
            <!-- DATA TABLE -->
            <h3 class="title-5 m-b-35">Lista planow</h3>
            <div class="table-data__tool">
                <div class="table-data__tool-right">
                    <a href="/plan/create">
                        <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                            <i class="zmdi zmdi-plus"></i>Nowy plan
                        </button>
                    </a>
                </div>
            </div>
            <div class="table-responsive table-responsive-data2">
                <table class="table table-data2">
                    <thead>
                    <tr>
                        <th>Nazwa planu</th>
                        <th>Parametry</th>
                        <th>Aktywny</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${plans}" var="p">
                        <tr class="tr-shadow">
                            <td>${p.name}</td>
                            <td>
    <span>
    Waga: ${p.weight} Wzrost: ${p.height}<br>
    Wiek: ${p.age} Płeć: ${p.gender}<br>
    Makra: <br>
    B: ${p.proteinQuantity} W: ${p.carbsQuantity} T: ${p.fatQuantity}
    </span>
                            </td>
                            <td class="desc">${p.isActive}</td>
                            <td>
                                <div class="table-data-feature">
                                    <a href="/plan/setActive/${p.id}">
                                        <button class="item" data-toggle="tooltip" data-placement="top"
                                                title="SetActive">
                                            <i class="zmdi zmdi-mail-send"></i>
                                        </button>
                                    </a>
                                    <a href="/plan/create?id=${p.id}">
                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Edit">
                                            <i class="zmdi zmdi-edit"></i>
                                        </button>
                                    </a>
                                    <a href="/plan/delete/${p.id}">
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
            <!-- END DATA TABLE -->
        </div>
    </div>
</section>

<jsp:include page="../footer.jsp"/>