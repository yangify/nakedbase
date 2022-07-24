package io.hongyang.nakedbase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.EntityManagerMessageLogger_$logger;

import java.sql.*;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    EntityManagerFactory managerFactory =
        Persistence.createEntityManagerFactory("io.hongyang.nakedbase");
    EntityManager entityManager = managerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Student> result = entityManager.createQuery("from Student", Student.class).getResultList();
    System.out.println(result);
    entityManager.getTransaction().commit();
    entityManager.close();
    //
    //    // A SessionFactory is set up once for an application!
    //    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    //            .configure() // configures settings from hibernate.cfg.xml
    //            .build();
    //
    //    SessionFactory sessionFactory;
    //    try {
    //      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    //
    //      Session session = sessionFactory.openSession();
    //      session.beginTransaction();
    //      TypedQuery<Student> query = session.createQuery( "SELECT s FROM Student s" );
    //      System.out.println(query.getResultList());
    //      session.getTransaction().commit();
    //      session.close();
    //    }
    //    catch (Exception e) {
    //      // The registry would be destroyed by the SessionFactory, but we had trouble building
    // the SessionFactory
    //      // so destroy it manually.
    //      e.printStackTrace();
    //      StandardServiceRegistryBuilder.destroy( registry );
    //    }
  }

  public static void jdbc() {
    String sqlSelectAllPersons = "SELECT * FROM STUDENT";
    String connectionUrl = "jdbc:mysql://localhost:3306/watabaseh?serverTimezone=UTC";

    try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
        PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
        ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        String name = rs.getString("NAME");

        // do something with the extracted data...
        System.out.println(name);
      }
    } catch (SQLException e) {
      // handle the exception
      e.printStackTrace();
    }
  }
}
