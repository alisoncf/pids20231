/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Administrador
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Aluno {
    private int id;
    private Pessoa pessoa;
    private Curso curso;
    private int ano_entrada;
    
    
    
    
    
}
