package bo.edu.ucb.todo.api;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import bo.edu.ucb.todo.dto.*;
@RestController
class TodoApi {

    private List<TaskDto> tasks = new ArrayList<>();

    @GetMapping("/api/v1/task")
    public ResponseDto<List<TaskDto>> getAllTasks() {
        ResponseDto<List<TaskDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(tasks);
        return response;
    }

    @PostMapping("/api/v1/task")
    public ResponseDto<String> createTask(@RequestBody TaskDto task) {
        // Obtenemos el ultimo elemento de la lista  y le sumamos 1 para obtener el id
        // del nuevo elemento
        if (tasks.size() > 0) {
            TaskDto lastTask = tasks.get(tasks.size() - 1);
            task.setTaskId(lastTask.getTaskId() + 1);
        } else {
            task.setTaskId(1);
        }
        tasks.add(task);
        ResponseDto<String> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse("Task created");
        return response;
    }
}