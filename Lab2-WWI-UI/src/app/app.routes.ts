import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Customers } from './customers/customers';
import { Orders } from './orders/orders';

// The first route matches /; the other paths match the header navigation links.
export const routes: Routes = [
  { path: '', component: Home, pathMatch: 'full' },
  { path: 'customers', component: Customers },
  { path: 'orders', component: Orders },
  { path: '**', redirectTo: '' }
];
