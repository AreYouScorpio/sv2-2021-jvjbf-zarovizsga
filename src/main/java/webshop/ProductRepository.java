package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public List<String> listEmployeeNames(){
        return jdbcTemplate.query("select emp_name from employees", (rs,rowNum)->rs.getString("emp_name"));
    }

    public long insertProduct(String productName, int price, int stock) {


        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("insert into products(product_name,price,stock) values(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, productName);
            ps.setLong(2, price);
            ps.setLong(3, stock);
            return ps;
        }, holder);
        return holder.getKey().longValue();


    }



}
