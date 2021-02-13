import { NgModule } from '@angular/core';
import {TranslateModule} from "@ngx-translate/core";
import {ModalModule} from "ngx-bootstrap";

@NgModule({
 exports:[
   TranslateModule,
   ModalModule
 ]
})
export class SharedModule { }
