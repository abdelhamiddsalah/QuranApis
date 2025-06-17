package com.example.quran.Ayat;
import org.mapstruct.Mapper;


@Mapper(componentModel ="spring")
public interface AyatMapper {

    AyaEntity toEntity(AyaDto dto);

    AyaDto toDto(AyaEntity entity);
}
