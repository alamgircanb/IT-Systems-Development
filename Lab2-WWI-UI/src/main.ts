// Browser entry point: starts the standalone root component with app providers.
import { bootstrapApplication } from '@angular/platform-browser';
import { App } from './app/app';
import { appConfig } from './app/app.config';

/*
 * Starts the standalone Angular application in the browser.
 * App is the root component. appConfig provides application-wide services such as routing,
 * zoneless change detection, and client hydration.
 */
bootstrapApplication(App, appConfig).catch(error => console.error(error));
