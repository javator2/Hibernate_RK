package pl.sdacademy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.hibernate.entity.Book;
import pl.sdacademy.hibernate.entity.Category;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {
    private static final SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    public static void main(final String[] args) {
        Book book = new Book();
        book.setAuthor("Marcin Lis");
        book.setIsbn("324-765");
        book.setTitle("Cwiczenia Java");

        Category category = new Category("Fantastyka");
        Book book2 = new Book();
        book2.setAuthor("Jan Kowalski");
        book2.setIsbn("324-765");
        book2.setTitle("Java");
        //book2.setCategory(new Category("fantastyka")); //Trzeba najpierw stworzyć kategorie
        book2.setCategory(category);



        Category category1 = new Category("bazy danych");
        Category category2 = new Category("programowanie java");
        Book book3 = new Book("Bazy danych MySQL", "234-432","Marian Kowalski", category1);

        Session session = getSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        session.save(book);
        session.save(book2);
        session.save(book3);
        session.save(category1);
        session.save(category2);
        tx.commit();
        //session.close();

        //pierwszy sposób pobierania danych
        List<Book> bookList = session.createQuery("FROM " + Book.class.getName()).list();
        for (Book b: bookList) {
            System.out.println(b.getAuthor() + " " + b.getTitle());

        }
        //drugi sposób pobierania danych - NIE DZIAŁA
   /*     CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> bookCriteriaBuilder = builder.
        for (Book b:bookCriteriaBuilder){
        }*/

   //usuwanie ksiazek
       /* Book book3 = session.byId(Book.class).getReference(2);
        System.out.println(book3);

        tx.begin();
        session.delete(book3);
        tx.commit();*/

        session.close();

    }
}
