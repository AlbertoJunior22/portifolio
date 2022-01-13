import { Person } from "./Person"

export class Credentials {

    person: Person
    tokenType: string
    token: string

    constructor(init?: Partial<Credentials>) {
        Object.assign(this, init)
    }
    
}