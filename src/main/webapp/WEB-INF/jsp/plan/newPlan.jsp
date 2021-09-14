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
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <strong>Nowy</strong> Plan
                        </div>
                        <div class="card-body card-block">
                            <form:form action="" method="post" modelAttribute="plan" enctype="multipart/form-data"
                                       class="form-horizontal">

                            <div class="row form-group">
                                <div class="col col-md-2">
                                    <form:label path="height">Wzrost</form:label>
                                </div>
                                <div class="col-12 col-md-3">
                                    <form:input path="height" class="form-control" placeholder="wzrost"/>
                                    <form:errors path="height" cssClass="error" element="div"/>
                                    <small class="form-text text-muted">cm</small>
                                </div>
                                <div class="col col-md-2">
                                    <form:label path="weight">Waga</form:label>
                                </div>
                                <div class="col-12 col-md-3">
                                    <form:input path="weight" class="form-control" placeholder="waga"/>
                                    <form:errors path="weight" cssClass="error" element="div"/>
                                    <small class="form-text text-muted">kg</small>
                                </div>
                            </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <form:label path="age">Wiek </form:label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <form:input path="age" class="form-control" placeholder="%"/>
                                        <form:errors path="age" cssClass="error" element="div"/>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <form:label path="gender">Płeć </form:label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <form:select path="gender">
                                        <form:option value="1" label="Kobieta"></form:option>
                                        <form:option value="2" label="Mężczyzna"></form:option>
                                        </form:select>
                                        <form:errors path="gender" cssClass="error" element="div"/>
                                    </div>
                                </div>
                                <%--    <div class="row form-group">--%>
                                <%--    <div class="col col-md-3">--%>
                                <%--    <label for="text-input" class=" form-control-label">Zapotrzebowanie--%>
                                <%--    kaloryczne </label>--%>
                                <%--    </div>--%>
                                <%--    <div class="col-12 col-md-3">--%>
                                <%--    <input type="text" id="text-input" name="text-input" placeholder="Text"--%>
                                <%--    class="form-control">--%>
                                <%--    <small class="form-text text-muted">kCal</small>--%>
                                <%--    </div>--%>
                            <div class="row form-group">
                                <div class="col col-md-3">
                                    <form:label path="proteinPercent">Białka %</form:label>
                                </div>
                                <div class="col-12 col-md-3">
                                    <form:input path="proteinPercent" class="form-control" placeholder="%"/>
                                    <form:errors path="proteinPercent" cssClass="error" element="div"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col col-md-3">
                                    <form:label path="carbsPercent">Węglowodany %</form:label>
                                </div>
                                <div class="col-12 col-md-3">
                                    <form:input path="carbsPercent" class="form-control" placeholder="%"/>
                                    <form:errors path="carbsPercent" cssClass="error" element="div"/>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col col-md-3">
                                    <form:label path="fatPercent">Tłuszcze %</form:label>
                                </div>
                                <div class="col-12 col-md-3">
                                    <form:input path="fatPercent" class="form-control" placeholder="%"/>
                                    <form:errors path="fatPercent" cssClass="error" element="div"/>

                                </div>
                            </div>
                                <%--    <div class="row form-group">--%>
                                <%--    <div class="col col-md-2">--%>
                                <%--    <label for="text-input" class=" form-control-label">Makra %</label>--%>
                                <%--    </div>--%>
                                <%--    <div class="col-12 col-md-3">--%>
                                <%--    <input type="text" id="text-input" name="text-input" placeholder="Text"--%>
                                <%--    class="form-control">--%>
                                <%--    <small class="form-text text-muted">Białka %</small>--%>
                                <%--    </div>--%>
                                <%--    <div class="col col-md-0">--%>
                                <%--    <label for="text-input" class=" form-control-label"></label>--%>
                                <%--    </div>--%>
                                <%--    <div class="col-12 col-md-3">--%>
                                <%--    <input type="text" id="text-input" name="text-input" placeholder="Text"--%>
                                <%--    class="form-control">--%>
                                <%--    <small class="form-text text-muted">Węglowodany %</small>--%>
                                <%--    </div>--%>
                                <%--    <div class="col col-md-0">--%>
                                <%--    <label for="text-input" class=" form-control-label"></label>--%>
                                <%--    </div>--%>
                                <%--    <div class="col-12 col-md-3">--%>
                                <%--    <input type="text" id="text-input" name="text-input" placeholder="Text"--%>
                                <%--    class="form-control">--%>
                                <%--    <small class="form-text text-muted">Tłuszcze %</small>--%>
                                <%--    </div>--%>
                                <%--    </div>--%>
                                <%--    <div class="row form-group"></div>--%>

                            <div class="row form-group">
                                <div class="col col-md-2">
                                    <form:label path="name">Nazwa planu</form:label>
                                </div>
                                <div class="col-12 col-md-5">
                                    <form:input path="name" class="form-control" placeholder="nazwa"/>
                                    <form:errors path="name" cssClass="error" element="div"/>
                                    <small class="form-text text-muted"></small>
                                </div>
                            </div>

                            <div class="card-footer">
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> Zapisz
                                </button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../footer.jsp"/>