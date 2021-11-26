package challenge.ravn.repository;

import challenge.ravn.model.entity.BestSeller;
import challenge.ravn.model.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SalesRepository extends JpaRepository<SaleItem, Long> {

    @Query(nativeQuery = true,
            value = "SELECT a.name as author, sum(s.item_price * s.quantity) as revenue\n" +
                    "FROM authors a\n" +
                    "INNER JOIN books b\n" +
                    "ON b.author_id = a.id\n" +
                    "INNER JOIN sale_items s\n" +
                    "ON b.id = s.book_id\n" +
                    "GROUP BY a.name \n" +
                    "ORDER BY revenue desc\n" +
                    "LIMIT :count")
    ArrayList<BestSeller> findAuthorByRevenue(@Param("count") Integer count);
}
