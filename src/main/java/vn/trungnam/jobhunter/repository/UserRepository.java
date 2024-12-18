package vn.trungnam.jobhunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.trungnam.jobhunter.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
