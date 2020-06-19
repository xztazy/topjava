package ru.javawebinar.topjava.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repisitory.MealToRepository;

import java.util.List;

@Service
public class MealToServiceImpl implements MealToService{

    @Autowired
   private FoodHolder repository;


    @Override
    public void create(Meal meal) {
        repository.save(meal);
    }

    @Override
    public List<Meal> getAll() {
        return repository.getAll();
    }

    @Override
    public void updateById(int id, Meal meal) {

    }

    @Override
    public void deleteById(int id) {

    }
}
