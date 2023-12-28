package com.springboot.ToDoList.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {//Constructor injection
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap){
       List<Todo> todos = toDoService.findByUsername("veekesh2408");
       modelMap.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap){
        String username = (String)modelMap.get("name");
        Todo todo = new Todo(0,username," ",LocalDate.now().plusYears(1),false);
        modelMap.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap modelMap, @Valid Todo todo, BindingResult result){

        if (result.hasErrors()){
            return "todo";
        }
        String username=((String) modelMap.get("name"));
        toDoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        //Delete todo
        toDoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap){
        Todo todo = toDoService.findById(id);
        modelMap.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "todo";
        }

        String username = (String)modelMap.get("name");
        todo.setUsername(username);
        toDoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
