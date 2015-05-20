package dao;

import java.util.List;

import model.Car;

public interface ICarDao {

    public void insert(Object object);

    public void update(Object object);

    public void delete(Long id);

    public Car select(Long id);

    public List<Car> select();

    public List<Car> select(String string);
}
