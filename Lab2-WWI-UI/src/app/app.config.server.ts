// Server rendering uses the same routes and app configuration as the browser.
import { mergeApplicationConfig, ApplicationConfig } from '@angular/core';
import { provideServerRendering, withRoutes } from '@angular/ssr';
import { appConfig } from './app.config';
import { serverRoutes } from './app.routes.server';

const serverConfig: ApplicationConfig = { providers: [provideServerRendering(withRoutes(serverRoutes))] };
export const config = mergeApplicationConfig(appConfig, serverConfig);
