package com.example.study1.controller.api;

import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserApiController implements CrudInterface {


    @Override
    @PostMapping("") // api/user 로 매칭
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public Header read(Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(Long id) {
        return null;
    }
}
