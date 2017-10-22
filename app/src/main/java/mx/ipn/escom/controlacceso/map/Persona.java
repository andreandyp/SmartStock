package mx.ipn.escom.controlacceso.map;

import java.util.Date;

/**
 * Created by gambo on 09/10/2017.
 */

public class Persona {

    /**
     * nombre de la persona
     */
    private String nombre;

    /**
     * pimer apellido de la persona
     */
    private String primerApellido;

    /**
     * segundo apellido de la persona
     */
    private String segundoApellido;

    /**
     * fecha de naciminto de la persona
     */
    private Date nacimiento;

    /**
     * constructor sin parametros
     */
    public Persona() {
        super();
    }

    /**
     * Constructor con todos los parametros
     *
     * @param nombre
     * @param primerApellido
     * @param segundoApellido
     * @param nacimiento
     */
    public Persona(String nombre, String primerApellido, String segundoApellido, Date nacimiento) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
}
