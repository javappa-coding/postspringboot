package com.javappa.postspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javappa.postspringboot.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}