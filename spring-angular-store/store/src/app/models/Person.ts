import { Address } from "./Address"

export class Person {

    id: number
    login: string
    email: string
    emailConfirmation: string
    password: string
    passwordConfirmation: string
    name: string
    birthday: Date
    identity: string
    address: Array<Address>

    constructor(init?:Partial<Address>) {
        Object.assign(this, init)
    }
}