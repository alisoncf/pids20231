
package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Administrador
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    Long id;
    String nome;
    String cpf;
    String email;
    String endereco;
    String cidade;
    String uf;
    String telefone;
    String pais;
    
    
    
}
