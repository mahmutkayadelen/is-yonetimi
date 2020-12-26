import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IssueComponent } from './issue.component';
import {IssueRoutingModule} from "./issue.routing.module";



@NgModule({
  declarations: [IssueComponent],
  imports: [
    CommonModule,
    IssueRoutingModule  //her modülde o modülün routinginin tanımlanması lazım.
  ]
})
export class IssueModule { }
