import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/auth/auth.guard';

import { EmbarcadosPage } from './embarcados.page';

const routes: Routes = [
  {
    path: '',
    component: EmbarcadosPage, canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EmbarcadosPageRoutingModule {}
