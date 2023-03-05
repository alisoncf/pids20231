/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author Administrador
 */
public interface CRUD {
    public Long inserir(Object obj);
    public boolean alterar(Object obj);
    public boolean excluir(Object obj);
    public List <?> listar(Object filtro);
    public Object pesquisar (Object filtro);
    public Object getById (Object id);
    
    
}
