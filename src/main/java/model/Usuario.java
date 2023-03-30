/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class Usuario implements Serializable{
    private Long id;
    private String email;
    private String nome;
    private String senha;
    private boolean isAdm;
  

    /**
     * @return the id
     */
    public Usuario(){};
    public Usuario(Long id, String email, String nome, String senha, boolean isAdm) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.isAdm = isAdm;
    }

    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the isAdm
     */
    public boolean isIsAdm() {
        return isAdm;
    }
    
    /**
     * @param isAdm the isAdm to set
     */
    public void setIsAdm(boolean isAdm) {
        this.isAdm = isAdm;
    }

    
    
    
}
