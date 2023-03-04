package bo.edu.ucb.todo.dto;

public  class ResponseDto<T> {

    public String code;
    public T response;
    public String errorMessage;
}