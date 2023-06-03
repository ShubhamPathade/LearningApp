package mypackage.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.*;
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Integer>{

}
