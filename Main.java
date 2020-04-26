package com.company;

import com.company.MyApplication;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        MyApplication application = new MyApplication();
        System.out.println("An application is about to start..");
        application.start();

    }
}
