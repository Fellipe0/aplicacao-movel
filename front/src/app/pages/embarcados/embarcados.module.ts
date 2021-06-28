import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { EmbarcadosPageRoutingModule } from './embarcados-routing.module';

import { EmbarcadosPage } from './embarcados.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    EmbarcadosPageRoutingModule
  ],
  declarations: [EmbarcadosPage]
})
export class EmbarcadosPageModule {}
