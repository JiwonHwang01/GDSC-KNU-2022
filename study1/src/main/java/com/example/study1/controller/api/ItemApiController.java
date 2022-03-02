package com.example.study1.controller.api;

import com.example.study1.controller.CrudController;
import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.entity.Item;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.ItemApiRequest;
import com.example.study1.model.network.response.ItemApiResponse;
import com.example.study1.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
