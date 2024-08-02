import { Component } from '@angular/core';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {BreadcrumbComponent} from "./breadcrumb/breadcrumb.component";
import {SideBarComponent} from "./side-bar/side-bar.component";
import {NgOptimizedImage} from "@angular/common";
import {EventFormComponent} from "../../../features/components/event-form/event-form.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    HeaderComponent,
    FooterComponent,
    BreadcrumbComponent,
    SideBarComponent,
    NgOptimizedImage,
    EventFormComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
