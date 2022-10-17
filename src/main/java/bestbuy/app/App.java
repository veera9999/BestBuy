package bestbuy.app;

import bestbuy.model.BestBuyLinkedList;

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) 
    {
        BestBuyLinkedList bestBuyLinkedList = new BestBuyLinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose an Option: ")
        System.out.println("1: Login as Admin: ");
        System.out.println("2: Login as Customer: ");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
            {
              System.out.println("Enter your Choice: ")
              System.out.println("1: Add Product");
              System.out.println("2: Delete Product");
              System.out.println("3: View Orders");
              System.out.println("4: Update Orders");
              int choice1=sc.nextInt();
              switch(choice1)
              {
                case 1:
                {

                }

                case 2:
                {

                }

                case 3:
                {

                }

                case 4:
                {

                }

                default: 
                break;
              }


            }
            case 2:
            {
              System.out.println("Enter your Choice: ")
              System.out.println("1: View Products");
              System.out.println("2: Search Product");
              System.out.println("3: View Cart");
              System.out.println("4: Buy a Product");
              System.out.println("5: Add Product to Cart");
              System.out.println("6: Monitor your Orders");
              int choice2=sc.nextInt();
              switch(choice2)
              {
                case 1:
                {

                }

                case 2:
                {

                }

                case 3:
                {

                }

                case 4:
                {

                }

                default: 
                break;
              }
            }

            default:
            break;
        }
        
    }

    }
