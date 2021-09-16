<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/menu_right.jsp"/>

<jsp:include page="../components/topsection.jsp"/>

<!-- BREADCRUMB-->
<section class="au-breadcrumb m-t-40">
    <div class="section__content section__content--p30">
    </div>
</section>
<!-- END BREADCRUMB-->

<section>
    <div class="section__content section__content--p30">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-6">
                    <!-- USER DATA-->
                    <div class="user-data m-b-40">
                        <h3 class="title-3 m-b-30">
                            <i class="zmdi zmdi-account-calendar"></i>Uzytkownicy</h3>
                        <div class="table-responsive table-data">
                            <table class="table">
                                <thead>
                                <tr>
                                    <td>Nazwa</td>
                                    <td>e-mail</td>
                                    <td>rola</td>
                                    <td></td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <div class="table-data__info">
                                            <h6>lori lynch</h6>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="table-data__info">
                                            <h6><a href="#">johndoe@gmail.com</a></h6>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="role admin">admin</span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- END USER DATA-->
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../components/footer.jsp"/>