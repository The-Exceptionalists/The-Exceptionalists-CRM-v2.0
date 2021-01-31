package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, String> {

    //Returns a list of names and count of all Leads by SalesRep
//    @Query(value = "SELECT s.name, COUNT(*) FROM SalesRep s JOIN FETCH Lead l ON s.id = l.salesRep " +
//            "GROUP BY s.name")
//    List<Object[]> countOfLeadsBySalesReps();

    //Returns a list of products and count of all Leads by Product
//    @Query(value = "SELECT o.product, o.COUNT(*) FROM Opportunity o JOIN FETCH SalesRep s ON o.salesRep = s.id " +
//            "JOIN FETCH Lead l ON s.id = l.salesRep GROUP BY product")
//    List<Object[]> countOfLeadsByProduct();

    //Return a list of Leads and count all Lead by Country
//    @Query(value = "SELECT a.country, l.COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
//            "JOIN FETCH SalesRep s ON o.salesRep = s.id" +
//            "JOIN FETCH Lead l ON s.id = l.salesRep GROUP BY a.country")
//    List<Object[]> countOfLeadsByCountry();

    //Return a list of Leads and count all Lead by city
//    @Query(value = "SELECT a.city, a.COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
//            "JOIN FETCH SalesRep s ON o.salesRep = s.id" +
//            "JOIN FETCH Lead l ON s.id = l.salesRep GROUP BY a.city")
//    List<Object[]> countOfLeadsByCity();

    //Return a list of Leads and count all Lead by industry
//    @Query(value = "SELECT a.industry, a.COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
//            "JOIN FETCH SalesRep s ON o.salesRep = s.id" +
//            "JOIN FETCH Lead l ON s.id = l.salesRep GROUP BY a.industry")
//    List<Object[]> countOfLeadsByIndustry();

}