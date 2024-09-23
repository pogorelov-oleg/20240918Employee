package com.pogorelov.top.employee.classes;

public class Payment {
    private PaymentType type;
    private int workAmount;//кол-во (часов/дней/работ)
    private int cost;//сумма (тариф за час/день/работу)
    private Employee employee;//ссылка на работника

    public Payment(PaymentType type, int workAmount, int cost) {
        this.type = type;
        this.workAmount = workAmount;
        this.cost = cost;
    }

    public int getMoney() {

        return workAmount * cost;
    }

    public int getMoneyToBePaid() {
        int moneyToBePaid;
        //рассчитываю сумму выплаты по формуле (СУММА + БОНУС) - НАЛОГ
        moneyToBePaid = (int) ((getMoney() + getBonus()) - ((double) ((getMoney() + getBonus()) * getTax()) / 100));

        return moneyToBePaid;
    }

    public int getBonus() {
        int bonus = 5000;//так как в условии нет информации о рассчете премии, я установил фиксированную сумму 5000
        int hours;
        if (this.type == PaymentType.SALARY) hours = workAmount * 8;//из рассчета, что день 8-часовой
        else if (this.type == PaymentType.WAGE) hours = workAmount;
        else hours = 0;//для сдельной оплаты часы посчитать невозможно, поэтому решил эту категорию не включать

        if (hours > 200 && !employee.getInOffshore())

            return bonus;
        else

            return 0;
    }

    public int getTax() {
        int tax;
        if (this.type == PaymentType.SALARY || this.type == PaymentType.WAGE) tax = 20;
        else tax = 15;

        if (!this.employee.getHasChild()) tax += 5;

        if (employee.getInOffshore()) tax = 0;

        return tax;
    }

    public PaymentType getType() {

        return type;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
