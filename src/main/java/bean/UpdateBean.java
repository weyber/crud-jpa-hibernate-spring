package bean;

import java.io.Serializable;

import model.Car;
import model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ICarDao;

@Controller("updateBean") 
@Scope("session")
public class UpdateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Car carUpdate;

    private Model modelUpdate;

    @Autowired
    private ICarDao modelDao;

    @Autowired
    private ListBean listBean;

    /* Constructor */
    public UpdateBean() {
        carUpdate = new Car();
        modelUpdate = new Model();
    }

    public void search(Long id, Long id2) {
        for (Car car : listBean.getCars()) {
            if(car.getId().equals(id)) {
                this.carUpdate = car;
                break;
            }
        }

        for (Model model : carUpdate.getModels()) {
            if(model.getId().equals(id2)) {
                this.modelUpdate = model;
                break;
            }
        }
    }

    public String update() {
        modelDao.update(carUpdate);
        return "index?faces-redirect=true";
    }

    /* Gets and Sets */
    public Car getCarUpdate() {
        return carUpdate;
    }

    public Model getModelUpdate() {
        return modelUpdate;
    }
}
