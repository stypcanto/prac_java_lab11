package styp.com.lab11.dto;

import java.sql.Date;

public class ProfesorDTO
{
    private Integer idprofesor;
    private String  nombres;
    private String  appaterno;
    private String  apmaterno;
    private Date    nacimiento;
    private String  direccion;
    private String  referencia;
    private String  genero;
    private String  estado;

    public ProfesorDTO()
    {
    }

    public ProfesorDTO(Integer idprofesor,
                       String appaterno,
                       String apmaterno,
                       String nombres,
                       Date nacimiento,
                       String direccion,
                       String referencia,
                       String genero,
                       String estado)
    {
        this.idprofesor = idprofesor;
        this.nombres = nombres;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.referencia = referencia;
        this.genero = genero;
        this.estado = estado;
    }

    public String getApmaterno()
    {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno)
    {
        this.apmaterno = apmaterno;
    }

    public String getAppaterno()
    {
        return appaterno;
    }

    public void setAppaterno(String appaterno)
    {
        this.appaterno = appaterno;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public Integer getIdprofesor()
    {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor)
    {
        this.idprofesor = idprofesor;
    }

    public Date getNacimiento()
    {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento)
    {
        this.nacimiento = nacimiento;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getReferencia()
    {
        return referencia;
    }

    public void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }
}
