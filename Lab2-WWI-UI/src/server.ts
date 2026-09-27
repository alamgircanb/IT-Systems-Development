// Angular's Node request handler is used when the SSR output is served.
import { AngularNodeAppEngine, createNodeRequestHandler, writeResponseToNodeResponse } from '@angular/ssr/node';
import express from 'express';
import { fileURLToPath } from 'node:url';
import { dirname, resolve } from 'node:path';

const serverDirectory = dirname(fileURLToPath(import.meta.url));
const browserDirectory = resolve(serverDirectory, '../browser');
const app = express();
const angularApp = new AngularNodeAppEngine();

app.use(express.static(browserDirectory, { maxAge: '1y', index: false, redirect: false }));
app.use((request, response, next) => {
  angularApp.handle(request)
    .then(result => result ? writeResponseToNodeResponse(result, response) : next())
    .catch(next);
});

if (process.env['PORT']) app.listen(Number(process.env['PORT']));
export const reqHandler = createNodeRequestHandler(app);
