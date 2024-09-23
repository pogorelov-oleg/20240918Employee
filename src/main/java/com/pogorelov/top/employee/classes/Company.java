package com.pogorelov.top.employee.classes;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public void printReport() {
        System.out.printf("%-30s %-13s %-10s %-10s %-8s %-14s\n",
                "ФИО", "Вид оплаты", "Сумма", "Премия", "Налог", "К оплате");
        int sumMoney = 0;
        int sumHryvniToBrPaid = 0;
        int sumTugriksToBePaid = 0;
        int exchangeRate = 8;//курс гривны к тугрикам 1/8
        for (Employee employee : employees) {
            System.out.printf("%-30s %-13s %-10d %-10d %-8s ",
                    employee.getFullName(),
                    employee.getPayment().getType().getRuName(),
                    employee.getPayment().getMoney(),
                    employee.getPayment().getBonus(),
                    employee.getPayment().getTax() + "%");
            if (employee.getPayment().getType() == PaymentType.WAGE) {
                System.out.print(employee.getPayment().getMoneyToBePaid() / 2 + "/"
                        + (employee.getPayment().getMoneyToBePaid() / 2) / exchangeRate + "\n");
                sumHryvniToBrPaid += employee.getPayment().getMoneyToBePaid() / 2;
                sumTugriksToBePaid += (employee.getPayment().getMoneyToBePaid() / 2) / exchangeRate;
            } else {
                System.out.print(employee.getPayment().getMoneyToBePaid() + "\n");
                sumHryvniToBrPaid += employee.getPayment().getMoneyToBePaid();
            }
            sumMoney += employee.getPayment().getMoney();
        }
        System.out.printf("%-44s %-30d %-14s\n", "Итого:", sumMoney, sumHryvniToBrPaid + "/" + sumTugriksToBePaid);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}

