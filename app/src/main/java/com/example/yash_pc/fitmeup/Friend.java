package com.example.yash_pc.fitmeup;

class Friend {
    private String foodname;
    private String cal;
    private String id;

    public Friend(){

    }

    public Friend(String id,String foodname, String cal) {
        this.foodname = foodname;
        this.id=id;
        this.cal = cal;
    }
    public String getId() { return id; }
    public String getName() {
        return foodname;
    }
    public String getJob() {
        return cal;
    }


}
