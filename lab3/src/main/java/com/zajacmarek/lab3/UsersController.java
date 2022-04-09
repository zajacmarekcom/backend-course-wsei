package com.zajacmarek.lab3;

import com.zajacmarek.lab3.dto.UserItemResponse;
import com.zajacmarek.lab3.dto.UsersResponse;
import com.zajacmarek.lab3.entities.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UsersController {
    private Map<Integer, UserEntity> _users;

    public UsersController() {
        _users = new HashMap<>();
    }

    @GetMapping("/users")
    public UsersResponse getUsers(@RequestParam Optional<Integer> pageNumber, @RequestParam Optional<Integer> pageSize) {
        List<UserItemResponse> users = new LinkedList<>();

        int total = _users.size();
        int pageSizeVal =  pageSize.orElse(total);
        int pagesCount = pageSize.isPresent() ? total / pageSizeVal : 1;
        int pageNumberVal = pageNumber.orElse(1);

        if (pageSizeVal < 1) {
            pageSizeVal = 1;
        } else if (pageSizeVal > 100) {
            pageSizeVal = 100;
        }

        if (pageNumberVal < 1) {
            pageNumberVal = 1;
        }

        for(int id: _users.keySet()) {
            UserEntity user = _users.get(id);
            users.add(new UserItemResponse(id, user.name, user.age));
        }

        if (pageNumber.isPresent() && pageSize.isPresent()) {
            users = users.stream().skip(pageNumber.get() * pageSize.get()).collect(Collectors.toList());
        }

        return new UsersResponse(total, pagesCount, pageNumberVal, pageSizeVal, users);
    }

    @PostMapping("user/add")
    public int addUser(@RequestParam String name, @RequestParam int age) {
        int newId = 1;

        for (int id: _users.keySet()) {
            if (id >= newId) {
                newId = id + 1;
            }
        }

        _users.put(newId, new UserEntity(name, age));

        return newId;
    }
}
