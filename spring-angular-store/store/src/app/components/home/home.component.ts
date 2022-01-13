import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { LogUtil } from 'src/app/Util/LogUtil';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  log: LogUtil = new LogUtil('HomeComponent')

  constructor(private authService: AuthService, private router: Router) { 

    this.authService.verifyAuthentication()
    .then(() => this.log.info('Authenticated'))
    .catch(err => {
      this.log.httpError(err)
      this.router.navigate(['/ login'])
    })

  }

  ngOnInit(): void {
  }

}
