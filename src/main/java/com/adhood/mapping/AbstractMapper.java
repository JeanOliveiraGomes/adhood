package com.adhood.mapping;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public interface AbstractMapper<CLASSE, DTO> {
    default List<DTO> entidadesParaDTOs(Collection<CLASSE> entidades) {
        return entidades == null ? null :
            entidades.stream()
                .filter(Objects::nonNull)
                .map(this::entidadeParaDTO)
                .collect(Collectors.toList());
    }
    default List<CLASSE> dtosParaEntidades(Collection<DTO> dtos) {
        return dtos == null ? null :
            dtos.stream()
                .filter(Objects::nonNull)
                .map(this::dtoParaEntidade)
                .collect(Collectors.toList());
    }
    DTO entidadeParaDTO(CLASSE entidade);
    CLASSE dtoParaEntidade(DTO dto);
    default Page<DTO> pageEntidadeParaPageDTO(Page<CLASSE> entidade) {
        return entidade.map(this::entidadeParaDTO);
    }

}
