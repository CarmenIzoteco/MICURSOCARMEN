package com.mx.proyecto.Repositories;

    import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.mx.proyecto.Entities.UsuariosAdmin;


	//CONSULTAS A BASE DE DATOS
	//IMPLEMENTACIÓN DEL REPOSITORIO

	@Repository
	public class UsuariosAdminDAOImpl implements UsuariosAdminDAO{
		
		@Autowired
		private SessionFactory sessionFactory;  //PARA LA CONEXIÓN A LA BASE DE DATOS
		
		public UsuariosAdminDAOImpl() { // constructor vacio

		}
		public UsuariosAdminDAOImpl(SessionFactory sessionFactory) { //constructor con parametros
	this.sessionFactory=sessionFactory;
	}
		
		//consulta con hibernate
	@SuppressWarnings("unchecked")	//Quitar las advertencias(son las lineas amarillas)
	@Override
	@Transactional() //Es lo equivalente a un commit en oracle (confirmar los cambios)
	//recomendable usar en insert, delete y update
	public List<UsuariosAdmin>obtieneUsuarios(){
		final Session session =sessionFactory.getCurrentSession();
		final Criteria criteria=session.createCriteria(UsuariosAdmin.class); //SELECT+FROM ESQUEMA.TABLA
		
		return (List<UsuariosAdmin>)criteria.list();
	}
	
	@Override
	@Transactional()
	public Integer insertarUsuario(UsuariosAdmin datosAInsertar) {
		sessionFactory.getCurrentSession().save(datosAInsertar); //Es para guardar informacion a la tabla
		// save =guardar 
	//Es si no existe el reg de la tabla 	
		return 1;
	}
	@Override
	@Transactional()
	public Integer eliminaRegistro (Long idUser) {
		
		UsuariosAdmin ideEntity=new UsuariosAdmin();
		ideEntity.setIdUser(idUser);
		
		sessionFactory.getCurrentSession().delete(ideEntity);
		return 1;
	}
	@Override
	@Transactional()
	public Integer actualizarUsuario(UsuariosAdmin datos) {
		
		sessionFactory.getCurrentSession().update(datos);
		return 1;
	}
}
		