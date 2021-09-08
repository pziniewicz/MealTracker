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
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <strong>Nowy</strong> Plan
                        </div>
                        <div class="card-body card-block">
                            <form action="" method="post" enctype="multipart/form-data" class="form-horizontal">
                                <div class="row form-group">
                                    <div class="col col-md-2">
                                        <label class=" form-control-label">Użytkownik</label>
                                    </div>
                                    <div class="col-12 col-md-10">
                                        <p class="form-control-static">Username</p>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-2">
                                        <label for="text-input" class=" form-control-label">Wzrost</label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <input type="text" id="text-input" name="text-input" placeholder="Text"
                                               class="form-control">
                                        <small class="form-text text-muted">cm</small>
                                    </div>
                                    <div class="col col-md-2">
                                        <label for="text-input" class=" form-control-label">Waga</label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <input type="text" id="text-input" name="text-input" placeholder="Text"
                                               class="form-control">
                                        <small class="form-text text-muted">kg</small>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="select" class=" form-control-label">Aktywność
                                            fizyczna</label>
                                    </div>
                                    <div class="col-12 col-md-7">
                                        <select name="select" id="select" class="form-control">
                                            <option value="0">Please select</option>
                                            <option value="1">Option #1</option>
                                            <option value="2">Option #2</option>
                                            <option value="3">Option #3</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="select" class=" form-control-label">Aktywność
                                            treningowa</label>
                                    </div>
                                    <div class="col-12 col-md-7">
                                        <select name="select" id="select" class="form-control">
                                            <option value="0">Please select</option>
                                            <option value="1">Option #1</option>
                                            <option value="2">Option #2</option>
                                            <option value="3">Option #3</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="text-input" class=" form-control-label">Zapotrzebowanie
                                            kaloryczne </label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <input type="text" id="text-input" name="text-input" placeholder="Text"
                                               class="form-control">
                                        <small class="form-text text-muted">kCal</small>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-2">
                                        <label for="text-input" class=" form-control-label">Makra %</label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <input type="text" id="text-input" name="text-input" placeholder="Text"
                                               class="form-control">
                                        <small class="form-text text-muted">Białka %</small>
                                    </div>
                                    <div class="col col-md-0">
                                        <label for="text-input" class=" form-control-label"></label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <input type="text" id="text-input" name="text-input" placeholder="Text"
                                               class="form-control">
                                        <small class="form-text text-muted">Węglowodany %</small>
                                    </div>
                                    <div class="col col-md-0">
                                        <label for="text-input" class=" form-control-label"></label>
                                    </div>
                                    <div class="col-12 col-md-3">
                                        <input type="text" id="text-input" name="text-input" placeholder="Text"
                                               class="form-control">
                                        <small class="form-text text-muted">Tłuszcze %</small>
                                    </div>
                                </div>
                                <div class="row form-group"></div>


                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label class=" form-control-label">Wybierz posiłki</label>
                                    </div>
                                    <div class="col col-md-9">
                                        <div class="form-check">
                                            <div class="checkbox">
                                                <label for="checkbox1" class="form-check-label ">
                                                    <input type="checkbox" id="checkbox1" name="checkbox1"
                                                           value="option1" class="form-check-input">Śniadanie
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label for="checkbox2" class="form-check-label ">
                                                    <input type="checkbox" id="checkbox2" name="checkbox2"
                                                           value="option2" class="form-check-input"> II śniadanie
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label for="checkbox3" class="form-check-label ">
                                                    <input type="checkbox" id="checkbox3" name="checkbox3"
                                                           value="option3" class="form-check-input"> Lunch
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label for="checkbox3" class="form-check-label ">
                                                    <input type="checkbox" id="checkbox3" name="checkbox3"
                                                           value="option3" class="form-check-input"> Obiad
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label for="checkbox3" class="form-check-label ">
                                                    <input type="checkbox" id="checkbox3" name="checkbox3"
                                                           value="option3" class="form-check-input"> Przekąska
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label for="checkbox3" class="form-check-label ">
                                                    <input type="checkbox" id="checkbox3" name="checkbox3"
                                                           value="option3" class="form-check-input"> Kolacja
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col col-md-2">
                                        <label for="text-input" class=" form-control-label">Nazwa planu</label>
                                    </div>
                                    <div class="col-12 col-md-5">
                                        <input type="text" id="text-input" name="text-input" placeholder="Text"
                                               class="form-control">
                                        <small class="form-text text-muted"></small>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary btn-sm">
                                <i class="fa fa-dot-circle-o"></i> Zapisz
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>

<jsp:include page="footer.jsp"/>