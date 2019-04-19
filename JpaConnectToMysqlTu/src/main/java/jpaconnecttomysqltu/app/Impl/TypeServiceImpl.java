package jpaconnecttomysqltu.app.Impl;

import jpaconnecttomysqltu.app.model.Type;
import jpaconnecttomysqltu.app.repository.TypeRepository;
import jpaconnecttomysqltu.app.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Override
    public Type getTypeById(int id) {
        Type type = typeRepository.findById(id);
        return type;
    }

    @Override
    public Type getTypeByName(String name) {
        Type type = typeRepository.findByName(name);
        return type;
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
