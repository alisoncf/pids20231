/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.UsuarioDao;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Administrador
 */
public final class UsuarioService {

    private List<Usuario> listaUsuarios = new ArrayList<>();
    UsuarioDao dao = new UsuarioDao();
    public UsuarioService() {
        
    }
    
    public List<Usuario> getUsuarios(Usuario filtro) {
        List<Usuario> lista = dao.listar(filtro);
        
        return lista;
    }
    public Long add(Usuario usuario){
        try {
            Long id = dao.inserir(usuario);
            return id;
        } catch (Exception e) {
            return null;
        }
        
    }
    public boolean alterar(Usuario usuario){
        try {
            return dao.alterar(usuario);
            
        } catch (Exception e) {
            return false;
        }
        
    }
    public void remove(Usuario usuario){
        this.listaUsuarios.remove(usuario);
    }
    public Usuario get(Long id){
        Usuario u = new Usuario();
        u = (Usuario) dao.getById(id);
        
        return u;
        
        
    }
    public void populate(){
        this.listaUsuarios.add(new Usuario(1L,"joao@gmail.com","Joao","12345",true));
        this.listaUsuarios.add(new Usuario(2L,"pedr@gmail.com","PEdro","abc1234",true));
    }
    
}
