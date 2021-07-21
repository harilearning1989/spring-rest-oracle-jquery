package com.web.demo.repos;

import com.web.demo.entities.CropInsurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CropInsuranceRepository extends CrudRepository<CropInsurance, Integer> {
    public List<CropInsurance> findByMandalName(String mandalName);
    public List<CropInsurance> findByMandalNameIgnoreCase(String mandalName);
    public List<CropInsurance> findByMandalNameContainingIgnoreCase(String mandalName);
    public List<CropInsurance> findByMandalNameIgnoreCaseAndCropIgnoreCase(String mandal,String crop);
    public List<CropInsurance> findByClaimAmountGreaterThanEqual(int start);
    public List<CropInsurance> findByClaimAmountBetweenOrderByClaimAmount(int min,int max);
    public List<CropInsurance> findByClaimAmountGreaterThanEqualAndClaimAmountLessThanEqualOrderByClaimAmount(int min,int max);
    public List<CropInsurance> findByClaimAmountInOrderByClaimAmount(List<Integer> claimAmount);

    /*List<User> findByBirthDateAfter(ZonedDateTime birthDate);
    List<User> findByBirthDateBefore(ZonedDateTime birthDate);*/
}
