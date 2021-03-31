package ru.ucscards.test_task.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.ucscards.test_task.model.Data;
import ru.ucscards.test_task.model.DataMapper;

import java.util.List;

public class Storage implements Repo {

    private JdbcTemplate template;

    public Storage(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Data getDataById(int id) {
        List<Data> list = template.query(
                "SELECT * FROM ttest WHERE id = ?", new Object[]{id},
                new DataMapper());
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
