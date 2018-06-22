import { Component } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private title = 'ATM';
  private serverUrl = 'https://localhost:8443/atm/session'
  private stompClient;

  constructor(){
    this.initializeWebSocketConnection();
  }
  
  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/valid", (message) => {
        if(message.body) {
          console.log(message.body);
          if(message.body === 'sessionDestroyed')
            alert('Session timeout..'); 
            location.href = '/atm/logout';           
        }
      });
    });
  }

}
