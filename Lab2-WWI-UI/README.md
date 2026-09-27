# COMP267 Lab 2 — Wide World Importers Angular interface

## Run

Install Node.js 20.19+ or 22.12+ and run `npm install`, then `npm start`. Open http://localhost:4200. For a production build, run `npm run build`.

The CLI configuration uses CSS, SSR, and zoneless change detection. The three routes are `/`, `/customers`, and `/orders`. Use the navigation links to switch pages. Customer search matches names; order search matches customer names or order IDs. Both searches ignore case and surrounding whitespace. An empty search shows every record.

## Where to read the code

- `src/app/app.ts`, `app.html`, `app.css`: shared page layout and router directives.
- `src/app/app.routes.ts`: maps the URLs to page components.
- `src/app/home/`: supplied welcome page.
- `src/app/customers/customers.ts`: `Customer` interface, JSON data signal, search signal, and name filter.
- `src/app/orders/orders.ts`: `Order` interface, JSON data signal, search signal, and name/ID filter.
- Each component's `.html` binds signals to the input and renders results with Angular `@for`; each `.css` contains only that page's supplied styles.
- `src/app/app.config.ts` enables routing, hydration, and zoneless change detection; `main.server.ts` and `server.ts` enable SSR.

The original instructor datasets are copied into the corresponding component folders. No database or external API is needed.

## Instructor demo checklist

Run `npm start`; visit Home, Customers, Orders; search a customer name, an order name, and an order ID; clear both searches to show all results. The footer displays Md Alamgir Hossain. Submit this project folder as a zip. The live demonstration must be done by the student.
