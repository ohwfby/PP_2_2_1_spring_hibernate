package hiber.model;

import javax.persistence.*;

@Entity
@Table(name ="car")
public class Car {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long car_id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;

    @OneToOne(mappedBy = "car",fetch = FetchType.LAZY)
    private User user;

    public Car() {}
    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + car_id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    public Long getId() {
        return car_id;
    }

    public void setId(Long car_id) {
        this.car_id = car_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
