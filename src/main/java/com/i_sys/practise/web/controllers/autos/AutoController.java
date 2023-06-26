package com.i_sys.practise.web.controllers.autos;

import com.i_sys.practise.core.domains.autos.services.IAutoService;
import com.i_sys.practise.web.controllers.autos.dto.AutoDtoGet;
import com.i_sys.practise.web.controllers.autos.dto.AutoDtoPostOrPut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auto")
public class AutoController {
    private final IAutoService autoService;
    private static final Logger log = LoggerFactory.getLogger(AutoController.class.getName());

    public AutoController(IAutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public List<AutoDtoGet> getAllAutos() throws Exception {
        log.info("Call Method of AutoController: getAllAutos()");
        var result = new ArrayList<AutoDtoGet>();

        for (var auto : autoService.getAllAutos()) {
            result.add(new AutoDtoGet(auto));
        }

        log.info("Method of AutoController: getAllAutos(): HttpStatus 200");
        return result;
    }

    @GetMapping({"id"})
    public AutoDtoGet getAutoById(@RequestParam UUID id) throws Exception {
        log.info("Call Method of AutoController: getAutoById(" + id + ")");
        var result = new AutoDtoGet(autoService.getAutoById(id));
        log.info("Method of AutoController: getAutoById(" + id + ") HttpStatus 200");
        return result;
    }

    @PostMapping
    public void createAuto(@RequestBody AutoDtoPostOrPut auto) throws Exception {
        log.info("Call Method of AutoController: createAuto(" + auto + ")");
        autoService.createAuto(auto);
        log.info("Call Method of AutoController: createAuto(" + auto + ") HttpStatus 200");
    }

    @PutMapping({"id"})
    public void updateAuto(@RequestParam UUID id, @RequestBody AutoDtoPostOrPut auto) throws Exception {
        log.info("Call Method of AutoController: updateAuto(" + id + "," + auto + ")");
        autoService.updateAuto(id, auto);
        log.info("Call Method of AutoController: updateAuto(" + auto + ") HttpStatus 200");
    }

    @DeleteMapping({"id"})
    public void deleteAuto(@RequestParam UUID id) throws Exception {
        log.info("Call Method of AutoController: deleteAuto(" + id + ")");
        autoService.deleteAuto(id);
        log.info("Method of AutoController: deleteAuto(" + id + ") HttpStatus 200");
    }
}
