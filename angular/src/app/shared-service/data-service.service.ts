import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class DataServiceService {
	data: any;
	constructor(public http: HttpClient) { }

	getData(url) {
		return this.http.get(url)
			.map((res: Response) => {
				console.log(res);
				return res;
			})
			.catch((error: Response) => {
				console.log(error.status);
				return Observable.throw(error);
			});;
	}
}
