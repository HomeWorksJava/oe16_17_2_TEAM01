/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apitest.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krumpli
 */
public class Research {
    private String research_name;
    private int research_id;
    private int leader_id;
    private int fund;
    private boolean isPublic;
    //private ArrayList<User> team;
    
  //  public Research(int id, String name,int lead, boolean ispub)
    //{
     //  this.research_id=id;
     //   this.research_name=name;
       // this.leader_id=lead;
       // this.isPublic=ispub;
    //}

    /**
     * @return the research_name
     */
    public String getResearch_name() {
        return research_name;
    }

    /**
     * @param research_name the research_name to set
     */
    public void setResearch_name(String research_name) {
        this.research_name = research_name;
    }

    /**
     * @return the research_id
     */
    public int getResearch_id() {
        return research_id;
    }

    /**
     * @param research_id the research_id to set
     */
    public void setResearch_id(int research_id) {
        this.research_id = research_id;
    }
    /**
     * @return the leader_id
     */
    public int getLeader_id() {
        return leader_id;
    }

    /**
     * @param leader_id the leader_id to set
     */
    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }

    /**
     * @return the fund
     */
    public int getFund() {
        return fund;
    }

    /**
     * @param fund the fund to set
     */
    public void setFund(int fund) {
        this.fund = fund;
    }

    /**
     * @return the isPublic
     */
    public boolean isIsPublic() {
        return isPublic;
    }

    /**
     * @param isPublic the isPublic to set
     */
    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return the team
     */
  /*  public ArrayList<User> getTeam() {
        return team;
    }
*/
    /**
     * @param team the team to set
     */
   /* public void setTeam(ArrayList<User> team) {
        this.team = team;
    }
    */
}
