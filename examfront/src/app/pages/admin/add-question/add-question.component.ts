import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';


@Component({  
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css'],
  
})
export class AddQuestionComponent implements OnInit {
  
  public Editor = ClassicEditor;
  constructor(private _route: ActivatedRoute,private questionService:QuestionService, private _quiz:QuizService) {}

  quizId: any;
  quizTitle:any;
  questions: any = {
    quiz: {},
    content: '',
    option1: '',
    option2: '',
    option3: '',
    option4: '',
    answer:'',
  };
  ngOnInit(): void {
    this.quizId = this._route.snapshot.paramMap.get('qid');
    this.quizTitle=this._route.snapshot.paramMap.get('title')
    this.questions.quiz['qid']=this.quizId;
  }

  addQue(){
    if(this.questions.content.trim() == '' || this.questions.content == null){
      return;
    }
    if(this.questions.option1.trim() == '' || this.questions.option1 == null){
      return;
    }
    if(this.questions.option2.trim() == '' || this.questions.option2 == null){
      return;
    }
    this.questionService.addQuestion(this.questions).subscribe((data)=>{
      console.log(data);
      Swal.fire("Success!!","Question Added",'success')
      this.questions.content = '';
      this.questions.option1 = '';
      this.questions.option2 = '';
      this.questions.option3 = '';
      this.questions.option4 = '';
      this.questions.answer = '';

      
    },(error)=>{
      Swal.fire("Error","something went wrong!!",'error')
    })
  }

  
  
}

