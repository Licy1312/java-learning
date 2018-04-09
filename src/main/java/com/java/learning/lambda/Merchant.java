package com.java.learning.lambda;

import java.math.BigDecimal;

/**
 * Description: 商户类
 * User:Lee
 * Date:2018/4/9
 */
public class Merchant {

    /**
     * 会员名称
     */
    private String name;

    /**
     * 0:普通用户 1:会员 2：VIP会员 3：SVIP
     */
    private int grade;

    /**
     * 账户余额
     */
    private BigDecimal balance;

    public Merchant(String name, int grade, BigDecimal balance) {
        this.name = name;
        this.grade = grade;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", balance=" + balance +
                '}';
    }
}
