package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, String> {

    //Returns a list of names and count of all Opportunities by SalesRep
    @Query(value = "SELECT s.name, COUNT(*) FROM SalesRep s JOIN FETCH Opportunity o ON s.id = o.salesRep " +
            "GROUP BY s.name")
    List<Object[]> countOfOpportunitiesBySalesReps();

    //Returns a list of names and count of all Opportunities by SalesRep where status is CLOSED_WON
    @Query(value = "SELECT s.name, COUNT(*) FROM SalesRep s JOIN FETCH Opportunity o ON s.id = o.salesRep " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_WON GROUP BY s.name")
    List<Object[]> countOfOpportunitiesBySalesRepsWhereClosedWon();

    //Returns a list of names and count of all Opportunities by SalesRep where status is CLOSED_LOST
    @Query(value = "SELECT s.name, COUNT(*) FROM SalesRep s JOIN FETCH Opportunity o ON s.id = o.salesRep " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_LOST GROUP BY s.name")
    List<Object[]> countOfOpportunitiesBySalesRepsWhereClosedLost();

    //Returns a list of names and count of all Opportunities by SalesRep where status is OPEN
    @Query(value = "SELECT s.name, COUNT(*) FROM SalesRep s JOIN FETCH Opportunity o ON s.id = o.salesRep " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.OPEN GROUP BY s.name")
    List<Object[]> countOfOpportunitiesBySalesRepsWhereOpen();

    //Returns a list of products and count of all Opportunities by Product
    @Query(value = "SELECT product, COUNT(*) FROM Opportunity GROUP BY product")
    List<Object[]> countOfOpportunitiesByProduct();

    //Returns a list of products and count of all Opportunities by Product where status is CLOSED_WON
    @Query(value = "SELECT product, COUNT(*) FROM Opportunity " +
            "WHERE status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_WON GROUP BY product")
    List<Object[]> countOfOpportunitiesByProductWhereClosedWon();

    //Returns a list of products and count of all Opportunities by Product where status is CLOSED_LOST
    @Query(value = "SELECT product, COUNT(*) FROM Opportunity " +
            "WHERE status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_LOST GROUP BY product")
    List<Object[]> countOfOpportunitiesByProductWhereClosedLost();

    //Returns a list of products and count of all Opportunities by Product where status is OPEN
    @Query(value = "SELECT product, COUNT(*) FROM Opportunity " +
            "WHERE status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.OPEN GROUP BY product")
    List<Object[]> countOfOpportunitiesByProductWhereOpen();



    //Returns a count of Opportunities for a specific SalesRep Id
    Integer countBySalesRepId(String salesRepId);
    //Return a count of Opportunities for a specific SalesRep Name
    Integer countBySalesRepName(String salesRep);
}
