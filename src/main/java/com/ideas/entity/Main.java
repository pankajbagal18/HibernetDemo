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
        System.out.println("Please select(1/2/3/4) : \n1. Insert\n2. Read\n3. Update\n 4.Delete\n");
        int choice = Integer.parseInt(br.readLine());
        int testId;
        switch (choice)
        {
            case 1:
                System.out.println("Enter firstName lastName and email separated by space");
                String input[] = br.readLine().split(" ");
                saveRecord(new Person(input[0],input[1],input[2]));
                break;

            case 2:
                System.out.println("Enter id delete the record : ");
                testId = Integer.parseInt(br.readLine());
                Person person =  getPersonRecord(testId);
                System.out.println(person);
                break;

            case 3:

                break;

            case 4:
                System.out.println("Enter id delete the record : ");
                testId = Integer.parseInt(br.readLine());
                deleteRecord(testId);
                break;
        }
    }

    private static void saveRecord(Person person) {
        //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = getSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    private static void deleteRecord(int testId) {
        Session session = getSession();
        session.beginTransaction();
        Person person = (Person) session.load(Person.class,testId);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    private static Person getPersonRecord(int testId)
    {
        Session session = getSession();
        session.beginTransaction();
        Person person = (Person) session.load(Person.class,testId);
        session.getTransaction().commit();
        return person;
    }

    private static Session getSession()
    {
        return new Configuration().configure().buildSessionFactory().openSession();
    }
}
