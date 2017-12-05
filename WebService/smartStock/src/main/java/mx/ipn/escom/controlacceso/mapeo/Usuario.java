package mx.ipn.escom.controlacceso.mapeo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idPersona")
public class Usuario extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Varable utilizada para identificar el nombre del usuario.
	 */
	@Column(name="login")
	private String login;

	/**
	 * Variable utilizada para identificar el password del usuario
	 */
	@Column(name="password")
	private String password;

	
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String primerApellido, String segundoApellido, Date nacimiento) {
		super(nombre, primerApellido, segundoApellido, nacimiento);
	}

	public Usuario(String nombre, String primerApellido, String segundoApellido, Date nacimiento, Integer id,
			String login, String password) {
		super(nombre, primerApellido, segundoApellido, nacimiento);
		this.login = login;
		this.password = password;
	}

	/**
	 * Setters and Getters
	 */

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
