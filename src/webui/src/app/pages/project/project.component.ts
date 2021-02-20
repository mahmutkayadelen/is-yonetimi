import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ProjectService} from "../../services/shared/project.service";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ConfirmationComponent} from "../../shared/confirmation/confirmation.component";
import {UserService} from "../../services/shared/user.service";


@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  @ViewChild( 'tplProjectDeleteCell') tplProjectDeleteCell:TemplateRef<any>;

  modalRef: BsModalRef;
  page = new Page();
  rows =[];
  cols=[];
  managerOptions=[]
  private projectForm: FormGroup;


  constructor(private projectService: ProjectService,
              private modalService: BsModalService,
              private formBuilder:FormBuilder,
              private userService: UserService) {
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  ngOnInit() {

    this.cols=[{prop :'id',name :'No'},
      {   prop :'projectName',name: 'Project Name',sortable:false},
      {  prop: 'projectCode',name : 'Project Code'},
      {  prop: 'manager.nameSurname',name : 'Manager'},

      {  prop: 'id',name : 'Actions', cellTemplate:this.tplProjectDeleteCell,flexGrow : 1,sortable:false}
    ];
    this.setPage({offset: 0});
    this.projectForm = this.formBuilder.group({
      'projectName' :[null,[Validators.required,Validators.minLength(4)]],
      'projectCode' :[null,[Validators.required,Validators.minLength(2),Validators.maxLength(10)]],
      'managerId':[null,[Validators.required]]
    });
    this.userService.getAll().subscribe(res =>{
      this.managerOptions=res;
      console.log(res);
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
        this.closeAndResetModal();
        this.setPage(this.page);
      }
    )

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

   showDeleteConfirmation(value:any):void{
    const modal = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation('Silinsin mi','Silmek istermisiniz?'

    );
    (<ConfirmationComponent>modal.content).onClose.subscribe(
      result =>{
        if(result===true)
        {
          console.log("valueess",value)
          this.projectService.delete(value).subscribe(response =>{
            this.setPage({offset:0});
            }
          );

        }
        else if(result ===false)
        {
          console.log("Hayır tıklandı")
        }
      }
    );
  }

}
