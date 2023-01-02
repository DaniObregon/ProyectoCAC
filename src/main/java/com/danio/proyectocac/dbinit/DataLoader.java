package com.danio.proyectocac.dbinit;

import com.danio.proyectocac.entity.Provincia;
import com.danio.proyectocac.entity.ProvinciaEnum;
import com.danio.proyectocac.service.ProvinciaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Esta clase inicializa la DB con generos por defecto
 */
@Component
public class DataLoader implements ApplicationRunner {

    private MultipartFile file;
    private final String provinciaImageFolder = "src/main/resources/static/image";
    private final ProvinciaService provinciaService;

    public DataLoader(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    /**
     * Este metodo evalua si los generos ya fueron insertados en la DB
     * si la lista es == 0, se crean los generos, de lo contraio no hace nada.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (provinciaService.getAllProvincias().size() == 0) {
            createProvince("/buenosaires.png", "Buenos Aires");
            createProvince("/cordoba.png", "Cordoba");
            createProvince("/sanluis.png", "San Luis");
            createProvince("/mendoza.png", "Mendoza");
            createProvince("/neuquen.png", "Neuquen");
        }
    }

    private void createProvince(String image, String name) {

        Provincia provincia = new Provincia();
        File file = new File(provinciaImageFolder + image);

        try {
            FileInputStream input = new FileInputStream(file);
            this.file = new MockMultipartFile("NEWFILE!", file.getName(), MediaType.IMAGE_JPEG_VALUE, input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        provincia.setNombre(name);
        provincia.setProvinciaEnum(ProvinciaEnum.getNombre(name));
        provinciaService.saveProvincia(provincia);
    }
}