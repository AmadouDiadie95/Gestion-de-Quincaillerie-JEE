<%@ include file="../../StartPage.jsp" %>


        <div class="page-heading">
            <div class="page-title">
                <div class="row">
                    <div class="col-12 col-md-6 order-md-1 order-last">
                        <h3>Liste des Articles</h3>
                        <p class="text-subtitle text-muted">liste de toutes les Articles d'Articles</p>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Articles</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Liste des Articles</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <section class="section">
                <div class="card">
                    <div class="card-header">
                        Datatable
                    </div>
                    <div class="card-body">
                        <table class="table table-striped" id="table1">
                            <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Description</th>
                                <th>Categorie</th>
                                <th>Prix</th>
                                <th>Quantit� en Stock</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${allArticles}" var="article">
								<tr>
                                        <td> <a href="detail-article?id=${article.id}" > ${article.name} </a> </td>
                                        <td>${article.description}</td>
                                        <td>${article.category_name}</td>
                                        <td>${article.price} Fcfa</td>
                                        <td>${article.quantity}</td>
                                    </tr>
							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </section>
        </div>


<%@ include file="../../EndPage.jsp" %>

