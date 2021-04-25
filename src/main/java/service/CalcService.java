package service;

import dao.CalcDao;
import dao.CalcDaoImp;
import entity.Calculator;
import entity.Operation;
import exception.calc.OperationsNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class CalcService {
    CalcDao calcDao = new CalcDaoImp();

    public List<Operation> getOperation() {
        return calcDao.getOperations();
    }

    public List<Operation> getOperationByUsername(String username) {
        List<Operation> result = new ArrayList<>();
        for (Operation operation : calcDao.getOperations()) {
            if (operation.getUserName().equals(username)){
                result.add(operation);
            }
        }
        return result;
    }

    public double selectCommand(String command, double x, double y,String username) throws OperationsNotFoundException {
        double result;
        switch (command){
            case "sum":
                result = Calculator.sum(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "sub":
                result = Calculator.sub(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "div":
                result = Calculator.division(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "mul":
                result = Calculator.multiply(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            default:
                throw new OperationsNotFoundException("Operation not found." +
                            "In my calculator, there are only such commands:" +
                            "sum - sum of numbers, " +
                            "sub - subtracting numbers, " +
                            "div - divide numbers, " +
                            "mul - multiply numbers.");
        }
    }
}
