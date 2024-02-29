package com.kdang.task.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use database auto-increment
    @Column(name = "task_id")
        private long taskID;

    @Column(name = "name")
        private String name;

    @Column(name = "description")
        private String description;

    @CreationTimestamp // Get current timestamp from VM and insert in database
    @Column(name = "create_date")
        private Date createDate;

    @Column(name = "due_date")
        private Date dueDate;

    @Column(name = "completed")
        private boolean completed;

    @Column(name = "assigned_to")
        private int assignedTo;

    @Column(name = "create_by")
        private int createBy;

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
