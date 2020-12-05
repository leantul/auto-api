package com.auto.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.api.entities.Auto;

public interface AutoDAO extends JpaRepository<Auto, Long> {

}
