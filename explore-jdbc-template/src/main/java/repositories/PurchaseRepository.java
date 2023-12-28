package repositories;

import model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        jdbc.update("INSERT INTO purchase VALUES (null, ?, ?)", purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchase() {

        return jdbc.query("SELECT * FROM purchase", (r,i) -> Purchase.builder()
                    .id(r.getInt("id"))
                    .product(r.getString("product"))
                    .price(r.getBigDecimal("price"))
                    .build()
        );
    }
}


