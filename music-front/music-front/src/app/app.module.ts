import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SongsComponent } from './songs/songs.component';
import { CreateComponent } from './create/create.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LikedSongsComponent } from './liked-songs/liked-songs.component';
import { DiscoverComponent } from './discover/discover.component';
import { MyPlayListsComponent } from './my-play-lists/my-play-lists.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    SongsComponent,
    CreateComponent,
    PlaylistComponent,
    ProfileComponent,
    LikedSongsComponent,
    DiscoverComponent,
    MyPlayListsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
