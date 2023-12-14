import project.Entities.*;
import org.hibernate.Session;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
            public static void main(String[] args) {

                System.out.println("Start");

                EntityManager entityManager = null;

                EntityManagerFactory entityManagerFactory = null;

                try {

                    // FACTORY NAME HAS TO MATCHED THE ONE FROM PERSISTED.XML !!!
                    entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

                    entityManager = entityManagerFactory.createEntityManager();
                    Session session = entityManager.unwrap(Session.class);


                    //New transaction
                    session.beginTransaction();
                    Film film = createFilm();
                    Film film2 = createFilm2();
                    Film film3 = createFilm3();
                    Film film4 = createFilm4();
                    Director dir = createDirector();
                    Director dir2 = createDirector2();
                    Director dir3 = createDirector3();
                    Actor actor = createActor();
                    Actor actor2 = createActor2();
                    Actor actor3 = createActor3();
                    Actor actor4 = createActor4();
                    Genre genre = createGenre();
                    Genre genre2 = createGenre2();
                    Genre genre3 = createGenre3();
                    Genre genre4 = createGenre4();
                    Finances finances = createFinances();
                    film.setDirector(dir);
                    film2.setDirector(dir);
                    film3.setDirector(dir2);
                    film4.setDirector(dir3);
                    List<Actor> actors1 = new ArrayList<>();
                    actors1.add(actor);
                    film.setActors(actors1);
                    List<Actor> actors2 = new ArrayList<>();
                    List<Actor> actors3 = new ArrayList<>();
                    actors3.add(actor2);
                    actors3.add(actor4);
                    film3.setActors(actors3);
                    List<Actor> actors4 = new ArrayList<>();
                    actors4.add(actor3);
                    film4.setActors(actors4);
                    List<Genre> genres1 = new ArrayList<>();
                    genres1.add(genre);
                    film.setGenres(genres1);
                    finances.setFilm(film);



                    // Save in First order Cache (not database yet)
                    session.save(film);
                    session.save(film2);
                    session.save(film3);
                    session.save(film4);
                    session.save(actor);
                    session.save(actor2);
                    session.save(actor3);
                    session.save(actor4);
                    session.save(dir);
                    session.save(dir2);
                    session.save(dir3);
                    session.save(genre);
                    session.save(genre2);
                    session.save(genre3);
                    session.save(genre4);
                    session.save(finances);
                    session.flush();
                    //Commit transaction to database
                    session.getTransaction().commit();

                    System.out.println("Done");


                    // FETCH
                    System.out.println("Done");

                    session.close();

                } catch (Throwable ex) {
                    // Make sure you log the exception, as it might be swallowed
                    System.err.println("Initial SessionFactory creation failed." + ex);
                } finally {

                }

            }

            private static Film createFilm() {
                Film mv = new Film();
                LocalDate custom = new LocalDate("1994-05-21");
                mv.setTytul("Pulp Fiction");
                mv.setDlugosc(154);
                mv.setDataPremiery(custom.toString());
                mv.setKrajProdukcji("USA");
                return mv;
            }
            private static Film createFilm2() {
                Film mv = new Film();
                LocalDate custom = new LocalDate("2009-05-20");
                System.out.println(custom);
                mv.setTytul("Inglorious Basterds");
                mv.setDlugosc(153);
                mv.setDataPremiery(custom.toString());
                mv.setKrajProdukcji("USA");
                return mv;
            }
            private static Film createFilm3() {
                Film mv = new Film();
                LocalDate custom = new LocalDate("2013-12-09");
                System.out.println(custom);
                mv.setTytul("Wilk z Wall Street");
                mv.setDlugosc(179);
                mv.setDataPremiery(custom.toString());
                mv.setKrajProdukcji("USA");
                return mv;
            }
            private static Film createFilm4() {
                Film mv = new Film();
                LocalDate custom = new LocalDate("2014-10-26");
                System.out.println(custom);
                mv.setTytul("Interstellar");
                mv.setDlugosc(169);
                mv.setDataPremiery(custom.toString());
                mv.setKrajProdukcji("USA");
                return mv;
            }
            private static Director createDirector(){
                Director dir = new Director();
                dir.setName("Quentin");
                dir.setSurname("Tarantino");
                dir.setCountry("USA");
                dir.setDateOfBirth("1963");
                return dir;
            }
            private static Director createDirector2(){
                Director dir = new Director();
                dir.setName("Martin");
                dir.setSurname("Scorsese");
                dir.setCountry("USA");
                dir.setDateOfBirth("1942");
                return dir;
            }
            private static Director createDirector3(){
                Director dir = new Director();
                dir.setName("Christopher");
                dir.setSurname("Nolan");
                dir.setCountry("Wielka Brytania");
                dir.setDateOfBirth("1970");
                return dir;
            }

            private static Actor createActor(){
                Actor actor = new Actor();
                actor.setName("Bruce");
                actor.setSurname("Willis");
                actor.setCountry("USA");
                actor.setDateOfBirth("1955");
                return actor;
            }
            private static Actor createActor2(){
                Actor actor = new Actor();
                actor.setName("Leonardo");
                actor.setSurname("di Caprio");
                actor.setCountry("USA");
                actor.setDateOfBirth("1974");
                return actor;
            }
            private static Actor createActor3(){
                Actor actor = new Actor();
                actor.setName("Michael");
                actor.setSurname("Caine");
                actor.setCountry("Wielka Brytania");
                actor.setDateOfBirth("1933");
                return actor;
            }
            private static Actor createActor4(){
                Actor actor = new Actor();
                actor.setName("Margot");
                actor.setSurname("Robbie");
                actor.setCountry("Australia");
                actor.setDateOfBirth("1990");
                return actor;
            }

            private static Genre createGenre(){
                Genre genre = new Genre();
                genre.setGenre("Gangsterski");
                return genre;
            }
            private static Genre createGenre2(){
                Genre genre = new Genre();
                genre.setGenre("Biograficzny");
                return genre;
            }
            private static Genre createGenre3(){
                Genre genre = new Genre();
                genre.setGenre("Science-fiction");
                return genre;
            }
            private static Genre createGenre4(){
                Genre genre = new Genre();
                genre.setGenre("Wojenny");
                return genre;
            }

            private static Finances createFinances(){
                Finances finances = new Finances();
                finances.setBudget(70000000);
                finances.setProfit(321457747);
                return finances;
            }

        }
