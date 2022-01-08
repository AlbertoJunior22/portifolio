export class Login {

    login: string
    password: string

    constructor(init?: Partial<Login>) {
        Object.assign(this, init)
    }
}