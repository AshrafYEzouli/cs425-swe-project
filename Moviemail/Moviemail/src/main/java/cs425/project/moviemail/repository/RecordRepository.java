package cs425.project.moviemail.repository;

import cs425.project.moviemail.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("select r from Record r where r.customer.customerId = ?1")
    List<Record> getAllRecordsByCustomerId(Long customerId);
}
