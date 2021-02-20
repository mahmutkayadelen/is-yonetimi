import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AppLayoutComponent} from "./_layout/app-layout/app-layout.component";
import {NotfoundComponent} from "./shared/notfound/notfound.component";

const routes: Routes = [
  {
    path: '', component: AppLayoutComponent,
    children: [
      {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
      {path: 'dashboard', loadChildren: './pages/dashboard/dashboard.module#DashboardModule'},
      {path: 'issue', loadChildren: './pages/issue/issue.module#IssueModule'},
      {path: 'project', loadChildren: './pages/project/project.module#ProjectModule'},
      {path: '', component: AppLayoutComponent}
    ]
  },
  {path: '**', component: NotfoundComponent} //template içermesin diye buraya ekledim. diğerleri app layou içinde çalışır.

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
