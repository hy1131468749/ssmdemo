package com.demo.bean;

import java.io.Serializable;
import java.util.Date;

public class Org implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String orgName;

    private Integer orgLevel;

    private String orgManager;

    private Integer parentId;

    private String orgPhone;

    private String orgAddress;

    private String orgPhoto;

    private Integer orgType;

    private Date createTime;

    private Date updateTime;

    private Byte parentYes;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getOrgManager() {
        return orgManager;
    }

    public void setOrgManager(String orgManager) {
        this.orgManager = orgManager == null ? null : orgManager.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone == null ? null : orgPhone.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public String getOrgPhoto() {
        return orgPhoto;
    }

    public void setOrgPhoto(String orgPhoto) {
        this.orgPhoto = orgPhoto == null ? null : orgPhoto.trim();
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getParentYes() {
        return parentYes;
    }

    public void setParentYes(Byte parentYes) {
        this.parentYes = parentYes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}