package com.ts.consult.salaries.mapper;

import com.ts.consult.salaries.model.Salaries;
import com.ts.consult.salaries.dto.SalariesDTO;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = { })

public interface SalariesMapper extends EntityMapper<SalariesDTO, Salaries> {
	
	@Mappings({
	@Mapping(source = "id", target = "id"),
	
	})
	SalariesDTO toDto(Salaries generated);

	@Mappings({
		@Mapping(source = "id", target = "id")
		})
		Salaries toEntity(SalariesDTO salariesDTO);
		
		default Salaries fromId(String id) {
			if (id == null) {
				return null;
			}
			Salaries generated = new Salaries();
			generated.setId(id);
			return generated;
		}
}
