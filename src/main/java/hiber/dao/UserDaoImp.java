package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.openSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUser(String model, int series) {
      String hql = "FROM User u WHERE u.car.model = :model and u.car.series = :series";
      TypedQuery<User> query = sessionFactory.openSession().createQuery(hql);
      query.setParameter("model", model);
      query.setParameter("series", series);
      User user = query.getSingleResult();
      return user;
   }
}
