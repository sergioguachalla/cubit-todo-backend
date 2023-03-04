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
        response.code = "0000";
        response.response = tasks;
        return response;
    }

    @PostMapping("/api/v1/task")
    public ResponseDto<String> createTask(@RequestBody TaskDto task) {
        tasks.add(task);
        ResponseDto<String> response = new ResponseDto<>();
        response.code = "0000";
        response.response = "Task created";
        return response;
    }
}