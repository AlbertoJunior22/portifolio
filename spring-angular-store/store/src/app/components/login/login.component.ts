import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApplicationConstants } from 'src/app/constants/ApplicationConstants';
import { Credentials } from 'src/app/models/Credentials';
import { FieldConstraints } from 'src/app/models/FieldConstraints';
import { Login } from 'src/app/models/Login';
import { AuthService } from 'src/app/services/auth.service';
import { FieldsConstraintsConfiguration } from 'src/app/services/fields.constraints.configuration.service';
import { StorageService } from 'src/app/services/storage.service';
import { LogUtil } from 'src/app/Util/LogUtil';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup
  login: Login = new Login({login: 'system', password: 'system'})
  constraints: FieldConstraints
  log: LogUtil = new LogUtil('LoginComponent')

  constructor(private formBuilder: FormBuilder, 
    private fieldsConstraintsConfiguration: FieldsConstraintsConfiguration,
    private loginService: AuthService, private router: Router,
    private storage: StorageService) { 
      this.fieldsConstraintsConfiguration.getConfiguration()
      .then(c => {
        this.constraints = c
      }).catch(err => console.log('Error in retrieve configurations constraints'))
    }

  async ngOnInit(): Promise<void> {
    this.form = this.formBuilder.group({
      login: [null, [Validators.required, Validators.minLength(this.constraints?.loginMinLength)]],
      password: [null, [Validators.required, Validators.minLength(this.constraints?.passwordMinLength)]]
    })
  }

  async authenticate() {
    if (this.form.valid) {
      this.loginService.login(this.login)
      .then(response => this.setAuthenticated(response))
      .catch(err => {
        this.log.httpError(err)
      })
    }
  }

  setAuthenticated(credentials: Credentials) {
    this.storage.save(ApplicationConstants.SESSION_KEY, credentials)
    this.router.navigate(['/home'])
  }

}
