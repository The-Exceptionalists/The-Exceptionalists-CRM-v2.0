package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

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

    //Returns a list of products and count of all Opportunities by Country
    @Query(value = "SELECT a.country, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "GROUP BY a.country")
    List<Object[]> countOfOpportuntiesByCountry();

    //Returns a list of products and count of all Opportunities by Country where status is CLOSED_WON
    @Query(value = "SELECT a.country, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_WON GROUP BY a.country")
    List<Object[]> countOfOpportuntiesByCountryWhereClosedWon();

    //Returns a list of products and count of all Opportunities by Country where status is CLOSED_LOST
    @Query(value = "SELECT a.country, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_LOST GROUP BY a.country")
    List<Object[]> countOfOpportuntiesByCountryWhereClosedLost();

    //Returns a list of products and count of all Opportunities by Country where status is OPEN
    @Query(value = "SELECT a.country, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.OPEN GROUP BY a.country")
    List<Object[]> countOfOpportuntiesByCountryWhereOpen();

    //Returns a list of products and count of all Opportunities by City
    @Query(value = "SELECT a.city, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "GROUP BY a.city")
    List<Object[]> countOfOpportuntiesByCity();

    //Returns a list of products and count of all Opportunities by City where status is CLOSED_WON
    @Query(value = "SELECT a.city, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_WON GROUP BY a.city")
    List<Object[]> countOfOpportuntiesByCityWhereClosedWon();

    //Returns a list of products and count of all Opportunities by City where status is CLOSED_LOST
    @Query(value = "SELECT a.city, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_LOST GROUP BY a.city")
    List<Object[]> countOfOpportuntiesByCityWhereClosedLost();

    //Returns a list of products and count of all Opportunities by City where status is OPEN
    @Query(value = "SELECT a.city, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.OPEN GROUP BY a.city")
    List<Object[]> countOfOpportuntiesByCityWhereOpen();

    //Returns a list of products and count of all Opportunities by Industry
    @Query(value = "SELECT a.industry, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "GROUP BY a.industry")
    List<Object[]> countOfOpportuntiesByIndustry();

    //Returns a list of products and count of all Opportunities by Industry where status is CLOSED_WON
    @Query(value = "SELECT a.industry, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_WON GROUP BY a.industry")
    List<Object[]> countOfOpportuntiesByIndustryWhereClosedWon();

    //Returns a list of products and count of all Opportunities by Industry where status is CLOSED_LOST
    @Query(value = "SELECT a.industry, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.CLOSED_LOST GROUP BY a.industry")
    List<Object[]> countOfOpportuntiesByIndustryWhereClosedLost();

    //Returns a list of products and count of all Opportunities by Industry where status is OPEN
    @Query(value = "SELECT a.industry, COUNT(*) FROM Account a JOIN FETCH Opportunity o ON a.id = o.account " +
            "WHERE o.status = com.ironhack.TheExceptionalistsCRMv20.enums.Status.OPEN GROUP BY a.industry")
    List<Object[]> countOfOpportuntiesByIndustryWhereOpen();


    @Query("SELECT AVG(quantity) FROM Opportunity")
    public double meanOfQuantity();

    @Query(value = "SELECT AVG(op.quantity) FROM " +
            "(SELECT o.quantity, @rownum\\:=@rownum+1 as 'row_number', @total_rows\\:=@rownum " +
            "FROM opportunities o, (SELECT @rownum\\:=0) r " +
            "ORDER BY o.quantity) as op " +
            "WHERE op.row_number IN (FLOOR((@total_rows+1)/2), FLOOR((@total_rows+2)/2))", nativeQuery = true)
    public double medianOfQuantity();

    @Query("SELECT MAX(quantity) FROM Opportunity")
    public Integer maxOfQuantity();

    @Query("SELECT MIN(quantity) FROM Opportunity")
    public Integer minOfQuantity();


    //Returns a count of Opportunities for a specific SalesRep Id
    Integer countBySalesRepId(Integer salesRepId);

    //Return a count of Opportunities for a specific SalesRep Name
    Integer countBySalesRepName(String salesRep);

}
