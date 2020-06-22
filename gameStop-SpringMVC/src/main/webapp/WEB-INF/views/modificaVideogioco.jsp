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
                    <h2>Inserisci i campi da modificare</h2>
		<form:form action="creaVideogioco" method="post" modelAttribute="videogioco">
			<table>
			<tr>
					<td>ID: </td>
					<td>${videogioco.id}
						<form:hidden path="id"/>
					</td>
				</tr>		
				<tr>
					<td>Titolo: </td>
					<td><form:input path="titolo" /></td>
				</tr>
				<tr>
					<td>Prezzo: </td>
					<td><form:input path="prezzo" /></td>
				</tr>
				<tr>			
				
				<td>Classificazione Pegi: </td>
<td><form:select path="pegi" >
  <option value="PEGI_3">PEGI_3</option>
  <option value="PEGI_7">PEGI_7</option>
  <option value="PEGI_12">PEGI_12</option>
  <option value="PEGI_16">PEGI_16</option>
   <option value="PEGI_18">PEGI_18</option>
  

</form:select></td>	
				</tr>			
				<tr>
					<td>Categoria: </td>
					<td><form:select path="categoria">
   <option value="Azione">Azione</option>
  <option value="Avventura">Avventura</option>
  <option value="Horror">Horror</option>
  <option value="Simulzione">Simulazione</option>
  
</form:select></td>
				</tr>			
				<tr>
					<td><input type="submit" value="Modifica"></td>
				</tr>						
			</table>
		</form:form>

</body>
</html>