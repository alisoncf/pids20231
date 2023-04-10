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
import model.Pessoa;
import model.Pessoa;
import util.ConectaBD;
import util.Util;

/**
 *
 * @author Administrador
 */
public class PessoaDao implements CRUD {

    Pessoa pessoa;
    ConectaBD conn = new ConectaBD();

    @Override
    public Long inserir(Object obj) {
        pessoa = (Pessoa) obj;
        ResultSet rs;
        try {

            Long id = 0L;
            if (pessoa.getId() == null || pessoa.getId() == 0) {
                String sql = "insert into pessoa(cpf,nome,endereco,cidade,uf,pais,email,telefone)values("
                        + "'" + pessoa.getNome() + "',"
                        + "'" + pessoa.getCpf() + "',"
                        + "'" + pessoa.getEndereco() + "',"
                        + "'" + pessoa.getCidade() + "',"
                        + "'" + pessoa.getUf() + "',"
                        + "'" + pessoa.getPais() + "',"
                        + "'" + pessoa.getEmail() + "',"
                        + "'" + pessoa.getTelefone() + "')"
                        + " returning id";
                id = conn.inserirReturningId(sql);
                return id;

            }
        } catch (Exception e) {
            try {
                throw new Exception(e.getMessage());

            } catch (Exception ex) {
                Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Pessoa> listar(Object filtro) {
        Pessoa pessoa = new Pessoa();
        pessoa = (Pessoa) filtro;
        List<Pessoa> retorno = new ArrayList<>();
        ResultSet rs;

        ConectaBD conn = new ConectaBD();

        String sql = "select * from pessoa where 1>0";
        if (pessoa.getNome() != null && !pessoa.getNome().equals("")) {
            sql += " and nome like '" + pessoa.getNome() + "%' ";
        }
        if (pessoa.getEmail() != null && !pessoa.getEmail().equals("")) {
            sql += " and email like '" + pessoa.getEmail() + "%' ";
        }
        if (pessoa.getId() != null && !pessoa.getId().equals(0)) {
            sql += " and id = '" + pessoa.getId() + "%' ";
        }
        try {
            rs = conn.getResultset(sql);
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setEmail(rs.getString("email"));
                p.setId(rs.getLong("id"));
                p.setCidade(rs.getString("cidade"));
                p.setPais(rs.getString("pais"));
                p.setUf(rs.getString("uf"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                p.setEndereco(rs.getString("endereco"));
                retorno.add(p);
            }

            return retorno;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Object pesquisar(Object filtro) {
        Pessoa pessoa = new Pessoa();
        pessoa = (Pessoa) filtro;
        List<Pessoa> retorno = new ArrayList<>();
        ResultSet rs;

        ConectaBD conn = new ConectaBD();

        String sql = "select * from pessoa where 1>0";
        if (pessoa.getNome() != null && !pessoa.getNome().equals("")) {
            sql += " and nome like '" + pessoa.getNome() + "%' ";
        }
        if (pessoa.getEmail() != null && !pessoa.getEmail().equals("")) {
            sql += " and email like '" + pessoa.getEmail() + "%' ";
        }
        if (pessoa.getId() != null && !pessoa.getId().equals(0)) {
            sql += " and id = '" + pessoa.getId() + "' ";
        }
        if (pessoa.getCpf() != null) {
            sql += " and cpf = '" + pessoa.getCpf() + "%' ";
        }
        try {
            rs = conn.getResultset(sql);
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setEmail(rs.getString("email"));
                p.setId(rs.getLong("id"));
                p.setCidade(rs.getString("cidade"));
                p.setPais(rs.getString("pais"));
                p.setUf(rs.getString("uf"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                p.setEndereco(rs.getString("endereco"));

                retorno.add(p);
            }

            return retorno;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean alterar(Object o) {
        pessoa = (Pessoa) o;
        ResultSet rs;
        try {

            if (pessoa.getId() != null || pessoa.getId() != 0) {
                String sql = "update pessoa "
                        + "set nome='" + pessoa.getNome() + "',"
                        + "endereco='" + pessoa.getEndereco() + "',"
                        + "cidade='" + pessoa.getCidade() + "',"
                        + "email='" + pessoa.getEmail() + "',"
                        + "uf='" + pessoa.getUf() + "',"
                        + "cpf='" + pessoa.getCpf() + "',"
                        + "pais='" + pessoa.getPais() + "',"
                        + "telefone='" + pessoa.getTelefone() + "',"
                        + " where id=" + pessoa.getId();
                conn.executa(sql);
                return true;

            }
        } catch (Exception e) {
            try {
                throw new Exception(e.getMessage());

            } catch (Exception ex) {
                Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
        return false;

    }

    @Override
    public Object getById(Object id) {
        Pessoa pessoa = new Pessoa();
        ResultSet rs;
        String sql = "select * from pessoa where id=" + id;

        try {
            rs = conn.getResultset(sql);
            while (rs.next()) {
                pessoa.setId(rs.getLong("id"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setPais(rs.getString("pais"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCpf(rs.getString("cpf"));

            }

        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pessoa;
    }

}
