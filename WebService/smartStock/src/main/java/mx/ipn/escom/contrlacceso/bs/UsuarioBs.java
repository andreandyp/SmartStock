package mx.ipn.escom.contrlacceso.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.controlacceso.dao.UsuarioDao;
import mx.ipn.escom.controlacceso.mapeo.Usuario;

@Service("usuarioBs")
@Scope(value=BeanDefinition.SCOPE_SINGLETON)
public class UsuarioBs {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	public UsuarioBs() {
		super();
	}

	public Usuario obtenerUsuario(String login, String password) throws Exception {
		System.err.println("login "+login+" pass: "+password);
		usuarioDao=new UsuarioDao();
		Usuario usuario= usuarioDao.buscarUsuario(login);
		
		return usuario.getPassword().equals(password)?usuario:null;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
