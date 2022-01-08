import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { FieldConstraints } from "../models/FieldConstraints";
import { FieldsConstraintsConfiguration } from "./fields.constraints.configuration.service";

@Injectable(
    {providedIn: 'root'}
)
export class ConfigResolver implements Resolve<FieldConstraints> {

    constructor(private fieldConfigurationService: FieldsConstraintsConfiguration) {

    }

    async resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<FieldConstraints> {
        return await this.fieldConfigurationService.getConfiguration()
    }

}