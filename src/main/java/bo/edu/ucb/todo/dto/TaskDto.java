package bo.edu.ucb.todo.dto;

import java.util.*;

public class TaskDto {
    public Integer taskId;
    public String description;
    public Date date;
    List<LabelDto> labels;    
}