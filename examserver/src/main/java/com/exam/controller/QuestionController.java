package com.exam.controller;

import com.exam.model.exams.Question;
import com.exam.model.exams.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;

    //add question

    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question)
    {
    	System.out.println("hidifjsidho");
    	System.out.println(question);
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    //get quiz wise questions
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("qid") Long qid)
    {
        Quiz quiz=this.quizService.getQuiz(qid);
        Set<Question> questions=quiz.getQuestions();
        int totalQuestions=Integer.parseInt(quiz.getNumberOfQuestions());
        List list=new ArrayList(questions);
        if(list.size()>totalQuestions)
        {
            list=list.subList(0,totalQuestions+1);
        }
        Collections.shuffle(list);

        return ResponseEntity.ok(list);
    }


    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getAllQuestionsOfQuizAdmin(@PathVariable("qid") Long qid)
    {
      Quiz quiz=new Quiz();
      quiz.setQid(qid);
      Set<Question>list=this.service.getQuestionOfQuiz(quiz);

        return ResponseEntity.ok(list);
    }


    //get a single question
    @GetMapping("/{qid}")
    public Question getQuestion(@PathVariable("qid") Long qid)
    {
        return this.service.getQuestion(qid);
    }
    //delete a single question
    @DeleteMapping("{qid}")
    public void deleteQuestion(@PathVariable("qid") Long qid)
    {
        this.service.deleteQuestion(qid);
    }

    //evalquiz
    @PostMapping("/eval-quiz")
    public  ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
        System.out.println(questions);
        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;
        for(Question q : questions){
           // single questions
            Question question = this.service.get(q.getQuesId());
            if(question.getAnswer().equals(q.getGivenAnswer())){
                //correct
                correctAnswers++;
                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot += marksSingle;
            }
            if(q.getGivenAnswer() != null){
                attempted++;
            }

        };

        Map<Object,Object> map =  Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);

        return ResponseEntity.ok(map);
    }
}
