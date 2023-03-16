package com.exam.repo;

import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long>{

	public List<Quiz> findByCategory(Category cat);

	public List<Quiz> findByActive(boolean b);
	public List<Quiz> findByCategoryAndActive(Category c,boolean b);

}
