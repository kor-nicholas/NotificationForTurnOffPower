import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    iconComponent: { name: 'cil-speedometer' },
    badge: {
      color: 'info',
      text: 'NEW'
    }
  },
  {
    title: true,
    name: 'User'
  },
  {
    name: 'Settings',
    url: '/dashboard',
    iconComponent: { name: 'cil-star' },
    children: [
      {
        name: 'Change',
        url: '/dashboard'
      },
      {
        name: 'Set Telegram bot',
        url: '/dashboard'
      },
      {
        name: 'Delete',
        url: '/dashboard'
      }
    ]
  },
];
