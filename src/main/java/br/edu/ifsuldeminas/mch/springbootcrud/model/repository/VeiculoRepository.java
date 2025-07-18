package br.edu.ifsuldeminas.mch.springbootcrud.model.repository;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
