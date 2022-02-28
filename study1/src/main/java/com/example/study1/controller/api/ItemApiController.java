package com.example.study1.controller.api;

import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.ItemApiRequest;
import com.example.study1.model.network.response.ItemApiResponse;
import com.example.study1.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping("")
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> read(@PathVariable Long id) {

        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {

        return itemApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<ItemApiResponse> delete(@PathVariable Long id) {

        return itemApiLogicService.delete(id);
    }
}
