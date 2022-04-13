package com.dbc.veiculoprodutorconsumidor.repository;

import com.dbc.veiculoprodutorconsumidor.Entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<VeiculoEntity, String> {

}
