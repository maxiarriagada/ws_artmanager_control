package artmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artmanager.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
