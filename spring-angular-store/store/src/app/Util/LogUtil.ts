import { HttpErrorResponse } from "@angular/common/http"

export class LogUtil {

    constructor(private className: string){}

    info(info: string) {
        console.info(`${this.className}:\n${info}`)
    }

    error(err: string) {
        console.error(`${this.className}:\n${err}`)
    }

    warning(warn: string) {
        console.warn(`${this.className}:\n${warn}`)
    }

    log(log: string) {
        console.log(`${this.className}:\n${log}`)
    }

    debug(debug: string) {
        console.debug(`${this.className}:\n${debug}`)
    }

    httpError(http: HttpErrorResponse) {
        console.error(`${this.className}:\n
        Http request error.\n
        Status: ${http.status}\n
        Url: ${http.url}\n
        Success: ${http.ok}`)
    }

}