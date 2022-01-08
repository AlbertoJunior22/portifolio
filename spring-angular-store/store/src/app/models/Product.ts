export class Product {

    id: number
    name: string
    price: number
    available: boolean
    qtd: number

    constructor(init?: Partial<Product>){
        Object.assign(this, init)
    }
    
}