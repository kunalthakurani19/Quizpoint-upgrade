import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quiz-question',
  templateUrl: './view-quiz-question.component.html',
  styleUrls: ['./view-quiz-question.component.css'],
})
export class ViewQuizQuestionComponent implements OnInit {
  qId: any;
  qtitle: any;

  questions: any = []

  constructor(private router: ActivatedRoute, private questionService: QuestionService, private _snak: MatSnackBar) { }

  ngOnInit(): void {
    this.qId = this.router.snapshot.paramMap.get('qid');
    this.qtitle = this.router.snapshot.paramMap.get('title');


    this.questionService.getQuestions(this.qId).subscribe((data) => {
      this.questions = data;


    }, (error) => {
      console.log(error);
      Swal.fire("Error", "Something went wrong!!", 'error')
    })
  }

  deleteBtn(id: any) {

    Swal.fire({
      icon: 'info',
      showCancelButton: true,
      confirmButtonText: 'delete',
      title: 'Are you sure, want to delete this question?',
    }).then((result) => {
      if (result.isConfirmed) {
        this.questionService.deleteQue(this.qId).subscribe((data) => {
          Swal.fire("Deleted","Quiz Deletion successful !!",'success')
          this.questions = this.questions.filter((que: any) => que.quesId != id)
        },

        (error) => {
          Swal.fire("Deleted","Quiz Deletion successful !!",'success')

      })

    }
  })
}
}
