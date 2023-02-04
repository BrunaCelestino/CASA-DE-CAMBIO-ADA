package com.ada.cadastro;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {

    Cliente findByCpf (String cpf);

}
