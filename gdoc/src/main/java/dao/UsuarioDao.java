/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import util.ConectaBD;
import util.Util;

/**
 *
 * @author Administrador
 */
public class UsuarioDao implements CRUD {

    Usuario usuario;
    ConectaBD conn = new ConectaBD();

    @Override
    public Long inserir(Object obj) {
        usuario = (Usuario) obj;
        ResultSet rs;
        try {

            Long id = 0L;
            if (usuario.getId() == null || usuario.getId() == 0) {
                String sql = "insert into usuario(nome,email,senha,isadm)values("
                        + "'" + usuario.getNome() + "',"
                        + "'" + usuario.getEmail() + "',"
                        + "md5('" + usuario.getSenha() + "'),"
                        + usuario.isIsAdm() + ") returning id";
                id = conn.inserirReturningId(sql);
                return id;

            }
        } catch (Exception e) {
            try {
                throw new Exception(e.getMessage());

            } catch (Exception ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        return null;
    }

    @Override
    public boolean excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> listar(Object filtro) {
        Usuario usuario = new Usuario();
        usuario = (Usuario) filtro;
        List<Usuario> retorno = new ArrayList<>();
        ResultSet rs;

        ConectaBD conn = new ConectaBD();

        String sql = "select * from usuario where 1>0";
        if (usuario.getNome() != null && !usuario.getNome().equals("")) {
            sql += " and nome like '" + usuario.getNome() + "%' ";
        }
        if (usuario.getEmail() != null && !usuario.getEmail().equals("")) {
            sql += " and email like '" + usuario.getEmail() + "%' ";
        }
        if (usuario.getId() != null && !usuario.getId().equals(0)) {
            sql += " and id = '" + usuario.getId() + "%' ";
        }
        try {
            rs = conn.getResultset(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setEmail(rs.getString("email"));
                u.setId(rs.getLong("id"));
                u.setIsAdm(rs.getBoolean("isAdm"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                retorno.add(u);
            }

            return retorno;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Object pesquisar(Object filtro) {
        Usuario usuario = new Usuario();
        usuario = (Usuario) filtro;
        List<Usuario> retorno = new ArrayList<>();
        ResultSet rs;

        ConectaBD conn = new ConectaBD();

        String sql = "select * from usuario where 1>0";
        if (usuario.getNome() != null && !usuario.getNome().equals("")) {
            sql += " and nome like '" + usuario.getNome() + "%' ";
        }
        if (usuario.getEmail() != null && !usuario.getEmail().equals("")) {
            sql += " and email like '" + usuario.getEmail() + "%' ";
        }
        if (usuario.getId() != null && !usuario.getId().equals(0)) {
            sql += " and id = '" + usuario.getId() + "%' ";
        }
        try {
            rs = conn.getResultset(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setEmail(rs.getString("email"));
                u.setId(rs.getLong("id"));
                u.setIsAdm(rs.getBoolean("isAdm"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                retorno.add(u);
            }

            return retorno;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean alterar(Object o) {
        usuario = (Usuario) o;
        ResultSet rs;
        try {

            if (usuario.getId() != null || usuario.getId() != 0) {
                String sql = "update usuario "
                        + "set nome='" + usuario.getNome() + "',"
                        + "email='" + usuario.getEmail() + "',";
                if (usuario.getSenha() != null) {
                    sql+="senha=md5('" + usuario.getSenha() + "'),";
                }
                sql+="isAdm=" + usuario.isIsAdm()
                        + " where id=" + usuario.getId();
                conn.executa(sql);
                return true;

            }
        } catch (Exception e) {
            try {
                throw new Exception(e.getMessage());

            } catch (Exception ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
        return false;

    }

    @Override
    public Object getById(Object id) {
        Usuario usuario = new Usuario();
        ResultSet rs;
        String sql = "select * from usuario where id=" + id;

        try {
            rs = conn.getResultset(sql);
            while (rs.next()) {
                usuario.setId(rs.getLong("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIsAdm(rs.getBoolean("isAdm"));
                usuario.setSenha(rs.getString("senha"));
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
    public String senhaMd5(String senha){
        ResultSet rs;
        
        String sql = "select md5('" + senha + "') as senha";
        try {
            rs = conn.getResultset(sql);
            return rs.getString("senha");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean verificar_senha(Long id, String senha){
        ResultSet rs;
        String senhaMD5= senhaMd5(senha);
        String sql = "select senha from usuario where id" + id;
        try {
            rs = conn.getResultset(sql);
            if(rs.getString("senha").equals(senhaMD5)){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
        
        
        
        
        
        
        
        
    
    }
    

}
