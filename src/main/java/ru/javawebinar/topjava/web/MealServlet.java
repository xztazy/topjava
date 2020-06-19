package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.FoodHolder;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MealServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    private FoodHolder foodHolder = new FoodHolder();
    private int caloriesPerDay = 2000;

    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));
        String description = request.getParameter("description");
        int calories = Integer.valueOf(request.getParameter("calories"));
        int id = Integer.valueOf(request.getParameter("id"));
        Meal meal = new Meal(date, description, calories);
        meal.setId(id);
        foodHolder.save(meal);
        log.debug("saved " + meal);
        response.sendRedirect("meals");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.debug("get request");

        String action = request.getParameter("action");


        if (action == null) {
            log.debug("getAll");
            request.setAttribute("meals", MealsUtil.filteredByStreams(foodHolder.getAll(), LocalTime.MIN, LocalTime.MAX, caloriesPerDay));
        request.getRequestDispatcher("meals.jsp").forward(request, response);

        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            log.debug("redirect to delete id = " + id);
            foodHolder.delete(id);
            response.sendRedirect("meals");

        } else if (action.equals("create")) {

            log.debug("create");
            LocalDateTime now = LocalDateTime.now();
            now = LocalDateTime.of(now.getYear(), now.getMonth(),now.getDayOfMonth(),now.getHour(),now.getMinute());
            request.setAttribute("meal", new Meal(now, "новая", 500));
            request.getRequestDispatcher("updateMeal.jsp").forward(request, response);

        } else if (action.equals("update")) {
            int id = Integer.valueOf(request.getParameter("id"));
            log.debug("update id=" + id);
            request.setAttribute("meal", foodHolder.getById(id));
            request.getRequestDispatcher("updateMeal.jsp").forward(request, response);
        }
        log.debug("end of get");

    }
}
