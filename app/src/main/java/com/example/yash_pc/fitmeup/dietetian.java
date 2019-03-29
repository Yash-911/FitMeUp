package com.example.yash_pc.fitmeup;

public class dietetian {
    private String Name1;
    private String No;
    private String gym;
    private String experience;

    public dietetian(){

    }

    public dietetian(String Name,String No, String gym,String experience) {
        this.Name1 = Name;
        this.No=No;
        this.gym = gym;
        this.experience = experience;
    }


    public String getName1(int position) { return Name1; }
    public String getNo(int position) {
        return No;
    }
    public String getGym(int position) { return gym; }
    public String getExperience(int position){return experience;}
}
