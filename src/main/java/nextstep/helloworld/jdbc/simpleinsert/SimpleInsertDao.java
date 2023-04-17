package nextstep.helloworld.jdbc.simpleinsert;

import nextstep.helloworld.jdbc.Customer;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SimpleInsertDao {
    private SimpleJdbcInsert insertActor;

    public SimpleInsertDao(DataSource dataSource) {
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    /**
     * Map +
     * insertActor.executeAndReturnKey
     * id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithMap(Customer customer) {
        // SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        //         .addValue("first_name", customer.getFirstName())
        //         .addValue("last_name", customer.getLastName());
        // SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        //         .addValue("first_Name", customer.getFirstName())
        //         .addValue("last_Name", customer.getLastName());
        // SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        //         .addValue("firstName", customer.getFirstName())
        //         .addValue("lastName", customer.getLastName());
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("firstNAME", customer.getFirstName())
                .addValue("lastNAME", customer.getLastName());

        long key = insertActor.executeAndReturnKey(sqlParameterSource).longValue();
        // AbstractJdbcInsert가 TableMetaDataContext를 사용해 대소문자, camelcase-snakecase 모두 고려하여 알아서 넣어준다.
        return new Customer(key, customer.getFirstName(), customer.getLastName());
    }

    /**
     * SqlParameterSource +
     * insertActor.executeAndReturnKey
     * id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithBeanPropertySqlParameterSource(Customer customer) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(customer);

        long key = insertActor.executeAndReturnKey(sqlParameterSource).longValue();
        return new Customer(key, customer.getFirstName(), customer.getLastName());
    }
}
