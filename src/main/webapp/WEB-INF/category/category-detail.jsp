<%@ include file="../../StartPage.jsp" %>
<div class="page-heading">
    <div class="page-title">
        <div class="row">
            <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>Detail d'une Categorie</h3>
                <p class="text-subtitle text-muted">Informations & Details</p>
            </div>
            <div class="col-12 col-md-6 order-md-2 order-first">
                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Categories</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Detail d'une Categorie
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
                        <h4 class="card-title">Detail d'une Categorie</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12 col-12">
                                    <div class="form-group">
                                        <label for="name-column">Nom : </label>
                                        <strong>${categoryDetail.name}</strong>
                                    </div>
                                </div>
                                <div class="col-md-12 col-12">
                                    <div class="form-group">
                                        <label class="form-label">Description : </label>
                                        <strong>${categoryDetail.description}</strong>
                                    </div>
                                </div>
                                <div class="col-md-12 col-12">
                                    <div class="form-group">
                                        <label class="form-label">Nombre d'Article : </label>
                                        <strong>${categoryDetail.number_of_article}</strong>
                                    </div>
                                </div>
                                <div class="col-12 d-flex justify-content-start">
                                    <a href="modifier-categorie?id=${categoryDetail.id}"
                                            class="btn btn-outline-primary me-3 mb-1">Modifier</a>
                                    <a href="supprimer-categorie?id=${categoryDetail.id}"
                                            class="btn btn-outline-danger me-1 mb-1">Supprimer</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- // Basic multiple Column Form section end -->
</div>
<%@ include file="../../EndPage.jsp" %>
