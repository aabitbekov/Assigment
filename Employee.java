package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Employee extends User {
    private String company;
    private String position_level;
    private double salary;


    public Employee(int id,String name, String surname, String company, String position_level){
        super.getId();
        super.getName();
        super.getSurname();
        setCompany(company);
        setPosition_level(position_level);
        salary=calculatesalary(position_level);
    }

    public Employee(int id, String name, String surname, String position_level, double salary) {
        super.getId();
        super.getName();
        super.getSurname();
        setCompany(company);
        setPosition_level(position_level);
        salary=calculatesalary(position_level);
    }


    public void setCompany(String company){
        this.company=company;
    }

    public void setPosition_level(String position_level){
        this.position_level=position_level;
    }

    public String getCompany(){
        return company;
    }

    public String getPosition_level(){
        return position_level;
    }

    private double calculatesalary(String position_level) {
        if(position_level.equals("Beginner")){
            salary = 800;
         }
        if(position_level.equals("Tall")){
            salary =2800;
        }
        if(position_level.equals("Boss")){
            salary = 4500;
        }
        else{
            salary=500;
        }
      return salary;
    }


}