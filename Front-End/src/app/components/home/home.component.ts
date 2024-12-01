import { Component } from '@angular/core';
import { NavbarComponent } from "./template/navbar/navbar.component";
import { RouterOutlet } from '@angular/router';
import { SidebarComponent } from "./template/sidebar/sidebar.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NavbarComponent, SidebarComponent, RouterOutlet],
  templateUrl: './home.component.html'
})
export class HomeComponent {

  ngAfterViewInit(): void {
    window.addEventListener('DOMContentLoaded', event => {

      const sidebarToggle = document.body.querySelector('#sidebarToggle');
      if (sidebarToggle) {
          sidebarToggle.addEventListener('click', event => {
              event.preventDefault();
              document.body.classList.toggle('sb-sidenav-toggled');
              localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled').toString());
          });
      }
  });
  }

}
