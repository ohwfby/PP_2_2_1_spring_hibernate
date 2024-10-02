package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      User user = new User("Misha", "Semenov","user@gmail.com");
      Car car = new Car("AUDI",2010);
      UserService userService = context.getBean(UserService.class);
      userService.add(user.setCar(car));
      User user1 = new User("Vasya", "Petrov", "user1@mail.ru");
      Car car1 = new Car("BMW",2020);
      userService.add(user1.setCar(car1));

      System.out.println(userService.getUserByModelAndSeries("BMW", 2020));
      List<User> users = userService.listUsers();
      for (User userAll : users) {
         System.out.println("Id = "+ userAll.getId());
         System.out.println("First Name = "+ userAll.getFirstName());
         System.out.println("Last Name = "+ userAll.getLastName());
         System.out.println("Email = "+ userAll.getEmail());
         System.out.println("Model = "+ userAll.getCar().getModel());
         System.out.println("Series = "+ userAll.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
