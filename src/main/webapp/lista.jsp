<%@ taglib uri="https://jakarta.ee/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Lista de profesores</title>
  <link rel="stylesheet" type="text/css" href="css/table.css"/>
  <script type="text/javascript" charset="utf-8">



    function modificar ()
    {
      const upd = document.getElementsByName("rad_upd");
      let id = "";
      for (i = 0; i < upd.length; i++) {
        if (upd[i].checked)
        {
          id = upd[i].value;
          break;
        }
      }
      if (id.length > 0  )
        window.location = "profesor?a=R&id=" + id;
    }




  </script>
</head>
<body>
<table class="navy">
  <caption>Lista de Profesores</caption>
  <thead>
  <tr>
    <th>Id</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
    <th>Nombres</th>
    <th>F. Nacimiento</th>
    <th>Direccion</th>
    <th>Referencia</th>
    <th>Genero</th>
    <th>Estado</th>
    <th><a href="profesorINS.jsp"><img src="images/ins.png" /></a></th>
    <th><img src="images/del.png" /></th>
    <th><a href="javascript:modificar()"><img src="images/upd.png" /></a></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="p" items="${profesores}">
    <tr>
      <td>${p.getIdprofesor()} </td>
      <td>${p.getAppaterno()} </td>
      <td>${p.getApmaterno()} </td>
      <td>${p.getNombres()} </td>
      <td>${p.getNacimiento()} </td>
      <td>${p.getDireccion()} </td>
      <td>${p.getReferencia()} </td>
      <td>${p.getGenero()} </td>
      <td colspan="2">${p.getEstado()} </td>
      <td><input type="checkbox" name="chk_del" value="${p.getIdprofesor()}"/></td>
      <td><input type="radio" name="rad_upd" value="${p.getIdprofesor()}"/></td>
    </tr>
  </c:forEach>
  </tbody>
  <tfoot>
  <tr><td colspan="12">
    Listado de profesores de turno mañana</td>
  </tr>

  </tfoot>
</table>


</body>
</html>

</body>
</html>
