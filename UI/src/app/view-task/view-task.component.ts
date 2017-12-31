import { Component, OnInit } from '@angular/core';

import { Task } from '../task';
import { TaskService } from '../task.service';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {

  projects: Project[];

  constructor(private taskService: TaskService, private projectService: ProjectService) { }

  ngOnInit() {
  	this.getProjects();
  }

  getProjects(): void{
   this.projectService.getProjects()
  .subscribe(projects => this.projects = projects)
  }

}
