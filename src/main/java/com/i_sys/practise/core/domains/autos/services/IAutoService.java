package com.i_sys.practise.core.domains.autos.services;

import com.i_sys.practise.data.autos.Auto;
import com.i_sys.practise.web.controllers.autos.dto.AutoDtoPostOrPut;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface IAutoService {
    List<Auto> getAllAutos() throws Exception;

    Auto getAutoById(UUID id) throws Exception;

    void createAuto(AutoDtoPostOrPut auto) throws Exception;

    void updateAuto(UUID id, AutoDtoPostOrPut auto) throws Exception;

    void deleteAuto(UUID id) throws Exception;
}
