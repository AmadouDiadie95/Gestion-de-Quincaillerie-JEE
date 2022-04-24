<%@ include file="../../StartPage.jsp" %>
        <div class="page-heading">
            <div class="page-title">
                <div class="row">
                    <div class="col-12 col-md-6 order-md-1 order-last">
                        <h3>Ajouter une Categorie</h3>
                        <p class="text-subtitle text-muted">Utiliser cet Formulaire pour Ajouter une Nouvelle Catgeorie</p>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Categories</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Ajouter une Categorie
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
                                <h4 class="card-title">Nouvelle Categorie</h4>
                            </div>
                            <div class="card-content">
                                <div class="card-body">
                                    <form class="form" method="post" action="${pageContext.request.contextPath}/enregistrer-categorie">
                                    
                                        <div class="row">
                                            <div class="col-md-12 col-12">
                                                <div class="form-group">
                                                    <label for="name-column">Nom :</label>
                                                    <input type="text" id="name-column" class="form-control"
                                                           name="name">
                                                </div>
                                            </div>
                                            <div class="col-md-12 col-12">
                                                <div class="form-group">
                                                    <label for="exampleFormControlTextarea1" class="form-label">Description :</label>
                                                    <textarea class="form-control" id="exampleFormControlTextarea1" name="description"
                                                              rows="3"></textarea>
                                                </div>
                                            </div>
                                            <div class="col-12 d-flex justify-content-start">
                                                <button type="submit"
                                                        class="btn btn-success me-3 mb-1">Enregistrer</button>
                                                <button type="reset"
                                                        class="btn btn-light-secondary me-1 mb-1">Reset</button>
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

