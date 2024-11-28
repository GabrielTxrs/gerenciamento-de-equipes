import { Component } from '@angular/core';
import { NavbarComponent } from "./template/navbar/navbar.component";
import { SidebarComponent } from "./template/sidebar/sidebar.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NavbarComponent, SidebarComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  ngAfterViewInit(): void {
    window.addEventListener('DOMContentLoaded', event => {

      // Toggle the side navigation
      const sidebarToggle = document.body.querySelector('#sidebarToggle');
      if (sidebarToggle) {
          // Uncomment Below to persist sidebar toggle between refreshes
          // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
          //     document.body.classList.toggle('sb-sidenav-toggled');
          // }
          sidebarToggle.addEventListener('click', event => {
              event.preventDefault();
              document.body.classList.toggle('sb-sidenav-toggled');
              localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled').toString());
          });
      }
  });
  }

}
