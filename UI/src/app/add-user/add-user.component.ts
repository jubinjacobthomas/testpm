import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { User } from '../user';
import { UserService } from '../user.service';
import { HeroService } from '../hero.service';

import { USERS } from '../mock-user';


@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  addUserForm: FormGroup;
  editUserFlag: boolean =false;
  users: User[];

  user: Object = {};

  constructor(private userService: UserService) { 
    }

  ngOnInit() {
    //this.getHeroes();
    this.getUsers();
  }

  onSubmit(user: User): void{
    console.log(this.editUserFlag);
    if(this.editUserFlag){
      this.editUserFlag = false;
      this.users = this.users.filter(u => u !== user);
      this.userService.updateUser(user).subscribe(
        user => {this.users.push(user);})

    }else{
      this.addUser(user);
    }
  }

  editUser(user: User): void{
    this.editUserFlag = true;
    this.user = user;
  }

  getUsers(): void {
    this.userService.getUsers()
    .subscribe(users => this.users = users)
  }

  addUser(user: User): void{
    this.userService.addUser(user)
      .subscribe(user => {
        this.users.push(user);
      });
  }

  deleteUser(user: User): void{
    console.log(" delete ");
    this.users = this.users.filter(u => u !== user);
    this.userService.deleteUser(user.userId).subscribe();
  }

}
