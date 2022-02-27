package com.example.study1.controller.api;

import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.UserApiRequest;
import com.example.study1.model.network.response.UserApiResponse;
import com.example.study1.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLocgicService;

    @Override
    @PostMapping("") // api/user 로 매칭
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}",request);
        return userApiLocgicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse>  read(@PathVariable(name = "id") Long id) {
        log.info("read id : {}",id);
        return userApiLocgicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse>  update(@RequestBody Header<UserApiRequest> request) {

        return userApiLocgicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<UserApiResponse>  delete(@PathVariable(name = "id") Long id) {
        log.info("delete id :{}",id);
        return userApiLocgicService.delete(id);
    }
}
