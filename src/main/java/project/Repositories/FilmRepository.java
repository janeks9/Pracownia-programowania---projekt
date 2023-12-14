package project.Repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import project.Entities.Film;

public interface FilmRepository extends CrudRepository<Film, Integer>, PagingAndSortingRepository<Film, Integer> {

}
