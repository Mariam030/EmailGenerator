package com.example.demo;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 1000;
    private String alternateEmail;
    private String compantSuffix = "Xcompany.com";
    private String email;
    public Email(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Worker :  " + this.firstName + " " + this.lastName);
        System.out.println("Department is " + this.department);
        this.password = randomPassword(10);
        System.out.println("Your Password is : " + this.password);
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.compantSuffix ;
    }

    void setDepartment(String department)
    {
        this.department = department ;
        /*System.out.print("Department Codes : \n1 : Sales\n2 : Development\n3 : Accounting\n0 : none \n Enter your Department Code : ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1)
        {
            return "Sales";
        }
        else if(depChoice == 2)
        {
            return "Development";
        }
        else if(depChoice == 3)
        {
            return "Accounting";
        }
        else
        {
            return "";
        }*/
    }
    // Generate a random password
    private String randomPassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        String password = ""; // Initialize an empty string

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password += passwordSet.charAt(rand); // Append the random character to the string
        }
        return password;
    }
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDepartment() {
        return department;
    }
    public String getCompantSuffix() {
        return compantSuffix;
    }
    public String getPassword() {
        return password;
    }

    public String showInfo()
    {
        return "\nDisplay Information : " + "\nName : " + this.firstName + " " + this.lastName + "\nCompany Email : " + this.email
                + "\nMailbox Capacity : " + this.mailboxCapacity + "mb" ;
    }
}
