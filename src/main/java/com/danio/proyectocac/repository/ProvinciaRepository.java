package com.danio.proyectocac.repository;

import com.danio.proyectocac.entity.Provincia;
import com.danio.proyectocac.entity.ProvinciaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    public Provincia findProvinciaByProvinciaEnum(ProvinciaEnum provinciaEnum);
}