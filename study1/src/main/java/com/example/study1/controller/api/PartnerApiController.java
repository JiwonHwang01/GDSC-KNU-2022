package com.example.study1.controller.api;

import com.example.study1.controller.CrudController;
import com.example.study1.model.entity.Partner;
import com.example.study1.model.network.request.PartnerApiRequest;
import com.example.study1.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner>{
}
