package styp.com.lab10.controller;

import styp.com.lab10.dto.ProfesorDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

@WebServlet(name = "ProfesorServlet", value = "/profesor")
public class ProfesorServlet extends HttpServlet
{

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String pagina = "lista";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asistencia?serverTimezone=UTC",
                    "root",
                    "mysql");

            PreparedStatement statement = null;
            String accion = request.getParameter("a");
            // request.getParameter son los datos que vienen del formulario
            if (accion != null & accion.toString().equals("I"))
            {
                pagina = inserta(conexion, request, response);
            }
            else if (accion != null & accion.toString().equals("U"))
            {
                pagina = actualiza(conexion, request, response);
            }
            else if (accion != null & accion.toString().equals("R"))
            {
                pagina = lee(conexion, request, response);
            }
            conexion.close();

            request.getRequestDispatcher(pagina).forward(request, response);
        }
        catch (Exception e)
        {
            throw new ServletException(e);
        }
    }

    /**
     * Insertar el registro que viene desde el formulario
     * @param conexion
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws ParseException
     */

    private String inserta(Connection conexion, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ParseException
    {
        PreparedStatement statement = null;
        String            sqlCMD;
        // request.getParameter son los datos que vienen del formulario
        sqlCMD = new StringBuilder(" INSERT INTO profesor ( ")
                .append(" appaterno, apmaterno, nombres, nacimiento, ")
                .append(" direccion, referencia, genero, estado )")
                .append("values ( ?,?,?,?,?,?,?,? )").toString();

        statement = conexion.prepareStatement(sqlCMD);
        statement.setString(1, request.getParameter("appaterno"));
        statement.setString(2, request.getParameter("apmaterno"));
        statement.setString(3, request.getParameter("nombres"));

        // transformacion de fecha
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date    date = new java.sql.Date(sdf.parse(request.getParameter("nacimiento")).getTime());

        statement.setDate(4, date);
        statement.setString(5, request.getParameter("direccion"));
        statement.setString(6, request.getParameter("referencia"));
        statement.setString(7, request.getParameter("genero"));
        statement.setString(8, request.getParameter("estado"));

        int value = statement.executeUpdate();

        return (value > 0 ? "lista" : "profesorINS.jsp");
    }

    /**
     * Actualizar el registro que viene desde el ID
     * @param conexion
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws SQLException
     */
    private String actualiza(Connection conexion, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ParseException
    {
        PreparedStatement statement = null;
        String            sqlCMD;
        String            id        = request.getParameter("id");
        sqlCMD = new StringBuilder(" UPDATE profesor SET ")
                .append(" appaterno = ?, apmaterno = ?, nombres =?, nacimiento = ?, ")
                .append(" direccion = ?, referencia = ?, genero = ?, estado = ? WHERE idprofesor = ?").toString();

        statement = conexion.prepareStatement(sqlCMD);
        statement.setString(1, request.getParameter("appaterno"));
        statement.setString(2, request.getParameter("apmaterno"));
        statement.setString(3, request.getParameter("nombres"));

        // transformacion de fecha
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date    date = new java.sql.Date(sdf.parse(request.getParameter("nacimiento")).getTime());

        statement.setDate(4, date);
        statement.setString(5, request.getParameter("direccion"));
        statement.setString(6, request.getParameter("referencia"));
        statement.setString(7, request.getParameter("genero"));
        statement.setString(8, request.getParameter("estado"));
        statement.setString(9, id);
        int value = statement.executeUpdate();

        return (value > 0 ? "lista" : "profesorINS.jsp");
    }

    /**
     * Leer el registro que viene desde el ID
     * @param conexion
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public String lee(Connection conexion, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {

        String sqlCMD = "SELECT idprofesor, " +
                "appaterno, " +
                "apmaterno, " +
                "nombres, " +
                "nacimiento, " +
                "direccion, " +
                "referencia, " +
                "genero, " +
                "estado " +
                "FROM profesor  WHERE idprofesor = ?" +
                "ORDER BY appaterno, apmaterno, nombres";

        PreparedStatement statement  = conexion.prepareStatement(sqlCMD);
        statement.setString(1, request.getParameter("id"));
        ResultSet rs = statement.executeQuery();

        // recorrer el resultado mientras existan registros
        ProfesorDTO profesor =  new ProfesorDTO();
        if (rs.next())
        {
            profesor = new ProfesorDTO(rs.getInt("idprofesor"),
                    rs.getString("appaterno"),
                    rs.getString("apmaterno"),
                    rs.getString("nombres"),
                    rs.getDate("nacimiento"),
                    rs.getString("direccion"),
                    rs.getString("referencia"),
                    rs.getString("genero"),
                    rs.getString("estado")
            );
        }

        request.setAttribute("profesor", profesor);
        return ( profesor.getIdprofesor() ==null ? "lista" : "profesorUPD.jsp");
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }

    public void destroy()
    {
    }
}