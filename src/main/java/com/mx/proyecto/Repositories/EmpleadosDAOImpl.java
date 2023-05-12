package com.mx.proyecto.Repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.proyecto.Entities.Empleados;

@Repository
public class EmpleadosDAOImpl extends GenericDAO<Empleados, Long> implements EmpleadosDAO{
	
	
	
	@Override
	@Transactional
	public Empleados buscarPorCurp(String curp) { 
	System.out.println("IMPL ->"+ curp);

	final Session session = sessionFactory.getCurrentSession();
	final Criteria criteria = session.createCriteria(Empleados.class);// -> select * from EMPLEADOS
	
	criteria.add(Restrictions.eq("curp",curp));// -> WHERE curp = 'CURP' eq es para hacer una consulta
	System.out.println(" FIN-IMPL ->"+criteria);
	return (Empleados) criteria.uniqueResult();
}
}
