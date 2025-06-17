// File: app.js

// Symbol for unique task ID
const ID = Symbol('id');

// Class definition using ES6
class Task {
  constructor(name, completed = false) {
    this.name = name;
    this.completed = completed;
    this[ID] = Task.generateId();
  }

  static generateId() {
    return Math.floor(Math.random() * 10000);
  }

  toggle() {
    this.completed = !this.completed;
  }
}

// Module export
export class TodoApp {
  constructor() {
    this.tasks = new Set(); // Using Set
  }

  addTask = (name = 'Untitled Task') => {
    const task = new Task(name);
    this.tasks.add(task);
    return task;
  };

  deleteTask = (taskToDelete) => {
    this.tasks.delete(taskToDelete);
  };

  listTasks = () => {
    for (const task of this.tasks) {
      console.log(`${task.name} - ${task.completed ? '✅' : '❌'}`);
    }
  };

  toggleTaskCompletion = (taskToToggle) => {
    taskToToggle.toggle();
  };

  getTasksArray = () => Array.from(this.tasks); // Array.from
}

// Generator function to yield tasks
export function* taskGenerator(tasks) {
  for (const task of tasks) {
    yield task;
  }
}