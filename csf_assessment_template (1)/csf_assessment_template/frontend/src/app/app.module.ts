import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { WebcamModule } from 'ngx-webcam';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePhotoComponent } from './create-photo/create-photo.component';
import { PhotoDetailsComponent } from './photo-details/photo-details.component';
import { PhotoListComponent } from './photo-list/photo-list.component';
import { UploadService } from './upload.service';
import { MainComponent } from './views/main.component';
import { PictureComponent } from './views/picture.component';
import { ViewimageComponent } from './views/viewimage.component';

@NgModule({
  declarations: [
    AppComponent, MainComponent, PictureComponent, CreatePhotoComponent, 
    PhotoDetailsComponent, PhotoListComponent, ViewimageComponent,
  ],  
  imports:[
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    WebcamModule,
    BrowserAnimationsModule,
    // ServiceWorkerModule.register('ngsw-worker.js', {
    //   enabled: !isDevMode(),
    //   // Register the ServiceWorker as soon as the application is stable
    //   // or after 30 seconds (whichever comes first).
    //   registrationStrategy: 'registerWhenStable:30000',
    // }),
  ],
   providers: [UploadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
