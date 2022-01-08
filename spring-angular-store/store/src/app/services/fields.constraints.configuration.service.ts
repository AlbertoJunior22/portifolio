import { Injectable } from "@angular/core";
import { FieldConstraints } from "../models/FieldConstraints";
import { ConstraintsService } from "./constraints.service";

@Injectable({
    providedIn: 'root'
})
export class FieldsConstraintsConfiguration {

    private configuration: FieldConstraints

    async getConfiguration(): Promise<FieldConstraints> {
        if (!this.configuration)
            this.configuration = await this.service.retrieveFieldConstraints()
        return this.configuration
    }

    constructor(private service: ConstraintsService) {

    }
}