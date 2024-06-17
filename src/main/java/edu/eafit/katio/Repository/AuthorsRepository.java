package edu.eafit.katio.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.eafit.katio.models.Authors;

public interface AuthorsRepository extends CrudRepository<Authors, Long> {

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Id LIKE %:id%")
    List<Authors> findById(@Param("id") Integer id);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Name LIKE %:name%")
    List<Authors> findByName(@Param("name") String name);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Country LIKE %:country%")
    List<Authors> findByCountry(String country);
    
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors a WHERE a.Name = :name")
    Optional<Authors> findByNameOpt(@Param("name") String name);

        @Query(
        nativeQuery = true,
        value = "SELECT * FROM Authors WHERE Birthdate BETWEEN :startDate AND :endDate"
    )
    List<Authors> findByPublishedDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    Authors saveAndFlush(Authors authors);
}
