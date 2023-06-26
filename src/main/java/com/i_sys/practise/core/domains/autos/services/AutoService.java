package com.i_sys.practise.core.domains.autos.services;

import com.i_sys.practise.core.domains.autos.repositories.IAutoRepository;
import com.i_sys.practise.core.domains.persons.repositories.IPersonRepository;
import com.i_sys.practise.data.autos.Auto;
import com.i_sys.practise.web.controllers.autos.dto.AutoDtoPostOrPut;
import com.i_sys.practise.web.exceptions.NotFoundException;
import com.i_sys.practise.web.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AutoService implements IAutoService {
    private static final Logger log = LoggerFactory.getLogger(AutoService.class.getName());
    private final IAutoRepository autoRepository;
    private final IPersonRepository personRepository;

    @Autowired
    public AutoService(IAutoRepository autoRepository, IPersonRepository personRepository) {
        this.autoRepository = autoRepository;
        this.personRepository = personRepository;
    }

    public List<Auto> getAllAutos() throws Exception {
        log.info("Call Method of AutoService: getAllAutos()");

        var result = autoRepository.findAll();

        log.info("Method of AutoService: getAllAutos() successfully completed");

        return result;
    }

    public Auto getAutoById(UUID id) throws Exception {
        log.info("Call Method of AutoService: getAutoById(" + id + ")");
        var auto = autoRepository.findById(id).orElse(null);

        if (auto == null) {
            throw new NotFoundException("The auto with the specified id was not found in the system!");
        }

        log.info("Method of AutoService: getAutoById(" + id + ") successfully completed");

        return auto;
    }

    public void createAuto(AutoDtoPostOrPut auto) throws Exception {
        log.info("Call Method of AutoService: createAuto(" + auto + ")");

        if (auto == null) {
            throw new ValidationException("Auto is null!");
        }

        var person = personRepository.findById(auto.personId).orElse(null);

        if (person == null) {
            throw new ValidationException("The person with the specified id was not found in the system!");
        }

        autoRepository.save(new Auto(auto.productionYear, auto.enginePower, auto.engineCapacity, person));

        log.info("Call Method of AutoService: createAuto(" + auto + ") successfully completed");
    }

    public void updateAuto(UUID id, AutoDtoPostOrPut auto) throws Exception {
        log.info("Call Method of AutoService: updateAuto(" + id + "," + auto + ")");

        if (auto == null) {
            throw new ValidationException("Auto is null!");
        }

        var entity = autoRepository.findById(id).orElse(null);

        if (entity == null) {
            throw new NotFoundException("The auto with the specified id was not found in the system!");
        }

        var person = personRepository.findById(auto.personId).orElse(null);

        if (person == null) {
            throw new ValidationException("The person with the specified id was not found in the system!");
        }

        entity.setProductionYear(auto.productionYear);
        entity.setEnginePower(auto.enginePower);
        entity.setEngineCapacity(auto.engineCapacity);
        entity.setPerson(person);

        autoRepository.save(entity);

        log.info("Call Method of AutoService: updateAuto(" + id + "," + auto + ") successfully completed");
    }

    public void deleteAuto(UUID id) throws Exception {
        log.info("Call Method of AutoService: deleteAuto(" + id + ")");
        var result = autoRepository.findById(id).orElse(null);

        if (result == null) {
            throw new NotFoundException("The auto with the specified id was not found in the system!");
        }

        autoRepository.delete(result);
        log.info("Method of AutoService: deleteAuto(" + id + ") successfully completed");
    }
}
