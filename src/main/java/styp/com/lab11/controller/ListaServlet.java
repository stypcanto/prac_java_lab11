package styp.com.lab11.controller;

import styp.com.lab11.dto.ProfesorDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "listaServlet", value = "/lista")
public class ListaServlet extends HttpServlet
{

    private List<ProfesorDTO> profesores;

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://db:3306/asistencia?serverTimezone=UTC",
                    "root",
                    "mysql");

            String sql = "select idprofesor, " +
                    "appaterno, " +
                    "apmaterno, " +
                    "nombres, " +
                    "nacimiento, " +
                    "direccion, " +
                    "referencia, " +
                    "IF(genero LIKE 'M', 'Masculino', 'Femenino') AS genero, " +
                    "IF(estado LIKE '1', 'Activo', 'Inactivo') AS estado " +
                    "from profesor " +
                    "ORDER BY appaterno, apmaterno, nombres";

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            profesores = new LinkedList<>();

            // recorrer el resultado mientras existan registros
            while (rs.next())
            {
                ProfesorDTO profesor = new ProfesorDTO(rs.getInt("idprofesor"),
                        rs.getString("appaterno"),
                        rs.getString("apmaterno"),
                        rs.getString("nombres"),
                        rs.getDate("nacimiento"),
                        rs.getString("direccion"),
                        rs.getString("referencia"),
                        rs.getString("genero"),
                        rs.getString("estado")
                );
                profesores.add(profesor);
            }

            conexion.close();
            request.setAttribute("profesores", profesores);
            request.getRequestDispatcher("lista.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            throw new ServletException(e);
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try
        {
            processRequest(request, response);
        }
        catch (ServletException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try
        {
            processRequest(request, response);
        }
        catch (ServletException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void destroy()
    {
    }
}