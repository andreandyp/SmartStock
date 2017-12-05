package mx.ipn.escom.controlacceso.mapeo;

import java.util.Date;

import javax.management.MXBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "persona")
@XmlRootElement  
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	/**
	 * id de la persona
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersona")
    private Integer id;

    /**
     * nombre de la persona
     */
	@Column(name="nombre")
    private String nombre;

    /**
     * pimer apellido de la persona
     */
	@Column(name="primer_ap")
    private String primerApellido;

    /**
     * segundo apellido de la persona
     */
	@Column(name="segundo_ap")
    private String segundoApellido;

    /**
     * fecha de naciminto de la persona
     */
	@Column(name="nacimiento")
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
