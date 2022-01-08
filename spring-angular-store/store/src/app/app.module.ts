import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfigResolver } from './services/ConfigResolver';
import { FieldsConstraintsConfiguration } from './services/fields.constraints.configuration.service';

const routes: Routes = [
  {path: 'login', component: LoginComponent, data: ['Login'], resolve: {config: ConfigResolver}},
  {path: 'register', component: RegisterComponent, data: ['Register']}
]
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent
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
  providers: [FieldsConstraintsConfiguration],
  bootstrap: [AppComponent]
})
export class AppModule { }
