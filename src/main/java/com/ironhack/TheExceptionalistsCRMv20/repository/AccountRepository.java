package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a JOIN FETCH a.opportunityList WHERE a.id = :id")
    public Optional<Account> findByIdFetchOpp(@Param("id") Integer id);

    @Query("SELECT a FROM Account a JOIN FETCH a.contactList WHERE a.id = :id")
    public Optional<Account> findByIdFetchCon(@Param("id") Integer id);

    @Query("SELECT a FROM Account a JOIN FETCH a.contactList c WHERE a.id = :id")
    public Optional<Account> findByIdWithContact(@Param("id") Integer id);

    @Query("SELECT AVG(employeeCount) FROM Account")
    public double meanOfEmployeeCount();

    @Query(value = "SELECT AVG(e.employee_count) FROM " +
            "(SELECT a.employee_count, @rownum\\:=@rownum+1 as 'row_number', @total_rows\\:=@rownum " +
            "FROM accounts a, (SELECT @rownum\\:=0) r " +
            "ORDER BY a.employee_count) as e " +
            "WHERE e.row_number IN (FLOOR((@total_rows+1)/2), FLOOR((@total_rows+2)/2))", nativeQuery = true)
    public double medianOfEmployeeCount();

    @Query("SELECT MAX(employeeCount) FROM Account")
    public Integer maxOfEmployeeCount();

    @Query("SELECT MIN(employeeCount) FROM Account")
    public Integer minOfEmployeeCount();

    @Query(value = "SELECT AVG(count_id) FROM (SELECT COUNT(account_id) count_id FROM opportunities " +
            "GROUP BY account_id) AS opp_list", nativeQuery = true)
    public double meanOfOpportunitiesOnAccounts();

    @Query(value = "SELECT AVG(o.count_id) FROM " +
            "(SELECT opp_list.count_id, @rownum\\:=@rownum+1 as 'row_number', @total_rows\\:=@rownum " +
            "FROM (SELECT COUNT(account_id) count_id FROM opportunities " +
            "GROUP BY account_id) AS opp_list, (SELECT @rownum\\:=0) r " +
            "ORDER BY opp_list.count_id) as o " +
            "WHERE o.row_number IN (FLOOR((@total_rows+1)/2), FLOOR((@total_rows+2)/2))", nativeQuery = true)
    public double medianOfOpportunitiesOnAccounts();

    @Query(value = "SELECT MAX(count_id) FROM (SELECT COUNT(account_id) count_id FROM opportunities " +
            "GROUP BY account_id) AS opp_list", nativeQuery = true)
    public Integer maxOfOpportunitiesOnAccounts();

    @Query(value = "SELECT MIN(count_id) FROM (SELECT COUNT(account_id) count_id FROM opportunities " +
            "GROUP BY account_id) AS opp_list", nativeQuery = true)
    public Integer minOfOpportunitiesOnAccounts();

}
