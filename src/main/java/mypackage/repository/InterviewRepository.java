package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Integer>{

}
