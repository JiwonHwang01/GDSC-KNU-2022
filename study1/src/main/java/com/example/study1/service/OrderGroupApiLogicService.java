package com.example.study1.service;

import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.entity.OrderGroup;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.OrderGroupApiRequest;
import com.example.study1.model.network.response.OrderGroupApiResponse;
import com.example.study1.repository.OrderGroupRepository;
import com.example.study1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {

        OrderGroupApiRequest body = request.getData();

        OrderGroup orderGroup = OrderGroup.builder()
                .status(body.getStatus())
                .orderType(body.getOrderType())
                .revAddress(body.getRevAddress())
                .revName(body.getRevName())
                .paymentType(body.getPaymentType())
                .totalPrice(body.getTotalPrice())
                .totalQuantity(body.getTotalQuantity())
                .orderAt(LocalDateTime.now())
                .user(userRepository.getById(body.getUserId()))
                .build();

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {

        return orderGroupRepository.findById(id)
                .map(this::response)
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> delete(Long id) {
        return null;
    }

    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup){

        OrderGroupApiResponse body = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getUser().getId())
                .build();

        return Header.OK(body);
    }
}
