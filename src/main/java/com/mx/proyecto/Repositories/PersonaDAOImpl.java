package com.mx.proyecto.Repositories;

import org.springframework.stereotype.Repository;

import com.mx.proyecto.Entities.Persona;

@Repository
public class PersonaDAOImpl extends GenericDAO<Persona, Long> implements PersonaDAO{

}
