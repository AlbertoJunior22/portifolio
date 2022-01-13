import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ApplicationConstants } from "../constants/ApplicationConstants";
import { Credentials } from "../models/Credentials";
import { StorageService } from "../services/storage.service";

@Injectable()
export class SessionHttpInterceptor implements HttpInterceptor {

    constructor(private storage: StorageService) {

    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const session = this.storage.retrieve<Credentials>(ApplicationConstants.SESSION_KEY)
        if (session) {
            const newReq = req.clone({setHeaders: {'Authorization': `${session.tokenType} ${session.token}`}})
            return next.handle(newReq)
        } else {
            return next.handle(req)
        }
    }

}