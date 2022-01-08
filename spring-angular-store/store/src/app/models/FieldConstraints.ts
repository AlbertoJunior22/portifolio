export class FieldConstraints {

    passwordMinLength: number
    loginMinLength: number
    nameMinLength: number

    constructor(init?: Partial<FieldConstraints>) {
        Object.assign(this, init)
    }
    
}