<%@ include file="../../StartPage.jsp" %>
        <div class="page-heading">
            <div class="page-title">
                <div class="row">
                    <div class="col-12 col-md-6 order-md-1 order-last">
                        <h3>Modifier un Fournisseur</h3>
                        <p class="text-subtitle text-muted">Utiliser cet Formulaire pour Modifier un Fournisseur</p>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Fournisseurs</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Modifier un Fournisseur
                                </li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- // Basic multiple Column Form section start -->
            <section id="multiple-column-form">
                <div class="row match-height">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Modifier Fournisseur</h4>
                            </div>
                            <div class="card-content">
                                <div class="card-body">
                                    <form class="form" method="post" action="${pageContext.request.contextPath}/update-fournisseur?id=${supplierDetail.id}">
                                        @csrf
                                        <div class="row">
                                            <div class="col-md-12 col-12">
                                                <div class="form-group">
                                                    <label>Nom :</label>
                                                    <input type="text" class="form-control"
                                                           name="name" value="${supplierDetail.name}">
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-12">
                                                <div class="form-group">
                                                    <label>Numero de Telephone :</label>
                                                    <input type="text" class="form-control"
                                                           name="tel" value="${supplierDetail.tel}">
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-12">
                                                <div class="form-group">
                                                    <label class="form-label">Email :</label>
                                                    <input class="form-control" name="email"
                                                              value="${supplierDetail.email}">
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-12">
                                                <div class="form-group">
                                                    <label>Adresse :</label>
                                                    <input type="text" class="form-control"
                                                           name="address" value="${supplierDetail.address}">
                                                </div>
                                            </div>
                                            <div class="col-12 d-flex justify-content-start mt-3">
                                                <button type="submit"
                                                        class="btn btn-success me-3 mb-3">Mettre a Jour</button>
                                                <button type="reset"
                                                        class="btn btn-light-danger me-1 mb-3">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- // Basic multiple Column Form section end -->
        </div>
<%@ include file="../../EndPage.jsp" %>

