// Render all three pages on the server when they are requested directly.
import { RenderMode, ServerRoute } from '@angular/ssr';
export const serverRoutes: ServerRoute[] = [{ path: '**', renderMode: RenderMode.Server }];
