// File: main.js

import { TodoApp, taskGenerator } from './app.js';

const app = new TodoApp();

const [task1, task2] = [
  app.addTask('Learn ES6'),
  app.addTask('Build a ToDo App')
];

// Using Destructuring Assignment and for...of
for (const task of taskGenerator(app.getTasksArray())) {
  console.log(`Task: ${task.name}`);
}

app.toggleTaskCompletion(task2);
app.listTasks();

// Spread operator example
const moreTasks = [
  new Task('Deploy App'),
  new Task('Write Tests')
];

app.tasks = new Set([...app.tasks, ...moreTasks]);

app.listTasks();

// Using Object.assign and Object.is
const taskCopy = Object.assign({}, task1);
console.log('Task is same:', Object.is(task1, taskCopy)); // false

// Using Map and WeakMap
const taskMap = new Map();
taskMap.set(task1, 'Important');
console.log(taskMap.get(task1));

const weakTaskMap = new WeakMap();
weakTaskMap.set(task2, { notes: 'Do by Monday' });

// Using Array.of
console.log(Array.of(1, 2, 3));

// Using const/let
const doneTasks = [...app.tasks].filter(t => t.completed);
let total = doneTasks.length;
console.log(`Completed: ${total}`);
