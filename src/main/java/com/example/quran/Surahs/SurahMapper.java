package com.example.quran.Surahs;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SurahMapper {

    @Mapping(target = "id", ignore = true)
    SurahEntity toEntity(SurahDto dto);

    SurahDto toDto(SurahEntity entity);
}
