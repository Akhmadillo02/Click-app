package uz.ahmadillo.clickapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ahmadillo.clickapp.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
