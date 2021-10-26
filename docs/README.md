# Luke User Guide

Luke is an interactive desktop application that serves as a task manager that operates in the Command Line Interface.
- [**Quick Start**](#Quick-Start)
- [**Features**](#Features)
    - **Adding a Todo task: `todo`**
    - **Adding a Deadline task: `deadline`**
    - **Adding an Event task: `event`**
    - **Listing all tasks: `list`**
    - **Checking off a task as done: `done`**
    - **Finding a task: `find`**
    - **Deleting a task: `delete`**
    - **Exiting the program: `bye`**
    - **Storing the data**
- **Command Summary**

---------------

## Quick Start

1. Ensure you have installed Java `11` or above on your computer.
2. Download the `ip.jar` file from v0.2 from this [link](https://github.com/williamlamjy/ip/releases)
3. Note down where you have downloaded the `ip.jar` file and **copy the filepath**.
4. Open your terminal and navigate to your `ip.jar` file by **pasting the filepath**.
5. Enter the command `java -jar iP.jar` to run Luke.
6. The corresponding `welcome message` will be displayed.

## Features



### Adding a Todo task: `todo`

Adds a task of type `todo` to the task list. A todo task contains a **description**.

Format: `todo DESCRIPTION`

Example: `todo CG2027 tutorial`

Outcome:
```text
todo CG2027 tutorial
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Noted! I have added this task:
[T][ ] CG2027 tutorial
Now you have 8 tasks in your list.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
```
-------

### Adding a Deadline task: `deadline`

Adds a task of type `deadline` to the task list. A deadline task contains a **description** and **deadline date**.

The **deadline date** must have a `YYYY-MM-DD` format.

Format: `deadline DESCRIPTION/DEADLINE_DATE`

Example: `deadline CG2027 exam/2021-12-01`

Outcome:
```text
deadline CG2027 exam/2021-12-01
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Noted! I have added this task:
[D][ ] CG2027 exam(by: Dec 01 2021)
Now you have 9 tasks in your list.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
```
------

### Adding an event task: `event`

Adds a task of type `event` to the task list. An event task contains a **description** and **duration**.

Format: `event DESCRIPTION/DURATION`

Example: `event afternoon nap/3-4pm`

Outcome:
```text
event afternoon nap/3-4pm
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Noted! I have added this task:
[E][ ] afternoon nap(at: 3-4pm)
Now you have 10 tasks in your list.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
```

------


### Listing all current tasks: `list`

Shows a list of all the current tasks.

Format: `list`

Outcome:
```text
list
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Okay! Here are your current tasks:
1. [T][ ] CG2027 tutorial
2. [D][ ] CG2027 exam(by: Dec 01 2021)
3. [E][ ] afternoon nap(at: 3-4pm)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

```

-------

### Checking off a task as done: `done`

Checks off a task as completed.

Format: `done TASK_NUMBER`

- `TASK_NUMBER` is the task number shown on the list.

Example: `done 3`

Outcome:
```text
done 3
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Nice! I have marked this task as done:
[E][X] afternoon nap(at: 3-4pm)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

```

------

### Finding a task: `find`

Shows a list of tasks that contains the `SEARCH_QUERY` keyed in.

Format: `find SEARCH_QUERY`

- `SEARCH_QUERY` can be any word or phrase.

Example: `find exam`

Outcome:
```text
find exam
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Here's what I have found!
1.[D][ ] CG2027 exam(by: Dec 01 2021)
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
```

-----

### Deleting a task: `delete`

Deletes a task from the list.

Format: `delete TASK_NUMBER`

- `TASK_NUMBER` is the task number shown on the list.

Example: `delete 1`

Outcome:
```text
delete 1
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Noted! I have deleted this task:
[T][ ] CG2027 tutorial
Now you have 2 tasks in your list
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

```

-----

### Exiting the program: `bye`

Terminates the program and shows the goodbye message.

Format: `bye`

Outcome:
```text
bye
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Bye! Hope to see you soon
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Process finished with exit code 0
```

-----

### Storing the data

Luke **automatically stores the data** of the task list
and will **load** up the task list stored in the last session for your current session.


---------


## Command Summary

Action | Format | Examples
 ---- | -------|----------
Add todo | `todo DESCPRIPTION` | `todo CG2027 exam`
Add deadline | `deadline DESCPRIPTION /DEADLINE_DATE` | `deadline CS2113 tutorial /2021-08-01`
Add event | `event DESCPRIPTION /DURATION` |`event CG2027 lecture /3-5pm`
List | `list` | `list`
Done | `done TASK_NUMBER` | `done 1`
Find | `find KEYWORD` | `find Assignment`
Delete | `delete TASK_INDEX` | `delete 2`
Exit | `bye` | `bye`

-------