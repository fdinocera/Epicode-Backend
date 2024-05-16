package repository;

import bean.Pizza;
import bean.VoceDiMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoceDiMenuRepository extends JpaRepository<VoceDiMenu, Integer> {

    public List<Pizza> findByPrezzoLessThan(double prezzo);

    @Query ("selct count(p) from Pizza p")
    public long countPizze();

}
