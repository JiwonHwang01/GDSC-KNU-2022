package com.example.study1.controller.api;

import com.example.study1.controller.CrudController;
import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.entity.OrderGroup;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.OrderGroupApiRequest;
import com.example.study1.model.network.response.OrderGroupApiResponse;
import com.example.study1.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    }
