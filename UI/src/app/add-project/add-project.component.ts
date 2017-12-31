import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Project } from '../project';
import { UserService } from '../user.service';
import { User } from '../user';
import { ProjectService } from '../project.service';


@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.css']
})
export class AddProjectComponent implements OnInit {

  addProjectForm: FormGroup;
  editProjectFlag: boolean = false;

  users: User[];
  projects: Project[];
  project: Object = {};

  constructor(private userService: UserService,private projectService: ProjectService) { 
  }

  ngOnInit() {
  	this.getUsers();
  	this.getProjects();
  }

  getUsers(): void {
    this.userService.getUsers()
    .subscribe(users => this.users = users)
  }

  getProjects(): void{
  	 this.projectService.getProjects()
    .subscribe(projects => this.projects = projects)
  }

  addProject(project: Project): void{
  	this.projectService.addProject(project)
      .subscribe(project => {
        this.projects.push(project);
      });
  }

  onSubmit(project: Project): void{
    console.log(this.editProjectFlag);
    if(this.editProjectFlag){
      this.editProjectFlag = false;
      /*this.users = this.users.filter(u => u !== user);
      this.userService.updateUser(user).subscribe(
        user => {this.users.push(user);})
*/
    }else{
      this.addProject(project);
    }
  }

}
