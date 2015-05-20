package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Car;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarDao implements Serializable ,ICarDao {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    /* INSERT */
    @Override
    public void insert(Object object){
        em.persist(object);

    }

    /* UPDATE */
    public void update(Object object) {
        em.merge(object);
    }

    /* DELETE */
    public void delete(Long id){
        Car car = em.find(Car.class, id);
        em.remove(car);
    }

    /* SELECT */
    public Car select(Long id){
        return em.find(Car.class, id);
    }

    public List<Car> select() {
        return em.createNamedQuery("findAll", Car.class)
                .getResultList();
    }

    public List<Car> select(String brand) {
        return em.createNamedQuery("findByBrand", Car.class)
                .setParameter("brand", "%" + brand + "%")
                .getResultList();
    }
}
