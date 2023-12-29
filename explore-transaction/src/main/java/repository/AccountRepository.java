package repository;

import model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    public static final RowMapper<Account> ACCOUNT_ROW_MAPPER = (r, i) -> Account.builder()
            .id(r.getInt("id"))
            .name(r.getString("name"))
            .amount(r.getBigDecimal("amount"))
            .build();

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM account WHERE id = ?", ACCOUNT_ROW_MAPPER, id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        jdbcTemplate.update("UPDATE account SET amount = ? WHERE id = ?", amount, id);
    }

    public List<Account> findAllAccounts() {
        return jdbcTemplate.query("SELECT * FROM account", ACCOUNT_ROW_MAPPER);
    }
}