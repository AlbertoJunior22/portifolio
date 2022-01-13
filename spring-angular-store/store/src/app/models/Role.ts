export class Role {

    id: number
    profile: string
    removible: boolean

    constructor(init?: Partial<Role>) {
        Object.assign(this, init)
    }

}