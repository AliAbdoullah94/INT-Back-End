package com.sbu.intl.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200") // Tell spring boot to get request from 4200
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoService;


    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        System.out.println("Getting " + id);
        return todoService.findById(id);
    }

    @PostMapping(path = "/users/{username}/todos")
    public ResponseEntity<Void> addTodo(@PathVariable String username, @RequestBody Todo todo) {
        System.out.println("Adding " + todo.toString());
        Todo addedTodo = todoService.save(todo);

        //Location
        //Get current resource url
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(addedTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long id, @RequestBody Todo todo) {
        System.out.println("Updating " + id);
        System.out.println(todo.toString());
        Todo todoUpdated = todoService.save(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id) {
        System.out.println("Deleting " + id);
        Todo todo = todoService.deleteById(id);
        if (todo!=null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

}
