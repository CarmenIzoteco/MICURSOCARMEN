package com.mx.proyecto.Repositories;

import com.mx.proyecto.Entities.Empleados;

public interface EmpleadosDAO extends DAO<Empleados, Long>{

Empleados buscarPorCurp(String curp);

}
