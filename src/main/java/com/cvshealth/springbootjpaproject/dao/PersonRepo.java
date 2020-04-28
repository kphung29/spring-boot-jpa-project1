package com.cvshealth.springbootjpaproject.dao;

        import com.cvshealth.springbootjpaproject.model.Person;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;


        import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {

        List<Person> findByTech(String tech);

        List<Person> findByIdGreaterThan(int id);

        @Query("from Person where tech =?1 order by name")
        List<Person> findByTechSorted(String tech);

}
