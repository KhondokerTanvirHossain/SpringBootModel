package com.tanvir.demo;

public class DataModel {
    private int id;
    private String name;
    private String jobDescription;


    public DataModel(int id, String name, String jobDescription) {
        this.id = id;
        this.name = name;
        this.jobDescription = jobDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

}
