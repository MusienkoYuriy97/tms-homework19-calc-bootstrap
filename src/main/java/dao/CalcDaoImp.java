package dao;


import entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class CalcDaoImp implements CalcDao {
    private static List<Operation> operations = new ArrayList<>();

    public List<Operation> getOperations() {
        return new ArrayList<>(operations);
    }

    public void saveOperation(Operation operation) {
        operations.add(operation);
    }

}
