package br.com.eberts.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.eberts.domain.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Por favor preencha um nome válido para o Cliente!")
	@Length(min=5, max=120, message = "O tamanho do nome da categoria deve ter entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Por favor preencha um email válido para o Cliente!")
	@Email
	private String email;
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email= obj.getEmail();
	}
	
}
