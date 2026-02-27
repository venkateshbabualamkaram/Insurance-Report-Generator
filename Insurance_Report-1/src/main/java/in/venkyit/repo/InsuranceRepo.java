package in.venkyit.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.venkyit.entity.Insurance;
import in.venkyit.request.SearchRequest;
import in.venkyit.request.UserDto;

public interface InsuranceRepo extends JpaRepository<Insurance,Integer>{

    @Query("select distinct i.planName from Insurance i")
    public List<String> getPlanNames();

    @Query("select distinct i.planStatus from Insurance i")
    public List<String> getPlanStatus();
    
    
    @Query("""
    		select i from Insurance i
    		where (:#{#request.planName} IS NULL or i.planName = :#{#request.planName})
    		AND (:#{#request.planStatus} IS NULL or i.planStatus = :#{#request.planStatus})
    		AND (:#{#request.gender} IS NULL or i.gender = :#{#request.gender})
    		AND (:#{#request.planStartDate} IS NULL or i.planStartDate >= :#{#request.planStartDate})
    		AND (:#{#request.planEndDate} IS NULL or i.planEndDate <= :#{#request.planEndDate})
    		""")
    		List<Insurance> search(@Param("request") SearchRequest request);
}