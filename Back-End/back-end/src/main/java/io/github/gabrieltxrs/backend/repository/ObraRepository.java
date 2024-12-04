package io.github.gabrieltxrs.backend.repository;

import io.github.gabrieltxrs.backend.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
