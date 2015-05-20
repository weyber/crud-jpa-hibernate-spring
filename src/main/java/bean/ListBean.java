package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import model.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.ICarDao;

@Controller("listBean")
@Scope("session")
public class ListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Car> cars;

    @Autowired
    private ICarDao carDao;

    private String pesquisar;

    private boolean bool;


    @PostConstruct
    public void init(){
        read();
        bool = false;
    }

    public void read() {
        cars = carDao.select();	
    }

    public void read2() {
        cars = carDao.select(getPesquisar());
        pesquisar = null;
        bool = true;
    }

    public void read3() {
        if(bool){
            cars = carDao.select();
            bool = false;
        }
    }

    /* Gets and Sets */
    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    public List<Car> getCars() {
        return cars;
    }	
}
