import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePhotoComponent } from './create-photo/create-photo.component';
import { PhotoDetailsComponent } from './photo-details/photo-details.component';
import { PhotoListComponent } from './photo-list/photo-list.component';
import { MainComponent } from './views/main.component';
import { PictureComponent } from './views/picture.component';
import { ViewimageComponent } from './views/viewimage.component';
//import { UpdatePhotoComponent } from './update-photo/update-photo.component';

const routes: Routes = [
  { path: '', component: PhotoListComponent },
  { path: 'photos', component: PhotoListComponent },
  { path: 'create-photo', component: CreatePhotoComponent },
  { path: 'photo-details/:id', component: PhotoDetailsComponent },
 // { path: 'update-employee/:id', component: UpdateEmployeeComponent },
  { path: 'main', component: MainComponent },
  { path: 'picture', component: PictureComponent },
  { path: 'image/:postId', component: ViewimageComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
