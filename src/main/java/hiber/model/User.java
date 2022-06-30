package hiber.model;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;

   @OneToOne(
           fetch = FetchType.LAZY,
           cascade = CascadeType.PERSIST
   )
   @JoinColumn
   protected Car car;

   @Column(name = "name")
   protected String firstName;

   @Column(name = "last_name")
   protected String lastName;

   @Column(name = "email")
   protected String email;

   public User() {

   }
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Long getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getEmail() {
      return email;
   }
}
