import { Component, signal } from '@angular/core';

// Import the order records from the local JSON file.
import orderData from './orders.json';

/*
 * Defines the required structure of each order object.
 * The property names and data types match the records in orders.json.
 */
interface Order {
  OrderID: number;
  OrderDate: string;
  CustomerName: string;
  TotalAmount: number;
}

@Component({
  selector: 'app-orders',
  standalone: true,
  templateUrl: './orders.html',
  styleUrl: './orders.css',
})
export class Orders {
  /*
   * Stores the imported order records in an Angular signal.
   * Use orders() to read the current array.
   */
  orders = signal<Order[]>(orderData);

  /*
   * Stores the text entered in the search field.
   * The input event in orders.html updates this signal.
   */
  searchTerm = signal('');

  /*
   * Returns orders matching the entered customer name or order ID.
   * When the search field is empty, it returns all orders.
   */
  filteredOrders(): Order[] {
    // Remove extra spaces and convert the search text to lowercase.
    const query = this.searchTerm().trim().toLowerCase();

    /*
     * If query contains text, filter the order list.
     * Otherwise, return the complete order list.
     */
    const filteredOrders = query
      ? this.orders().filter(
          (order) =>
            // Compare the customer name without case sensitivity.
            order.CustomerName.toLowerCase().includes(query) ||
            // Convert the numeric OrderID into text before comparing it.
            order.OrderID.toString().includes(query),
        )
      : this.orders();

    return filteredOrders;
  }
}