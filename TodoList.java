/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;

import java.util.*;

public class TodoList {

    static class Task {
        String title;
        Task next;

        Task(String title) {
            this.title = title;
        }
    }

    static class TaskList {
        Task head;

        void add(String title) {
            Task newTask = new Task(title);
            if (head == null) {
                head = newTask;
            } else {
                Task current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newTask;
            }
            System.out.println("Added: " + title);
        }

        void delete(String title) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            if (head.title.equals(title)) {
                head = head.next;
                System.out.println("Deleted: " + title);
                return;
            }
            Task current = head;
            while (current.next != null && !current.next.title.equals(title)) {
                current = current.next;
            }
            if (current.next == null) {
                System.out.println("Task not found.");
            } else {
                current.next = current.next.next;
                System.out.println("Deleted: " + title);
            }
        }

        void show() {
            if (head == null) {
                System.out.println("No tasks.");
                return;
            }
            System.out.println("Tasks:");
            Task current = head;
            while (current != null) {
                System.out.println("- " + current.title);
                current = current.next;
            }
        }

        boolean find(String title) {
            Task current = head;
            while (current != null) {
                if (current.title.equals(title)) return true;
                current = current.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList list = new TaskList();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu: 1-Add | 2-Delete | 3-Show | 4-Search | 5-Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Task to add: ");
                    list.add(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Task to delete: ");
                    list.delete(sc.nextLine());
                    break;
                case "3":
                    list.show();
                    break;
                case "4":
                    System.out.print("Search task: ");
                    System.out.println(list.find(sc.nextLine()) ? "Found!" : "Not found.");
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}

