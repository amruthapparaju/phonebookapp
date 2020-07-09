package com.miniproject.one.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.one.entity.ContactEntity;

public interface ContactRepo extends JpaRepository<ContactEntity, Serializable> {

}
