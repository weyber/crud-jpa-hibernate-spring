package model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@NamedQueries({
    @NamedQuery(name = "findAll", 
            query = "SELECT u FROM Car u"),

            @NamedQuery(name = "findByBrand", 
            query = "SELECT u FROM Car u WHERE u.brand LIKE :brand")

})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    @OneToMany(mappedBy="car", cascade=CascadeType.ALL, 
            fetch = FetchType.EAGER)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Collection<Model> models;

    public Car() {
        // TODO Auto-generated constructor stub
    }

    public Car(Long id, String brand){
        this.id = id;
        this.brand = brand;
    }

    /* Gets and Sets */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Collection<Model> getModels() {
        return models;
    }

    public void setModels(Collection<Model> models) {
        this.models = models;
    }

    public Long getId() {
        return id;
    }

}
