package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("SELECT a FROM Account a JOIN FETCH a.contactList c WHERE a.id = :id")
    public Optional<Account> findByIdWithContact(@Param("id")String id);

    @Query("SELECT AVG(employeeCount) FROM Account")
    public double meanOfEmployeeCount();

    @Query("SELECT MAX(employeeCount) FROM Account")
    public Integer maxOfEmployeeCount();

    @Query("SELECT MIN(employeeCount) FROM Account")
    public Integer minOfEmployeeCount();

}
