export class Address {

    id: number
    street: string
    number: number
    district: string
    city: string
    zipCode: string

    constructor(init?:Partial<Address>){
        Object.assign(this, init)
    }
}