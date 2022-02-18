package com.example.study1.ifs;

import com.example.study1.model.network.Header;

public interface CrudInterface {

    Header create(); // todo request object 추가

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
