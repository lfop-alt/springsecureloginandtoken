package com.lfop.assembleia.repository;

import com.lfop.assembleia.model.TesteModel;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface Teste extends CrudRepository<TesteModel, Long> {
}
