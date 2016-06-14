package com.mengli.test.model;

/**
 * Created by mlhuang on 4/21/16.
 */
public class Staff {
    private String name;
    private String staffNo;
    private int age;

    public Staff() {
    }

    public Staff(String name, String staffNo, int age) {
        this.name = name;
        this.staffNo = staffNo;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (age != staff.age) return false;
        if (!name.equals(staff.name)) return false;
        return staffNo.equals(staff.staffNo);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + staffNo.hashCode();
        result = 31 * result + age;
        return result;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", staffNo='" + staffNo + '\'' +
                ", age=" + age +
                '}';
    }
}