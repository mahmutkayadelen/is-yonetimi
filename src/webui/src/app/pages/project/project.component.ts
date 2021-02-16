import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProjectService} from "../../services/shared/project.service";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ConfirmationComponent} from "../../shared/confirmation/confirmation.component";


@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  modalRef: BsModalRef;
  page = new Page();
  rows =[];
  cols=[{prop :'id',name :'No'},
    {   prop :'projectName',name: 'Project Name',sortable:false},
    {  prop: 'projectCode',name : 'Project Code'}];
  private projectForm: FormGroup;

  constructor(private projectService: ProjectService,private modalService: BsModalService, private formBuilder:FormBuilder) {
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  ngOnInit() {
    this.setPage({offset: 0});
    this.projectForm = this.formBuilder.group({
      'projectName' :[null,[Validators.required,Validators.minLength(4)]],
      'projectCode' :[null,[Validators.required,Validators.minLength(2),Validators.maxLength(10)]]
    });
  }
get f(){return this.projectForm.controls}
  closeAndResetModal(){
    this.projectForm.reset();
    this.modalRef.hide();
  }
  saveProject(){
    if(!this.projectForm.valid)
    {
      return;
    }
    this.projectService.createProject(this.projectForm.value).subscribe(
      response =>{
        console.log(response);
      }
    )
    this.closeAndResetModal();
    this.setPage(this.page);
  }
  private setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.projectService.getAll(pageInfo).subscribe(
      (pagedData) => {
        this.page.size = pagedData.size;
        this.page.page = pagedData.page;
        this.page.totalElements=pagedData.totalElements;
        this.rows = pagedData.content;

      }
    );
  }

   showDeleteConfirmation(){
    const modal = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation('test heade content','test body content'

    );
    (<ConfirmationComponent>modal.content).onClose.subscribe(
      result =>{
        if(result===true)
        {
          console.log("Evet tıklandı")
        }
        else if(result ===false)
        {
          console.log("Hayır tıklandı")

        }
      }
    );
  }
}
