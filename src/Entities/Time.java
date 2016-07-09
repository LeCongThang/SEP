package Entities;
// Generated Jun 27, 2016 2:25:48 PM by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * Time generated by hbm2java
 */
public class Time implements java.io.Serializable {

    private int id;
    private String endUser;
    private int tags;
    private Date dateofTags;
    private Date startTime;
    private Date finishTime;
    private double times;
    private String Description;

    public Time() {
    }

    public Time(int id, String endUser, int tags, Date dateofTags, Date startTime, Date finishTime, double times, String description) {
        this.id = id;
        this.endUser = endUser;
        this.tags = tags;
        this.dateofTags = dateofTags;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.times = times;
        this.Description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndUser() {
        return this.endUser;
    }

    public void setEndUser(String endUser) {
        this.endUser = endUser;
    }

    public int getTags() {
        return this.tags;
    }

    public void setTags(int tags) {
        this.tags = tags;
    }

    public Date getdateogTags() {
        return this.dateofTags;
    }

    public void setdateogTags(Date dateogTags) {
        this.dateofTags = dateogTags;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public double getTimes() {
        return this.times;
    }

    public void setTimes(double times) {
        this.times = times;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String des) {
        this.Description = des;
    }

}
