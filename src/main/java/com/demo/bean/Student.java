package com.demo.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    private Long id;

    private String name;

    private Long number;

    private Short age;

    private String sex;

    private String cName;

    private String teacherName;

    private Integer score;

    private Date createTime;

    private Date modifyTime;

    private String remark;

    private String cid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", number=" + number + ", age=" + age + ", sex=" + sex
				+ ", cName=" + cName + ", teacherName=" + teacherName + ", score=" + score + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", remark=" + remark + ", cid=" + cid + "]";
	}
    
    
    
}