package services;

import enums.ExpenseType;
import javafx.util.Pair;
import models.Expense;

import java.util.*;

public class ExpenseManagementService {
    private static ExpenseManagementService instance = null;
    private List<Expense> expenseList;

    private ExpenseManagementService() {
        expenseList = new ArrayList<>();
    }

    public static ExpenseManagementService getInstance()
    {
        if(instance == null)
        {
            instance = new ExpenseManagementService();
        }
        return instance;
    }

    public void create_expense(String u1, Double amount, Integer sizeofuserlist, List<String> userList, ExpenseType expenseType, List<Double> amountsList) {
        Integer size = userList.size();
        switch (expenseType)
        {
            case EQUAL:
                Double indAmount = amount/sizeofuserlist;
                for (String userid: userList)
                {
                    Expense exp = new Expense(u1, userid, indAmount);
                    expenseList.add(exp);
                }
            case EXACT:
                Double amountSum = 0.0;
                for(Double am : amountsList)
                {
                    amountSum += am;
                }
                if(amountSum != amount)
                {
                    System.out.println("Given amount sums don't match expense amount");
                    return;
                }
                for (Integer i=0;i<size;i++) {
                    Expense exp = new Expense(u1, userList.get(i), amountsList.get(i));
                    expenseList.add(exp);
                }
            case PERCENT:
                Double percentSum = 0.0;
                for(Double pe : amountsList)
                {
                    percentSum += pe;
                }
                if(percentSum != 100.0)
                {
                    System.out.println("Given percent sums don't equal 100");
                    return;
                }
                for (Integer i=0;i<size;i++) {
                    Expense exp = new Expense(u1, userList.get(i), amount*amountsList.get(i)/100);
                    expenseList.add(exp);
                }
        }
    }

    private String combinedUserId(String s1, String s2)
    {
        if(s1.compareTo(s2) < 0)    return s1+s2;
        else return s2+s1;
    }

    public void show() {
        HashMap<String, List<Pair<String, Double>>> txngraph = new HashMap<>();
        Set<String> useridlist = UserService.getInstance().getUseridtoUserhashmap().keySet();
        for (String userid: useridlist) {
            for (Expense expense: expenseList)
            {
                List<Pair<String, Double>> current = txngraph.get(userid);
                if (current == null) {
                    current = new ArrayList<>();
                }
                else {
                    for (Pair<String, Double> friendexpense: current) {
                        if (txngraph.get(userid)friendexpense.getKey())
                    }
                }
            }
        }
        for(String s: transactionMap.keySet())
        {
            String sh = s.substring(2,3) + " owes " + s.substring(0,1) + ": ";
            if(transactionMap.get(s) < 0) {
                sh += -1*transactionMap.get(s);
            }
            else {
                sh += transactionMap.get(s);
            }
            System.out.println(sh);
        }
    }

    public void show(String userid)
    {
        for (String u_id: UserService.getInstance().getUseridtoUserhashmap().keySet())
        {
            if(u_id != userid)
            {
                String combinedUserId = combinedUserId(userid, u_id);
                Double currexp = transactionMap.get(combinedUserId);
                if(currexp != null)
                {
                    if(combinedUserId.substring(0,1) == userid)
                }
            }
        }
    }
}