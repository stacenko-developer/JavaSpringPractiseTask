package com.i_sys.practise.core.domains.autos.repositories;

import com.i_sys.practise.data.autos.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IAutoRepository extends JpaRepository<Auto, UUID> {

}
