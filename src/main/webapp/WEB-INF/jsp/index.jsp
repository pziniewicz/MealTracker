<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>
<jsp:include page="menu_right.jsp"/>

<jsp:include page="topsection.jsp"/>


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
                <div class="col-xl-8">
                    <!-- RECENT REPORT 2-->
                    <div class="recent-report2">
                        <h3 class="title-3">recent reports</h3>
                        <div class="chart-info">
                            <div class="chart-info__left">
                                <div class="chart-note">
                                    <span class="dot dot--blue"></span>
                                    <span>products</span>
                                </div>
                                <div class="chart-note">
                                    <span class="dot dot--green"></span>
                                    <span>Services</span>
                                </div>
                            </div>
                            <div class="chart-info-right">
                                <div class="rs-select2--dark rs-select2--md m-r-10">
                                    <select class="js-select2" name="property">
                                        <option selected="selected">All Properties</option>
                                        <option value="">Products</option>
                                        <option value="">Services</option>
                                    </select>
                                    <div class="dropDownSelect2"></div>
                                </div>
                                <div class="rs-select2--dark rs-select2--sm">
                                    <select class="js-select2 au-select-dark" name="time">
                                        <option selected="selected">All Time</option>
                                        <option value="">By Month</option>
                                        <option value="">By Day</option>
                                    </select>
                                    <div class="dropDownSelect2"></div>
                                </div>
                            </div>
                        </div>
                        <div class="recent-report__chart">
                            <canvas id="recent-rep2-chart"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>

<jsp:include page="footer.jsp"/>