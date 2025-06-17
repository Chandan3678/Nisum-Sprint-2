// Enum for Task Status
enum Status {
  Pending,
  Completed,
  Cancelled
}

// Interface for a Task
interface Task {
  id: number;
  name: string;
  status: Status;
  details?: string;   // Optional property
}

// Type Alias for TaskFilter (union type)
type TaskFilter = 'all' | 'pending' | 'completed';

// Generic class for managing collections
class Collection<T extends { id: number }> {
  private items: T[] = [];

  add(item: T): void {
    this.items.push(item);
  }

  getById(id: number): T | undefined {
    return this.items.find(item => item.id === id);
  }

  removeById(id: number): void {
    this.items = this.items.filter(item => item.id !== id);
  }

  list(): T[] {
    return this.items;
  }

  filter(predicate: (item: T) => boolean): T[] {
    return this.items.filter(predicate);
  }
}

// Task Manager extending Collection
class TaskManager extends Collection<Task> {
  
  // Mark task as completed
  completeTask(id: number): void {
    const task = this.getById(id);
    if(task) {
      task.status = Status.Completed;
    }
  }

  // Filter tasks based on filter string (union type example)
  filterTasks(filter: TaskFilter): Task[] {
    switch(filter) {
      case 'pending':
        return this.filter(task => task.status === Status.Pending);
      case 'completed':
        return this.filter(task => task.status === Status.Completed);
      case 'all':
      default:
        return this.list();
    }
  }
}

// Type Guard function (custom predicate)
function isTask(obj: any): obj is Task {
  return obj && typeof obj.id === 'number' && typeof obj.name === 'string';
}

// Usage example

const manager = new TaskManager();

// Typecasting with 'as' for explicit type
manager.add({ id: 1, name: 'Learn TypeScript', status: Status.Pending } as Task);
manager.add({ id: 2, name: 'Build Todo App', status: Status.Pending } as Task);

// Type Guard Usage
const unknownTask: any = { id: 3, name: 'Test Task', status: Status.Pending };

if (isTask(unknownTask)) {
  manager.add(unknownTask);
}

// Complete a task
manager.completeTask(1);

// List all tasks
console.log('All Tasks:', manager.list());

// Filter completed tasks
console.log('Completed Tasks:', manager.filterTasks('completed'));

// Tuple example
const taskTuple: [number, string, Status] = [4, 'Write tests', Status.Pending];

// Any type example
let anything: any = "Could be anything";
anything = 25;

// Void example: function that returns nothing
function logMessage(message: string): void {
  console.log(message);
}
logMessage("Task Manager is running");

// Never example: function that throws an error
function throwError(message: string): never {
  throw new Error(message);
}

// Optional chaining example (nullable types)
const maybeTask: Task | null = manager.getById(5);
console.log(maybeTask?.name ?? 'Task not found');
