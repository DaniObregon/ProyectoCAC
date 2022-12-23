package com.danio.proyectocac.service;

import com.danio.proyectocac.exception.LocalidadNotFoundException;
import com.danio.proyectocac.entity.Localidad;
import com.danio.proyectocac.entity.Provincia;
import com.danio.proyectocac.repository.LocalidadRespository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocalidadService {
    private final LocalidadRespository localidadRespository;
    private final ProvinciaService provinciaService;

    public LocalidadService(LocalidadRespository localidadRespository, ProvinciaService provinciaService) {
        this.localidadRespository = localidadRespository;
        this.provinciaService = provinciaService;
    }

    public Localidad findLocalidadById(Long id) {
        return localidadRespository.findById(id)
                .orElseThrow(() -> new LocalidadNotFoundException(id));
    }

    /**
     * Crea una Localidad y a la vez la agrega a la provincia seleccionada segun Enum
     * @param localidad
     * @return
     */
    public Localidad saveLocalidad(Localidad localidad) {
        Provincia provincia = provinciaService.findProvinciaByEnmun(localidad.getProvinciaEnum());
        provincia.addLocalidad(localidad);
        return localidadRespository.save(localidad);
    }

    public List<Localidad> getAllLocalidades() {
        return localidadRespository.findAll();
    }

    @Transactional
    public void deleteLocalidad(Long id){
        Localidad localidad = findLocalidadById(id);
        Provincia provincia = provinciaService.findProvinciaByEnmun(localidad.getProvinciaEnum());
        provincia.removeLocalidad(localidad);
        localidadRespository.deleteById(id);
    }
}

/**
<<<<<<< HEAD
 * Prueba GIT
=======
 * Prueba GIT 02
>>>>>>> branch02
 */