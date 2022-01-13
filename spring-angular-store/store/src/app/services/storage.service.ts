import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class StorageService {

    save(key: string, object: any) {
        localStorage.setItem(key, JSON.stringify(object))
    }

    retrieve<T>(key: string): T | null{
        const data = localStorage.getItem(key)
        if (data)
            return JSON.parse(data)
        return null
    }

    remove<T>(key: string): T | null {
        const data = this.retrieve<T>(key)
        localStorage.removeItem(key)
        return data
    }

    append(key: string, field: {property: string, value: any}) {
        const data = this.retrieve(key) as any
        if (data) {
            data[field.property] = field.value
            this.save(key, data)
        } else {
            const newData: any = {}
            newData[field.property] = field.value
            this.save(key, newData)
        }
    }

    removeProperty(key: string, propertyName: string): any {
        const data = this.retrieve(key) as any
        if (data) {
            const propValue = data[propertyName]
            delete data[propertyName]
            this.save(key, data)
            return propValue
        }
        return null
    }
}