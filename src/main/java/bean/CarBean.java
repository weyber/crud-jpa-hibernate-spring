package bean;

import model.Car;
import model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ICarDao;

@Controller("carBean") 
@Scope("request")
public class CarBean {

    private Model model;

    private Car car;

    private static Car carAux;

    @Autowired
    private ICarDao carDao;

    @Autowired
    private ICarDao modelDao;

    @Autowired
    private ListBean listBean;

    /**	Constructor */
    public CarBean() {
        car = new Car(); 
        model = new Model();
    }

    public void search(Long id) {
        carAux = carDao.select(id);
    }

    public String create2() {
        model.setCar(carAux);
        modelDao.insert(model);
        listBean.read();
        return "index?faces-redirect=true";
    }

    public String create() {
        carDao.insert(car);
        listBean.read();
        return "index?faces-redirect=true";
    }

    public void delete(Long id){
        carDao.delete(id);
        listBean.read();
    }

    /** @return model */
    public Model getModel() {
        return model;
    }

    /** @return car */
    public Car getCar() {
        return car;
    }	
}