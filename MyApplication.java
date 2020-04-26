package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyApplication {
    private Scanner sc = new Scanner(System.in);
    private User signedUser;
    private LinkedList<User> users;
    private ArrayList <Employee> employee;

    public MyApplication() throws FileNotFoundException {
        users = new LinkedList<>();
        employee = new ArrayList<>();
        readFile();
    }

    private void addUsers(User user) {
        users.add(user);
    }


    private void readFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\LENOVO\\Downloads\\db.txt");
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNext()) {
            User user = new User(fileScanner.nextInt(), fileScanner.next(), fileScanner.next(), fileScanner.next(), fileScanner.next());
            addUsers(user);
        }
        File file1 = new File("C:\\Users\\LENOVO\\Desktop");
        Scanner scanner1 = new Scanner(file1);

        while(scanner1.hasNext()){
            Employee employee1 = new Employee(scanner1.nextInt(),scanner1.next(),scanner1.next(),scanner1.next(),scanner1.nextDouble());
            employee.add(employee1);
        }

    }


    public void start() throws IOException {
        File file = new File("C:\\Users\\LENOVO\\Downloads\\db.txt");
        Scanner fileScanner = new Scanner(file);
        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Menu");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                menu();
            } else {
                break;
            }
        }
        saveUsers();
    }

    private void menu() throws IOException {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in.");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1) authentication();
                else break;
            } else {
                userProfile();
            }
        }
    }

    private boolean formemployee(String name,String surname){
        for (Employee employee : employee){
           if(name.equals(employee.getName()) && surname.equals(employee.getSurname()))
              return true;
        }
        return false;
    }

    private void userProfile() {
        System.out.println("Hello "+ signedUser.getName()+" "+signedUser.getSurname());
        if(!formemployee(signedUser.getName(),signedUser.getSurname())) {
            System.out.println("Do you want fill out an employee form?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choise;
            choise=sc.nextInt();
            if(choise==1) {
                FormEmployee(signedUser.getName(), signedUser.getSurname());
            }
                else
                    userProfile();

            }
        }


        private void  FormEmployee(String name, String surname){
            System.out.println("Company name?");
        String company = sc.next();
            System.out.println("Position? Beginner , Tall , Boss?");
        String postion = sc.next();
        Employee employee2 = new Employee(signedUser.getId(),name,surname,company,postion);
        employee.add(employee2);
        userProfile();
        }

    private void authentication() throws IOException {
        System.out.println("Do you have a account?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3.Back");
        int choice = sc.nextInt();
        if (choice == 1) signIn();
        else if (choice == 2) signUp();
        else menu();
    }

    private void signIn() throws FileNotFoundException {
        Scanner sca = new Scanner(System.in);
        System.out.println("White you username and password here:");
        String username = sca.next();
        String password = sca.next();
        Password password1 =new Password(password);
        for(User user : users){
            if(username.equals(user.getUsername()) && password1.equals(user.getPassword())){
                signedUser = user;
            }
        }

    }


    private void signUp() throws IOException {
        System.out.println("Please write you name:");
        String name = sc.next();
        System.out.println("Please write you surname:");
        String surname = sc.next();
        System.out.println("Please create username:");
        String username = sc.next();
        System.out.println("Please create password(you password must be more 9 symbols and have uppercase letter) :");
        String password = sc.next();
        if (name != null && surname != null && username != null && password != null) {
            User newer = new User();
            newer.setSurname(surname);
            newer.setUsername(username);
            newer.setName(name);
            newer.setPassword(password);
            addUsers(newer);
            authentication();
        }
    }


    private void saveUsers() throws IOException {
        String data = "";
        for (User user : users) {
            data += user + "\n";
        }
        Files.write(Paths.get("C:\\Users\\LENOVO\\Downloads\\db.txt"), data.getBytes());
    }

    private void saveEmployee() throws IOException {
        String data = "";
        for (Employee employee : employee) {
            data += employee + "\n";
        }
        Files.write(Paths.get("C:\\Users\\LENOVO\\Desktop"), data.getBytes());
    }
}


