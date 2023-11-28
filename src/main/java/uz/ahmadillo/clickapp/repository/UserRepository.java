package uz.ahmadillo.clickapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ahmadillo.clickapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
