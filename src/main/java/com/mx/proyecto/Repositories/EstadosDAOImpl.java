package com.mx.proyecto.Repositories;
	
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.mx.proyecto.Entities.Estados;

	//CONSULTAS A BASE DE DATOS
	//IMPLEMENTACIÓN DEL REPOSITORIO

	
	@Repository
	public class EstadosDAOImpl implements EstadosDAO{
		@Autowired
		private SessionFactory sessionFactory;  //PARA LA CONEXIÓN A LA BASE DE DATOS
		public EstadosDAOImpl() { // constructor vacio
     }
		public EstadosDAOImpl(SessionFactory sessionFactory) { //constructor con parametros
	this.sessionFactory=sessionFactory;
	}
		
		
		//consulta con hibernate
	@SuppressWarnings("unchecked")	//Quitar las advertencias(son las lineas amarillas)
	@Override
	@Transactional() //Es lo equivalente a un commit en oracle (confirmar los cambios)
	//recomendable usar en insert, delete y update
	public List<Estados>obtieneUsuario(){
		final Session session =sessionFactory.getCurrentSession();
		final Criteria criteria=session.createCriteria(Estados.class); //SELECT+FROM ESQUEMA.TABLA
		
		return (List<Estados>)criteria.list();
	}
	
	
	@Override
	@Transactional()
	public Integer insertaUsuario(Estados datoAInsertar) {
		sessionFactory.getCurrentSession().save(datoAInsertar); //Es para guardar informacion a la tabla
		// save =guardar 
	//Es si no existe el reg de la tabla 	
		return 1;
	}
	
	
	@Override
	@Transactional()
	public Integer eliminarRegistro (Long idEstado) {
		Estados ideEntity=new Estados();
		ideEntity.setIdEstado(idEstado);
		
		sessionFactory.getCurrentSession().delete(ideEntity);
		return 1;
	}
	
	
	@Override
	@Transactional()
	public Integer actualizaUsuario(Estados datos) {
		
		sessionFactory.getCurrentSession().update(datos);
		return 1;
	}
}
		
