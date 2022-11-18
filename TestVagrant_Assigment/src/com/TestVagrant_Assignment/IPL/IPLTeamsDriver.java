package com.TestVagrant_Assignment.IPL;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IPLTeamsDriver {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<IPLTeams> teams = new ArrayList<>();

        teams.add(new IPLTeams("GT", 20, new char[]{'W', 'W', 'L', 'L', 'W'}));
        teams.add(new IPLTeams("LSG", 18, new char[]{'W', 'L', 'L', 'W', 'W'}));
        teams.add(new IPLTeams("RR", 16, new char[]{'W', 'L', 'W', 'L', 'L'}));
        teams.add(new IPLTeams("DC", 14, new char[]{'W', 'W', 'L', 'W', 'L'}));
        teams.add(new IPLTeams("RCB", 14, new char[]{'L', 'W', 'W', 'L', 'L'}));
        teams.add(new IPLTeams("KKR", 12, new char[]{'L', 'W', 'W', 'L', 'W'}));
        teams.add(new IPLTeams("PBKS", 12, new char[]{'L', 'W', 'L', 'W', 'L'}));
        teams.add(new IPLTeams("SRH", 12, new char[]{'W', 'L', 'L', 'L', 'L'}));
        teams.add(new IPLTeams("CSK", 8, new char[]{'L', 'L', 'W', 'L', 'W'}));
        teams.add(new IPLTeams("MI", 6, new char[]{'L', 'W', 'L', 'W', 'W'}));


        System.out.println("Your provided IPL teams are: \n");
        for (IPLTeams t : teams) {
            System.out.println(t);
        }

        boolean runs = true;

        try {
            while (runs) {
                System.out.println("\nEnter your choice : ");
                System.out.println("1. See Teams who have two Consecutive looses");
                System.out.println("2. Enter Custom Inputs :");
                System.out.println("3. Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println("the IPL Teams who have two consecutive looses are:");
                        ArrayList<IPLTeams> twoLooses = winLoseCounts(teams, 2, 'L');
                        for (IPLTeams t1 : twoLooses) {
                            System.out.println(t1);
                        }
                        break;
                    }
                    case 2: {

                            System.out.println("Enter Your Input : Enter win as 'W' and lose as 'L' :");
                            char c = sc.next().toUpperCase().charAt(0);
                            if(c != 'W' && c != 'L'){
                                throw new InvalidInputException("Provided Input is not recognised");
                            }
                            else{
                                System.out.println("enter the consecutive times :");
                                int num = sc.nextInt();
                                if(num<=0 || num>5){
                                    throw new InvalidInputException("We have records of only last 5 matches. Provided number is not between 1 to 5");
                                }
                                else {
                                    ArrayList<IPLTeams> filteredTeam = winLoseCounts(teams, num, c);
                                    
                                    double totalPoints = 0.0;
                                    String score = (c=='W'?"Wins":"Loose");
                                    if(filteredTeam.isEmpty()) {
                                    	System.out.println("None of the teams having "+num+" consecutive "+score);
                                    	break;
                                    }
                                    
                                    System.out.println("\nTeams having "+num+" Consecuitive "+score+" are :\n");

                                    for (IPLTeams fTeams : filteredTeam) {
                                        System.out.println(fTeams);
                                        totalPoints = totalPoints + fTeams.getTeamPoints();
                                    }
                                    System.out.println("\nThe Average point of Filtered Teams is :" +((totalPoints<=0)?0.0: totalPoints / filteredTeam.size()));
                                }
                            }
                        break;
                    }
                    case 3:
                    {
                        runs = false;
                        break;
                    }
                    default:{
                        System.out.println("Please Enter valid input ( between 1 to 3 )");
                    }
               }
            }
        }
        catch (InvalidInputException e){
            System.out.println("Exception Occurred : Invalid Input");
            e.printStackTrace();
        }
        catch (InputMismatchException ex){
            System.out.println("Exception Occurred : Provided Input is not a Integer");
            ex.printStackTrace();
        }
}

    public static ArrayList<IPLTeams> winLoseCounts(ArrayList<IPLTeams> myTeam, int num, char winlose){

        ArrayList<IPLTeams> filterdTeams = new ArrayList<>();

        for(int i=0;i<myTeam.size();i++){
            int counts =0;
            for(int j=0;j<myTeam.get(i).getMatchResult().length-1;j++){
                if(myTeam.get(i).getMatchResult()[j] ==winlose){
                    counts++;
                    if(counts==num){
                        filterdTeams.add(myTeam.get(i));
                        break;
                    }
                }
                else counts=0;
            }
        }
        return filterdTeams;
    }
}
