package ru.javawebinar.topjava.repisitory;

import org.springframework.data.repository.CrudRepository;
import ru.javawebinar.topjava.model.MealTo;

public interface MealToRepository extends CrudRepository<MealTo, Long> {
}
