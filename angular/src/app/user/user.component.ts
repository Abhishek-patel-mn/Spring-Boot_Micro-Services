import { Component, OnInit, OnDestroy } from '@angular/core';
import { DataServiceService } from '../shared-service/data-service.service';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Rx';
import 'rxjs/Rx';

@Component({
	selector: 'app-user',
	templateUrl: './user.component.html',
	styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit, OnDestroy {
	userdata: any = [];
	numberObservableSubscription: Subscription;

	constructor(public ds: DataServiceService) { }

	ngOnInit() {

		this.ds.getData("public/getAllUsers")
			.subscribe(data => {
				console.log("inside component");
				console.log(data);
				this.userdata = data['data'];
			});

		const myNumbers = Observable.interval(1000);
		this.numberObservableSubscription = myNumbers.map(number => number + 5).subscribe(
			num => console.log(num)
		);

	}

	ngOnDestroy() {
		this.numberObservableSubscription.unsubscribe();
	}

}
