/*
Programmer: Aaditya Manami-Ratan
12/6/23
This program sets up a road race and returns the top two overall finishes, and the next best finishes from men and women.
 */
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Entering data
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the amount of racers");
        int racerNum = sc.nextInt();
        int [] racersTimes = new int[racerNum];
        String [] racersGender = new String[racerNum];
        System.out.println("Please enter the times of the racers and their genders");
        //Bubble sort to find top times, sorting gender to same indexes as time
        for (int i = 0; i < racersTimes.length; i++) {
            racersTimes[i] = sc.nextInt();
            racersGender[i] = sc.next();
        }
        for (int i = 0; i < racerNum - 1; i++) {
            for (int j = 0; j < racerNum - 1 - i; j++) {
                if (racersTimes[j] > racersTimes[j+1]) {
                    int temp = racersTimes[j];
                    String tempG = racersGender[j];
                    racersTimes[j] = racersTimes[j+1];
                    racersGender[j] = racersGender[j+1];
                    racersTimes[j + 1] = temp;
                    racersGender[j+1] = tempG;
                }
            }
        }
        //Printing out the overall top two
        System.out.println("Top two overall: \n" + racersTimes[0] + racersGender[0] + ", " + racersTimes[1] + racersGender[1]);
        //Finding out next best men and women times
        int nextMan = racerNum;
        boolean isNextMan = false;
        int nextWoman = racerNum;
        boolean isNextWoman = false;
        for (int i = racerNum-1; i > 1; i--) {
            if (racersGender[i].equals("M") && i < nextMan) {
                isNextMan = true;
                nextMan = i;
            }
            if (racersGender[i].equals("F") && i < nextWoman) {
                isNextWoman = true;
                nextWoman = i;
            }
        }
        if (isNextMan) {
            System.out.println("Next best man: " + racersTimes[nextMan]);
        }
        if (isNextWoman) {
            System.out.println("Next best woman: " + racersTimes[nextWoman]);
        }
    }
}