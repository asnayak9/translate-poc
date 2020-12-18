package com.shree.poc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shree.poc.entities.Taxbook;

public interface TaxBookRepository extends CrudRepository<Taxbook, Long> {

}
