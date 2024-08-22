package com.project.Testing;

public class SubClass {

    private String subClassField = "Sub_Class_Field";
    public Integer anInt;

    void subClassMethod() {

        System.out.println("Sub_Class_Method");
    }

    public SubClass(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "subClassField='" + subClassField + '\'' +
                ", anInt=" + anInt +
                '}';
    }

    public void setSubClassField(String subClassField) {
        this.subClassField = subClassField;
    }

    public void setAnInt(Integer anInt) {
        this.anInt = anInt;
    }

    public String getSubClassField() {
        return subClassField;
    }

    public Integer getAnInt() {
        return anInt;
    }
}
