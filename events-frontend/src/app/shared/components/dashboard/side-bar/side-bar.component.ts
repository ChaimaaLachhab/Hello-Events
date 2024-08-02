import { Component } from '@angular/core';
import {NgClass, NgForOf} from "@angular/common";

@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [
    NgForOf,
    NgClass
  ],
  templateUrl: './side-bar.component.html',
  styleUrl: './side-bar.component.scss'
})
export class SideBarComponent {
  menuItems = [
    { label: 'Dashboard', icon: '/assets/public/layout-11@2x.png' },
    { label: 'Calendar', icon: '/assets/public/calendar@2x.png' },
    { label: 'My Events', icon: '/assets/public/folder@2x.png' },
    { label: 'Teams', icon: '/assets/public/meeting@2x.png' },
    { label: 'Messages', icon: '/assets/public/f-chat@2x.png' },
    { label: 'Setting', icon: '/assets/public/settings-gear.svg' },
  ];

  activeItem = this.menuItems[0];

  activateLink(item: { label: string; icon: string; }) {
    this.activeItem = item;
  }
}
