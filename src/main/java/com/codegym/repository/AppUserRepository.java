package com.codegym.repository;


import com.codegym.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends  CrudRepository<AppUser, Long> {

    AppUser getAppUsersByName(String name);


}
