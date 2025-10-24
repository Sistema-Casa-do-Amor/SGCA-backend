package br.com.casadoamor.sgca.administracao.mapper;

import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeDTO;
import br.com.casadoamor.sgca.administracao.dto.ProfissionalSaudeRequestJson;
import br.com.casadoamor.sgca.administracao.entity.ProfissionalSaude;

public class ProfissionalSaudeMapper {

    public static ProfissionalSaudeDTO toProfissionalSaudeDto(ProfissionalSaude profissional) {
        return new ProfissionalSaudeDTO(
                profissional.getId(),
                profissional.getTipo(),
                profissional.getDocumento(),
                profissional.getUfDocumento(),
                profissional.getEspecialidade(),
                PessoaFisicaMapper.toPessoaFisicaDto(profissional.getPessoaFisica())
        );
    }

    public static ProfissionalSaude toProfissionalSaude(ProfissionalSaudeDTO profissional) {
        return new ProfissionalSaude(
                profissional.getId(),
                profissional.getTipo(),
                profissional.getDocumento(),
                profissional.getUfDocumento(),
                profissional.getEspecialidade(),
                PessoaFisicaMapper.toPessoaFisica(profissional.getPessoaFisica())
        );
    }

    public static ProfissionalSaude toProfissionalSaude(ProfissionalSaudeRequestJson profissional) {
        return new ProfissionalSaude(
                profissional.getId(),
                profissional.getTipo(),
                profissional.getDocumento(),
                profissional.getUfDocumento(),
                profissional.getEspecialidade(),
                null
        );
    }
}
