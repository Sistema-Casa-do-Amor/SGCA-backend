package br.com.casadoamor.sgca.administracao.mapper;

import br.com.casadoamor.sgca.administracao.dto.CidDto;
import br.com.casadoamor.sgca.administracao.entity.Cid;

public class CidMapper {

    public static CidDto toCidDto(Cid cid) {
        return new CidDto(
                cid.getSubcat(),
                cid.getDescricao(),
                cid.getDescrabrev()
        );
    }
}
