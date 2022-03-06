package com.example.study1.controller.api;

import com.example.study1.controller.CrudController;
import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.entity.User;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.UserApiRequest;
import com.example.study1.model.network.response.UserApiResponse;
import com.example.study1.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 15) Pageable pageable){
        log.info("{}",pageable);
        return null;
    }
}
