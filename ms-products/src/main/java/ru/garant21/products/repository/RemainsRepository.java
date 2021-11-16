package ru.garant21.products.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.garant21.products.entities.Remains;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RemainsRepository {
    private Map<String, Remains> identityMap = new HashMap<>();
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_SAVE = "insert into remains(id, productId, shopId, remains) values (?, ?, ?, ?)";
    private static final String QUERY_UPDATE = "UPDATE remains SET remains = ? WHERE id = ?";

    public RemainsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Double findByShopAndProduct(Long shopId, Long productId){
        String id = shopId + "" + productId;
        Remains remains = identityMap.get(id);
        if (remains == null) {
            try {
                Remains remain = jdbcTemplate.query("SELECT remains FROM remains" +
                        "WHERE productId = ? and shopId = ?",
                        (r, i) -> Remains.builder()
                                .id(r.getLong(1))
                                .productId(r.getLong(2))
                                .shopId(r.getLong(3))
                                .remains(r.getDouble(4))
                                .build(), id).stream().findFirst().orElse(null);
                identityMap.put(id, remain);
                if (remain != null)
                    return remain.getRemains();
            } catch (EmptyResultDataAccessException e) {
                return 0d;
            }
        }
        return 0d;
    }

    public void save(Remains remains) {
        jdbcTemplate.batchUpdate(QUERY_SAVE, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setLong(1, remains.getId());
                preparedStatement.setLong(2, remains.getProductId());
                preparedStatement.setLong(3, remains.getShopId());
                preparedStatement.setDouble(4, remains.getRemains());
            }

            @Override
            public int getBatchSize() {
                return 0;
            }
        });
    }

    public void update(Remains remains, Double newRemain) {
        jdbcTemplate.update(QUERY_UPDATE, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setLong(1, remains.getId());
                preparedStatement.setDouble(2, newRemain);
            }
            @Override
            public int getBatchSize() {
                return 0;
            }
        });
    }
}
