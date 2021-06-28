import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnInit{
  public user: String = "Felipe e Paulo";

  public appPages = [
    { title: 'Ambientes', url: '/ambientes', icon: 'mail-sharp' },
    { title: 'Embarcado', url: '/embarcados', icon: 'hardware-chip' },
  ];

  constructor(
    private authService: AuthService,
    private router: Router
    ) { }
    
  ngOnInit(): void {
  }

  deslogar() {
    this.authService.logout();
    this.router.navigateByUrl('login');
  }

  get isLogged():boolean {
    return this.authService.authResponse != null
  }
}
