package com.example.study1.controller.api;

import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.OrderGroupApiRequest;
import com.example.study1.model.network.response.OrderGroupApiResponse;
import com.example.study1.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Override
    @PostMapping("")
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {

        return orderGroupApiLogicService.create(request);

    }

    @Override
    @GetMapping("/{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {

        return orderGroupApiLogicService.read(id);
    }


    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public Header<OrderGroupApiResponse> delete(@PathVariable Long id) {
        return null;
    }
}