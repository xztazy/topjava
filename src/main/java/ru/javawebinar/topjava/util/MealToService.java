package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealToService {

    void create(Meal meal);
    List<Meal> getAll();
    void updateById(int id, Meal meal);
    void deleteById(int id);
}
