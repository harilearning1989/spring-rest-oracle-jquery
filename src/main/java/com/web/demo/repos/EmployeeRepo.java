package com.web.demo.repos;

import com.web.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Procedure(name = "show_people_data", value = "show_people_data")
    Object[] getPeopleData(@Param("my_param_in") String myParamIn);

    @Query(nativeQuery = true, value = "SELECT PKG_TEST.HELLO_WORLD(:text) FROM dual")
    String callHelloWorld(@Param("text") String text);

    @Query(nativeQuery = true, value = "SELECT PKG_TEST.GET_FIRST_NAME(:empId) FROM dual")
    String getFirstName(@Param("empId") int empId);

    @Query(nativeQuery = true, value = "SELECT PKG_TEST.GET_ALL_FIRST_NAMES(:empId) FROM dual")
    List<String> getAllFirstNames(@Param("empId") int empId);

    @Query(nativeQuery = true, value = "SELECT COLUMN_VALUE FROM TABLE (PKG_TEST.tabfunc_concat ()) ORDER BY COLUMN_VALUE")
    List<String> callNestedTableFunc();

}
