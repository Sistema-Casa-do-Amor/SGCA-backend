package br.com.casadoamor.sgca.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {

    private String endereco;
    private String bairro;
    private Integer numero;
    private String cidade;
    private String estado;
    private String cep;
    private String complemento;

}
