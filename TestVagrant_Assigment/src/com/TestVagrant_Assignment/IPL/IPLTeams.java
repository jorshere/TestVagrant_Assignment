package com.TestVagrant_Assignment.IPL;

import java.util.Arrays;

public class IPLTeams {
    private String nameOfTeam;
    private int teamPoints;
    private char[] matchResult;

    public IPLTeams(){
    }

    public IPLTeams(String nameOfTeam, int teamPoints, char[] matchResult) {
        super();
        this.nameOfTeam = nameOfTeam;
        this.teamPoints = teamPoints;
        this.matchResult = matchResult;
    }

    public String getNameOfTeam() {
        return nameOfTeam;
    }

    public void setNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    public int getTeamPoints() {
        return teamPoints;
    }

    public void setTeamPoints(int teamPoints) {
        this.teamPoints = teamPoints;
    }

    public char[] getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(char[] matchResult) {
        this.matchResult = matchResult;
    }

    @Override
    public String toString() {
        return"{name Of Team='" + nameOfTeam + '\'' +
                " ,  Total Points=" + teamPoints +
                ",  Last 5 match Results=" + Arrays.toString(matchResult) +
                " }";
    }
}
