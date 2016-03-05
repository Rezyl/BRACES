<article>
	<h1>Zájezdy</h1>

	<ol class="breadcrumb">
		<li><a href="#">Domů</a></li>
		<li class="active">Zájezdy</li>
	</ol>

	<div class="btn-toolbar" role="toolbar" aria-label="Nástroje">
		<div class="btn-group" role="group">
			<a href="#" class="btn btn-default btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Přidat zájezd</a>
		</div>
	</div>

	<table class="table table-striped">
		<thead>
			<tr><th>ID</th><th>Cílová země</th><th>Typ dopravy</th><th>Kategorie</th><th>Stravování</th><th>Ubytování</th><th>Délka zájezdu</th><th>Termín</th><th>Cena</th><th></th><th></th></tr>
		</thead>
		<tbody>
			<%--<c:forEach items="${tours}" var="tour">--%>
				<%--<tr>--%>
					<%--<td><c:out value="${tour.id}"/></td>--%>
					<%--<td><c:out value="${tour.country}"/></td>--%>
					<%--<td><c:out value="${tour.transportType}"/></td>--%>
					<%--<td><c:out value="${tour.category}"/></td>--%>
					<%--<td><c:out value="${tour.catering}"/></td>--%>
					<%--<td><c:out value="${tour.accommodation}"/></td>--%>
					<%--<td><c:out value="${tour.tourLength}"/></td>--%>
					<%--<td><c:out value="${tour.date}"/></td>--%>
					<%--<td><c:out value="${tour.price}"/> Kč</td>--%>
					<%--<td><a href="#" class="btn btn-default btn-primary"><span class="glyphicon glyphicon glyphicon-eye-open" aria-hidden="true"></span> Zobrazit</a></td>--%>
					<%--<td><a href="#" class="btn btn-default"><span class="glyphicon glyphicon glyphicon-pencil" aria-hidden="true"></span> Upravit</a></td>--%>
					<%--<td><a href="#" class="btn btn-default btn-danger"><span class="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span> Odstranit</a></td>--%>
				<%--</tr>--%>
			<%--</c:forEach>--%>
		</tbody>
	</table>
	
	<nav>
		<ul class="pagination">
			<li>
				<a href="#" aria-label="Předchozí">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li>
				<a href="#" aria-label="Další">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</ul>
	</nav>
</article>