package com.projeto.sistema.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.models.Estado;

//Quando queremos interagir com banco de dados usamos o Repository(função de crud)
public interface EstadoRepository extends JpaRepository<Estado,Long> {

}
