package br.edu.ifsuldeminas.mch.springbootcrud.model.repository;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// A linha abaixo é a solução. Ela faz com que a interface herde o método findAll() e outros.
public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {
}


