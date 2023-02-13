package br.com.eberts.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.eberts.domain.Categoria;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Por favor preencha um nome válido para Categoria!")
	@Length(min=5, max=80, message = "O tamanho do nome da categoria deve ter entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO(Categoria cat) {
		id = cat.getId();
		nome = cat.getNome();
		
	}
}
