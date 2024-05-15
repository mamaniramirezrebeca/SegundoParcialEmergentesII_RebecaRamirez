
package com.emergentes.dao;

import com.emergente.modelo.Estudiante;
import java.util.List;


public interface EstudiantesDAO {
    public void insert (Estudiante usuario)throws Exception;
     public void update (Estudiante usuario)throws Exception;
     public void delete (int id)throws Exception;
     public List<Estudiante> getAll() throws Exception;
     public Estudiante getById(int id) throws Exception;
}
