import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FieldsConstraintsConfiguration } from './services/fields.constraints.configuration.service';
import { HomeComponent } from './components/home/home.component';
import { SessionHttpInterceptor } from './Interceptors/session.http.interceptor';

const routes: Routes = [
  {path: 'login', component: LoginComponent, data: ['Login']},
  {path: 'register', component: RegisterComponent, data: ['Register']},
  {path: 'home', component: HomeComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [RouterModule],
  providers: [
    FieldsConstraintsConfiguration,
    {provide: HTTP_INTERCEPTORS, useClass: SessionHttpInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
