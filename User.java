package com.company;

public class User {
    private int id;
    private String name;
    private String surname;
    private String username;
    private int id_gen = 0;
    private Password password;
    public User(){
    }


    public User(String name, String surname, String username, String password) {
        generateId();
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }

    public User(int id, String name, String surname, String username, String password) {
        setId(id);
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
        updateidGen(id);

    }

    private void updateidGen(int id){
        if( id_gen < id + 1 ){
            id_gen = id;
        }
    }

    public static void addUser(int id,String name, String suname, String username, String password) {
        new User(name, suname, username, password);
    }


    private void generateId() {
        id = id_gen++;
    }

    private void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setPassword(String password) {
    this.password = new Password(password);
    }
    public Password getPassword(){
        return  password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return getUsername()+" "+getSurname();
    }
}
