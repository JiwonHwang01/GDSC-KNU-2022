package com.example.study1.ifs;

import com.example.study1.model.network.Header;
import com.example.study1.model.network.request.UserApiRequest;

public interface CrudInterface<Req, Res> {

    Header<Res> create (Header<Req> request); // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);
}
