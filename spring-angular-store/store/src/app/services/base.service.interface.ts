export interface IBaseService<R> {
    retrieveById(id: number): Promise<R>
    retrieveAll(): Promise<Array<R>>
    create(data: R): Promise<R>
    update(data: R): Promise<R>
    delete(id: number): Promise<any>
}