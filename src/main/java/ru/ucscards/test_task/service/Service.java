package ru.ucscards.test_task.service;

import ru.ucscards.test_task.model.Data;
import ru.ucscards.test_task.repo.Repo;

public class Service {

    private Repo repo;

    public Service(Repo repo) {
        this.repo = repo;
    }

    public Data getDataById(int id) {
        return repo.getDataById(id);
    }

}
