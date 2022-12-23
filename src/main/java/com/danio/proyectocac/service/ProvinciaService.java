package com.danio.proyectocac.service;

import com.danio.proyectocac.exception.ProvinciaNotFoundException;
import com.danio.proyectocac.entity.Localidad;
import com.danio.proyectocac.entity.Provincia;
import com.danio.proyectocac.entity.ProvinciaEnum;
import com.danio.proyectocac.repository.ProvinciaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinciaService {
    private final ProvinciaRepository provinciaRepository;

    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    public Provincia findProvinciaById(Long id){
        return provinciaRepository.findById(id)
                .orElseThrow(() -> new ProvinciaNotFoundException(id));
    }

    public Provincia saveProvincia(Provincia provincia){
        return provinciaRepository.save(provincia);
    }

    public List<Provincia> getAllProvincias(){
        return provinciaRepository.findAll();
    }

    public void deleteProvincia(Long id){
        provinciaRepository.deleteById(id);
    }

    public Provincia findProvinciaByEnmun(ProvinciaEnum provinciaEnum) {
        return provinciaRepository.findProvinciaByProvinciaEnum(provinciaEnum);
    }

    public List<String> getLocalidadesByProvinciaEnum(ProvinciaEnum provinciaEnum){
        Provincia provincia = findProvinciaByEnmun(provinciaEnum);
        List<String> nombresLocalidades = new ArrayList<>();
        for(Localidad localidad: provincia.getLocalidades()){
            nombresLocalidades.add(localidad.getNombre());
        }
        return nombresLocalidades;
    }

    public List<String> getLocalidadesByProvinciaId(Long id){
        Provincia provincia = findProvinciaById(id);
        List<String> nombresLocalidades = new ArrayList<>();
        for(Localidad localidad: provincia.getLocalidades()){
            nombresLocalidades.add(localidad.getNombre());
        }
        return nombresLocalidades;
    }
}
