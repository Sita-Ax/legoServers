package me.code.legoservers.lego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class LegoService {

    @Autowired
    LegoRepository repository;

    public Collection<Lego> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparingInt(Lego::get_id)).collect(Collectors.toList());
    }

    public Collection<Lego> getSearchLego(String themes) {
        return repository.getAll()
                .stream()
                .filter(x -> x.getName().toLowerCase().matches(".*" + themes.toLowerCase() + ".*") ||
                        themes.equals(Integer.toString(x.get_id())) ||
                        themes.equals(Integer.toString(x.getParentId()))
                ).collect(Collectors.toList());
    }
}
