package mx.ipn.escom.controlacceso.service;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.ipn.escom.contrlacceso.bs.UsuarioBs;
import mx.ipn.escom.controlacceso.dao.UsuarioDao;
import mx.ipn.escom.controlacceso.mapeo.Usuario;

@Provider
@Path("/controlacceso")
public class UsuarioService {

	@Autowired
	private UsuarioBs usuarioBs;

	/**
	 * Metodo Utilizado para obtener un usuario apartir de un nombre(login) dado.
	 * 
	 * @param login
	 * @return
	 */
	@GET
	@Path("/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerUsuarioPorLogin(@PathParam("login") String login,@PathParam("password") String password) {
		System.err.println(login);
		Usuario usuario=new Usuario();
		usuarioBs=new UsuarioBs();
		try {
			usuario=usuarioBs.obtenerUsuario(login,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(usuario).build();
	}

	public UsuarioBs getUsuarioBs() {
		return usuarioBs;
	}

	public void setUsuarioBs(UsuarioBs usuarioBs) {
		this.usuarioBs = usuarioBs;
	}
	
}
