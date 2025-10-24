package br.com.casadoamor.sgca.administracao.mapper;

import br.com.casadoamor.sgca.administracao.dto.CidDTO;
import br.com.casadoamor.sgca.administracao.entity.Cid;

public class CidMapper {

    public static CidDTO toCidDto(Cid cid) {
        return new CidDTO(
                cid.getSubcat(),
                cid.getDescricao(),
                cid.getDescrabrev()
        );
    }
}
