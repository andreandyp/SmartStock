package mx.ipn.escom.controlacceso.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



import mx.ipn.escom.controlacceso.mapeo.Usuario;

@Service("usuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String EXISTE_LOGIN = "select * from Usuario where login=?";

	public UsuarioDao() {
		super();
	}


	@SuppressWarnings("rawtypes")
	public Usuario obtenerUsuario(String login) {
		Session session = sessionFactory.getCurrentSession();  
		Query query=session.createQuery(EXISTE_LOGIN);
		query.setParameter("nbLogin", login);
		Usuario usuario = (Usuario) query.getSingleResult();
		return (usuario != null) ? usuario : new Usuario();
	}

	
	
	public Usuario buscarUsuario(String login) throws Exception {
		Usuario usuario=new Usuario();
		DataBase dataBase=new DataBase();
		Connection con=dataBase.getConnection();
		PreparedStatement preparedStatement= con.prepareStatement(EXISTE_LOGIN);
		preparedStatement.setString(1, login);
		
		 ResultSet rs = preparedStatement.executeQuery();

	        Statement stmts = (Statement) con.createStatement();

	        while(rs.next()) {
	        	String logins=rs.getString("login");
	        	String password=rs.getString("password");
	        	usuario= new Usuario(null,null, null,null, null, logins, password);
	        }
		return usuario;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
}
