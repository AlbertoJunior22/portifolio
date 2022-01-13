import { Role } from "./Role"

export class Profile {

    id: number
    profile: string
    roles: Array<Role>

    constructor(init?: Partial<Profile>) {
        Object.assign(this, init)
    }
}