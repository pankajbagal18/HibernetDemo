package com.ideas.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please select(1/2/3/4) : \n1. Insert\n2. Update\n3. Update\n 4.Delete\n");
        int choice = Integer.parseInt(br.readLine());
        switch (choice)
        {
            case 1:
                System.out.println("Enter firstName lastName and email separated by space");
                String input[] = br.readLine().split(" ");
                saveRecord(new Person(input[0],input[1],input[2]));
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;
        }
    }

    private static void saveRecord(Person person) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
