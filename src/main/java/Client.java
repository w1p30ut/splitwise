import enums.ExpenseType;
import services.*;

import java.util.Arrays;

public class Client {
    public static void main(String[] args)
    {
        UserService userService = UserService.getInstance();
        ExpenseManagementService expenseManagementService = ExpenseManagementService.getInstance();
        expenseManagementService.show();
        expenseManagementService.show("u1");
        expenseManagementService.create_expense("u1", 1000.0, 4, Arrays.asList("u1", "u2", "u3", "u4"), ExpenseType.EQUAL, null);
        expenseManagementService.show("u4");
        expenseManagementService.show("u1");
        expenseManagementService.create_expense("u1", 1250.0, 2, Arrays.asList("u2", "u3"), ExpenseType.EXACT, Arrays.asList(370.0, 880.0));
        expenseManagementService.show();
        expenseManagementService.create_expense("u4", 1200.0, 4, Arrays.asList("u1", "u2", "u3", "u4"), ExpenseType.PERCENT, Arrays.asList(40.0, 20.0, 20.0, 20.0));
        expenseManagementService.show("u1");
        expenseManagementService.show();
    }
}
