package BETEC;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Coins {

    public static File f = new File("C:\\Users\\96277\\Desktop\\Lab\\BETEC_Assignment\\USD coins.txt");

    public static void CoinsJD() {
        try {
            Scanner Re = new Scanner(f);
            System.out.println("List the content of the file:");
            while (Re.hasNext()) {
                double Coin = Re.nextDouble();
                double[] arr = {Coin * 0.71};
                for (double y : arr) {
                    System.out.println(y);
                }
            }
        } catch (Exception e) {
            System.out.println("The file not found");
        }
    }

    public static void bubbleSort() {
        ArrayList <Double> coin = new ArrayList<>();
        try {
            Scanner Re = new Scanner(f);
            while (Re.hasNext()) {
                double Coins = Re.nextDouble();
                coin.add(Coins*0.71);
            }
            int n =coin.size();
            double sor;
            for (int i=0; i<n-1; i++) {
                for(int s=0; s<(n-i-1); s++){
                    if(coin.get(s) > coin.get(s+1)) {
                        sor = coin.get(s);
                        coin.set(s,coin.get(s+1));
                        coin.set(s+1,sor);
                    }
                }
            }
            System.out.println("The list is in order: ");
            for (Double aDouble : coin) {
                System.out.println(aDouble);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void binarySearch() {
        Scanner scan = new Scanner(System.in);
        int first, last, middle;
        try {
            Scanner Re = new Scanner(f);
            System.out.print("Search for a number in the file: ");
            double search = scan.nextDouble();
            boolean found=false;
            while (Re.hasNext()) {
                double Coin = Re.nextDouble();
                Double[] arr = {(Coin * 0.71)};
                first = 0;
                last = 0;
                middle = 0;
                while(first<=last)
                {
                    if(arr[middle]<search)
                    {
                        first = middle+1;
                    }
                    else if(arr[middle]==search)
                    {
                        System.out.println("Found");
                        found = true;
                        break;
                    }
                    else
                    {
                        last = middle-1;
                    }
                    middle = (first+last)/2;
                }
            }
            if(!found)
            {
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("**************************************");
            System.out.println("* Select 'P' to print the file       *");
            System.out.println("* Select 'D' to display sorted list  *");
            System.out.println("* Select 'S' to search               *");
            System.out.println("* Select 'Q' to Quit                 *");
            System.out.println("**************************************");
            System.out.print("Take a choice: ");
            char choice = in.next().charAt(0);
            switch (choice) {
                case 'P':
                case 'p':
                    CoinsJD();
                    break;
                case 'D' :
                case 'd' :
                    bubbleSort();
                    break;
                case 'S' :
                case 's':
                    binarySearch();
                    break;
                case 'Q' :
                case 'q' :
                    return;
                default :
                    System.out.println("Please choose between the following characters ( P , D , S , Q )");
                    break;
            }
        } while (true);
    }
}
