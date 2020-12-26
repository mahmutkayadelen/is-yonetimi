import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ProjectComponent} from "./project.component";


const  routes: Routes =[
  {
    path: '',
    component: ProjectComponent
  }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]

  }
)
export  class  ProjectRoutingModule{ }


//örneğin isyonetimi.com/issues/... altındaındaki bütün menlerin yönetilmesini sağlayacak diğer ekranlar içinde aynısı geçerli
