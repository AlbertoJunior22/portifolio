import { HttpClient } from "@angular/common/http";
import { firstValueFrom } from "rxjs";
import { environment } from '../../environments/environment';
import { IBaseService } from "./base.service.interface";

export class BaseService<R> implements IBaseService<R> {

    private baseServer = environment.baseServer
    baseService: string

    constructor(protected http: HttpClient , basePath: string) {
        this.baseService = `${this.baseServer}/${basePath}`
    }

    async retrieveById(id: number): Promise<R> {
        const request = this.http.get<R>(`${this.baseService}/${id}`)
        return await firstValueFrom<R>(request)
    }

    async retrieveAll(): Promise<Array<R>> {
        const request = this.http.get<Array<R>>(this.baseService)
        return await firstValueFrom<Array<R>>(request)
    }

    async create(data: R): Promise<R> {
        const request = this.http.post<R>(this.baseService, data)
        return await firstValueFrom<R>(request)
    }

    async update(data: R): Promise<R> {
        const request = this.http.put<R>(this.baseService, data)
        return await firstValueFrom<R>(request)
    }

    async delete(id: number): Promise<any> {
        const request = this.http.delete<any>(`${this.baseService}/${id}`)
        return await firstValueFrom<any>(request)
    }
}