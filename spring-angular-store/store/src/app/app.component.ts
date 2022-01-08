import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router, RoutesRecognized } from '@angular/router';
import { filter, map, startWith, Subscription } from 'rxjs';
import { FieldsConstraintsConfiguration } from './services/fields.constraints.configuration.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {

  routeSub: any
  routerSub: any
  pageTitle = 'Register';

  constructor(private route: ActivatedRoute, private router: Router,
    private fieldsConstraintsConfiguration: FieldsConstraintsConfiguration) {
      this.fieldsConstraintsConfiguration.getConfiguration()
  }

  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.routeSub = this.route.data.subscribe(r => {
      console.log(r)
    })

    this.routerSub = this.router.events.subscribe(evt => {
      if (evt instanceof RoutesRecognized) {
        let data = evt as any
        this.pageTitle = data.state.root.firstChild.data[0]
      }
    })
  }

  ngOndestroy() {
    this.routeSub.unsubscribe()
    this.routerSub.unsubscribe()
  }

  
}
