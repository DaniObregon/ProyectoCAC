package com.danio.proyectocac.dto;

import com.danio.proyectocac.entity.Localidad;
import com.danio.proyectocac.entity.ProvinciaEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LocalidadDto {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    private String nombre;

    private ProvinciaEnum provinciaEnum;

    public static LocalidadDto from(Localidad localidad){
        LocalidadDto localidadDto = new LocalidadDto();
        localidadDto.setId(localidad.getId());
        localidadDto.setNombre(localidad.getNombre());
        localidadDto.setProvinciaEnum(localidad.getProvinciaEnum());
        return localidadDto;
    }
}
