package com.ada.compra;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrdemCompraRepository extends CrudRepository<OrdemCompra, Long> {
}
