import {NgModule} from '@angular/core';
import {TranslateModule} from "@ngx-translate/core";
import {BsModalRef, ModalModule} from "ngx-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ConfirmationComponent} from './confirmation/confirmation.component';
import {CommonModule} from "@angular/common";
import {HttpClient} from "@angular/common/http";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import { NotfoundComponent } from './notfound/notfound.component';
export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}


@NgModule({
  exports: [
    TranslateModule,
    ModalModule,
    ReactiveFormsModule,
    ConfirmationComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  providers :[BsModalRef],
  entryComponents:[ConfirmationComponent],
  declarations: [ConfirmationComponent]
})
export class SharedModule {
}
