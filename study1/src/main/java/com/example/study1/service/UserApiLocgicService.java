package com.example.study1.service;

import com.example.study1.ifs.CrudInterface;
import com.example.study1.model.entity.User;
import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.UserApiRequest;
import com.example.study1.model.network.response.UserApiResponse;
import com.example.study1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLocgicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1
        UserApiRequest userApiRequest = request.getData();

        // 2
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

        // 3
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        // id -> repository getOne, getById
        return userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(
                        ()->Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 찾기
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        // 3. update
        return optional.map(user -> {
            user.setAccount(user.getAccount())
                    .setPassword(user.getPassword())
                    .setStatus(user.getStatus())
                    .setPhoneNumber(user.getPhoneNumber())
                    .setEmail(user.getEmail())
                    .setRegisteredAt(user.getRegisteredAt())
                    .setUnregisteredAt(user.getUnregisteredAt())
                    ;
            return user;
        })

        // 4. userApi
        return null;
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user){
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);
    }
}
