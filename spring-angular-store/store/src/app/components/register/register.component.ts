import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/Address';
import { FieldConstraints } from 'src/app/models/FieldConstraints';
import { Person } from 'src/app/models/Person';
import { FieldsConstraintsConfiguration } from 'src/app/services/fields.constraints.configuration.service';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  person: Person
  address: Address
  form: FormGroup
  config: FieldConstraints = new FieldConstraints()

  constructor(private formBuilder: FormBuilder,
    private fieldsConstraintsConfiguration: FieldsConstraintsConfiguration,
    private personService: PersonService, private router: Router) { 
      this.person = new Person()
      this.person.address = new Array()
      this.address = new Address()
      this.person.address.push(this.address)

      this.fieldsConstraintsConfiguration.getConfiguration()
      .then(c => {
        this.config = c
      })
    }

  async ngOnInit(): Promise<void> {
    this.form = this.formBuilder.group({
      login: [null, [Validators.required ,Validators.minLength(this.config.loginMinLength)]],
      email: [null, [Validators.email, Validators.required, Validators.minLength(this.config.loginMinLength)]],
      emailConfirmation: [null,[Validators.email, Validators.required, Validators.minLength(this.config.loginMinLength)]],
      password: [null, [Validators.required, Validators.minLength(this.config.passwordMinLength)]],
      passwordConfirmation: [null, [Validators.required, Validators.minLength(this.config.passwordMinLength)]],
      name: [null, [Validators.required, Validators.minLength(this.config.nameMinLength)]],
      birthday: [null, [Validators.required]],
      identity: [null, [Validators.required]],
      street: [null, [Validators.required]],
      number: [null, [Validators.required]],
      district: [null, [Validators.required]],
      city: [null, [Validators.required]],
      zipCode: [null, [Validators.required]],
    }) 

    this.form.setValidators(this.verifySameValue('email', 'emailConfirmation'))
    this.form.setValidators(this.verifySameValue('password', 'passwordConfirmation'))
  }

  public verifySameValue(v1: string, v2: string) : ValidatorFn {
    return (current: AbstractControl): {[key: string]: any} => {
      if (this.form.controls[v1].value !== this.form.controls[v2].value) {
        let errors: any = {}
        errors[v1] = true
        errors[v2] = true
        return errors
      }
      return {}
    }
  }

  registerPerson(): void {
    if (this.form.valid) {
      this.personService.create(this.person)
      .then((personDTO) => {
        console.log(personDTO)
        this.router.navigate(['/login'])
      })
      .catch((err) => console.log(err))
    }
  }



}
