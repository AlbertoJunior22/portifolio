import { Address } from "./Address"
import { Profile } from "./Profile"

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
    profile: Profile

    constructor(init?:Partial<Address>) {
        Object.assign(this, init)
    }
}