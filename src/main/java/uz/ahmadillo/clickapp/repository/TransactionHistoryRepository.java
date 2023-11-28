package uz.ahmadillo.clickapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ahmadillo.clickapp.entity.TransactionHistory;
@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

}
