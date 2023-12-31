package com.s.base.repository;

import com.s.base.repository.model.Prime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimeRepository extends JpaRepository<Prime, Integer> {
  List<Prime> findFirst10ByOrderByCreationDatetimeDesc();
}
