package com.i_sys.practise.web.controllers.autos.dto;

import com.i_sys.practise.data.autos.Auto;
import java.util.UUID;

public class AutoDtoGet {
    public UUID id;
    public int productionYear;
    public int enginePower;
    public int engineCapacity;
    public UUID personId;

    public AutoDtoGet (Auto auto) {
        this.id = auto.getId();
        this.productionYear = auto.getProductionYear();
        this.enginePower = auto.getEnginePower();
        this.engineCapacity = auto.getEngineCapacity();
        this.personId = auto.getPerson().getId();
    }
}
