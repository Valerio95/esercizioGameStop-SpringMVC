<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
                <br> <br>Aggiungi un nuovo videogioco o gestisci quelli esistenti<br> <br>
	<form:form action="creaVideogioco" method="post" modelAttribute="videogioco">
			<table>
				
				<tr>
					<td>Titolo: </td>
					<td><form:input path="titolo" /></td>
				</tr>
				<tr>
					<td>Classificazione Pegi: </td>
<td><form:select path="pegi" >
  <option value="PEGI_3">PEGI_3</option>
  <option value="PEGI_7">PEGI_7</option>
  <option value="PEGI_12">PEGI_12</option>
  <option value="PEGI_16">PEGI_16</option>
   <option value="PEGI_18">PEGI_18</option>
  

</form:select></td>				</tr>
				<tr>
					<td>Categoria: </td>
					<td><form:select path="categoria" >
  <option value="Azione">Azione</option>
  <option value="Avventura">Avventura</option>
  <option value="Horror">Horror</option>
  <option value="Simulzione">Simulazione</option>
  

</form:select></td>
				</tr>
				<tr>
					<td>Prezzo: </td>
					<td><form:input path="prezzo" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Aggiungi"></td>
				</tr>						
			</table>
		</form:form>
		<br> <br>Scegli una ricerca<br> <br>
	<form action="ricercaVideogioco" method="post">
	<br> <br>Inserisci il titolo da cercare<br> <br>
	<input type="text" name="titolo" placeholder="Titolo">
	
		<br> <br>Scegli una categoria da cercare<br> <br>
	<select name="categoria" >
	  <option value=" ">\</option>
  <option value="Azione">Azione</option>
  <option value="Avventura">Avventura</option>
  <option value="Horror">Horror</option>
  <option value="Simulzione">Simulazione</option>
</select>

<br> <br>Scegli una Classificazione da cercare<br> <br>
	<select name="pegi" >
	  <option value=" ">\</option>
  <option value="PEGI_3">PEGI_3</option>
  <option value="PEGI_7">PEGI_7</option>
  <option value="PEGI_12">PEGI_12</option>
  <option value="PEGI_16">PEGI_16</option>
   <option value="PEGI_18">PEGI_18</option>
</select>

<input type="submit" value="Cerca">
	</form>
		<form action="ordinaVideogioco" method="post">
	
	<br> <br>Scegli un ordinamento<br> <br>
<select name="ordinamento" >
  <option value="OrdPrezzo">ordina per prezzo</option>
  <option value="OrdPegi">ordina per pegi</option>
  <option value="OrdTitolo">ordina per titolo</option>
  <option value="OrdCateg">ordina per Categoria</option>
</select>
<input type="hidden" name="listaVideo" value="${listaVideogiochi}">

<input type="submit" value="Ordina">

		</form>
	
	<table >
		<tr>
			<th>ID</th>
			<th>Titolo</th>
			<th>Pegi</th>
			<th>Categoria</th>
			<th>Prezzo</th>
		</tr>
		<c:forEach items="${listaVideogiochi}" var="videogioco">
		<tr>
			<td>${videogioco.id}</td>
			<td>${videogioco.titolo}</td>
			<td>${videogioco.pegi}</td>
			<td>${videogioco.categoria}</td>
			<td>${videogioco.prezzo}</td>
			
			<td>
				<a href="modificaVideogioco?id=${videogioco.id}">Modifica</a>
				&nbsp;&nbsp;&nbsp;
				<a href="eliminaVideogioco?id=${videogioco.id}">Elimina</a>
				
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>