import { Component, signal } from '@angular/core';
import customerData from './customers.json';

// An interface describes one JSON object and gives TypeScript type checking.
interface Customer {
  CustomerID: number;
  CustomerName: string;
  City: string;
  PhoneNumber: string;
}

@Component({selector: 'app-customers', standalone: true, templateUrl: './customers.html', styleUrl: './customers.css'})
export class Customers {
  // The signal holds the supplied in-memory JSON array; calling customers() reads it.
  customers = signal<Customer[]>(customerData);
  // The input event in customers.html changes this signal whenever the user types.
  searchTerm = signal('');

  filteredCustomers(): Customer[] {
    // trim() removes surrounding spaces; toLowerCase() makes matching ignore case.
    const filter = this.searchTerm().trim().toLowerCase();
    // filter() tests each customer and returns a NEW array of matching entries.
    // includes('') is true for every name, so an empty search shows all customers.
    const filteredCustomers = this.customers().filter(
      c => c.CustomerName.toLowerCase().includes(filter)
    );
    return filteredCustomers;
  }
}
