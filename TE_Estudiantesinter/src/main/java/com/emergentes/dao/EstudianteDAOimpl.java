package com.emergentes.dao;

import com.emergente.modelo.Estudiante;
import com.emergentes.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimpl extends ConexionBD implements EstudiantesDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        String sql = "insert into estudiantes (nombre,apellido,seminario,confirmado,fecha) values(?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombre());
        ps.setString(2, estudiante.getApellido());
        ps.setString(3, estudiante.getSeminario());
        ps.setInt(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        String sql = "update estudiantes set nombre=?,apellido=?,seminario=?,confirmado=? ,fecha=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombre());
        ps.setString(2, estudiante.getApellido());
        ps.setString(3, estudiante.getSeminario());
        ps.setInt(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha());
        ps.setInt(6, estudiante.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from  estudiantes where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        String sql = "select *from estudiantes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Estudiante>();

        while (rs.next()) {
            Estudiante us = new Estudiante();

            us.setId(rs.getInt("id"));
            us.setNombre(rs.getString("nombre"));
            us.setApellido(rs.getString("apellido"));
            us.setSeminario(rs.getString("seminario"));
            us.setConfirmado(rs.getInt("confirmado"));
            us.setFecha(rs.getString("fecha"));

            lista.add(us);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        Estudiante us = new Estudiante();

        try {
            String sql = "select *from estudiantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setSeminario(rs.getString("seminario"));
                us.setConfirmado(rs.getInt("confirmado"));
                us.setFecha(rs.getString("fecha"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return us;
    }
}


