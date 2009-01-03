package jpaconnecttomysqltu.app.service;

import jpaconnecttomysqltu.app.model.Type;

import java.util.List;

public interface TypeService {
    Type getTypeById(int id);
    Type getTypeByName(String name);
    List<Type> findAll();
}
