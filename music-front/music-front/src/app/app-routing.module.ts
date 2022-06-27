import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DiscoverComponent } from './discover/discover.component';
import { HomeComponent } from './home/home.component';
import { LikedSongsComponent } from './liked-songs/liked-songs.component';
import { LoginComponent } from './login/login.component';
import { MyPlayListsComponent } from './my-play-lists/my-play-lists.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { SongsComponent } from './songs/songs.component';

const routes: Routes = [  
{ path: 'home', component: HomeComponent },
{ path: 'login', component: LoginComponent },
{ path: 'register', component: RegisterComponent },
{ path: 'register', component: RegisterComponent },
{ path: 'profile', component: ProfileComponent },
{ path: 'search', component: SongsComponent },
{ path: 'liked', component: LikedSongsComponent },
{ path: 'dicover', component: DiscoverComponent },
{ path: 'myPlaylists', component: MyPlayListsComponent },
{ path: 'playlists/:id', component: PlaylistComponent },
{ path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
