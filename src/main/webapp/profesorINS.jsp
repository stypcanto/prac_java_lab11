<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Formulario de Profesor</title>
  <link rel="stylesheet" type="text/css" href="css/table.css"/>
  <link rel="stylesheet" type="text/css" href="css/profesor.css"/>
</head>
<body>

<div id="container" style="width: 380px; margin:auto;">
  <form action="profesor" method="POST" class="navy">
    <input type="hidden" name="a" value="I"/>
    <fieldset>
      <legend>Formulario de Profesor</legend>
      <table>
        <tr>
          <td><label>Apellido Paterno:</label></td>
          <td><input type="text" name="appaterno" maxlength="50"/></td>
        </tr>
        <tr>
          <td>
            <label>Apellido Materno:</label></td>
          <td><input type="text" name="apmaterno" maxlength="50"/></td>
        </tr>
        <tr>
          <td>
            <label>Nombre:</label></td>
          <td><input type="text" name="nombres" maxlength="50"/></td>
        </tr>
        <tr>
          <td>
            <label>Fecha Nacimiento:</label></td>
          <td><input type="date" name="nacimiento"/></td>
        </tr>
        <tr>
          <td><label>Genero:</label></td>
          <td>
            <input class="myradio" type="radio" name="genero" value="X" checked="checked"/><label>No especificado</label>
            <input class="myradio" type="radio" name="genero" value="M"/><label>Masculino</label>
            <input class="myradio" type="radio" name="genero" value="F"/><label>Femenino</label>
          </td>
        </tr>
        <tr>
          <td><label>Direccion: </label></td>
          <td><textarea type="text" name="direccion" style="width: 170px; height: 40px"></textarea></td>
        </tr>
        <tr>
          <td><label>Referencia: </label></td>
          <td><textarea type="text" name="referencia" style="width: 170px; height: 40px"></textarea></td>
        </tr>
        <tr>
          <td><label>Estado:</label></td>
          <td>
            <input class="myradio" type="radio" name="estado" value="1"/><label>Activo </label>
            <input class="myradio" type="radio" name="estado" value="0"/><label>Inactivo </label>
          </td>
        </tr>
      </table>

      <div class="submit">
        <input type="submit" value="Enviar">
      </div>
    </fieldset>
  </form>

  <div style="text-align: center;">
    <a href="profesorINS.jsp">Cancelar</a>
  </div>

</div>

</body>
</html>
