package bo.edu.ucb.todo.dto;

import java.util.*;

public class TaskDto {
    private Integer taskId;
    private String description;
    private String date;
    private String label;
    private boolean isDone;

    public TaskDto() {
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }
    public Integer getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            ", description='" + getDescription() + "'" +
            ", date='" + getDate() + "'" +
            ", label='" + getLabel() + "'" +
            
            "}";
    }


}