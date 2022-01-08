import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FieldConstraints } from 'src/app/models/FieldConstraints';
import { Login } from 'src/app/models/Login';
import { AuthService } from 'src/app/services/auth.service';
import { FieldsConstraintsConfiguration } from 'src/app/services/fields.constraints.configuration.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup
  login: Login = new Login()
  constraints: FieldConstraints

  constructor(private formBuilder: FormBuilder, 
    private fieldsConstraintsConfiguration: FieldsConstraintsConfiguration,
    private loginService: AuthService) { 
      this.fieldsConstraintsConfiguration.getConfiguration()
      .then(c => {
        this.constraints = c
      })
    }

  async ngOnInit(): Promise<void> {
    this.form = this.formBuilder.group({
      login: [null, [Validators.required, Validators.minLength(this.constraints.loginMinLength)]],
      password: [null, [Validators.required, Validators.minLength(this.constraints.passwordMinLength)]]
    })
  }

  async authenticate() {
    if (this.form.valid) {
      this.loginService.login(this.login)
      .then(response => console.log('logged'))
      .catch(err => console.log(err))
    }
  }

}
