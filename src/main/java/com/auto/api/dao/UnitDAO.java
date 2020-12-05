package com.auto.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.api.entities.Unit;

public interface UnitDAO extends JpaRepository<Unit, Long>{

}
