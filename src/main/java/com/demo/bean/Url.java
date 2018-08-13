package com.demo.bean;

import java.io.Serializable;
import java.util.Date;

public class Url implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String urlAddress;

    private String urlName;

    private Integer urlLevel;

    private Long parentId;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String iconName;

    private String iconUrl;

    private Integer urlSequence;

    private Byte parentYes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress == null ? null : urlAddress.trim();
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName == null ? null : urlName.trim();
    }

    public Integer getUrlLevel() {
        return urlLevel;
    }

    public void setUrlLevel(Integer urlLevel) {
        this.urlLevel = urlLevel;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public Integer getUrlSequence() {
        return urlSequence;
    }

    public void setUrlSequence(Integer urlSequence) {
        this.urlSequence = urlSequence;
    }

    public Byte getParentYes() {
        return parentYes;
    }

    public void setParentYes(Byte parentYes) {
        this.parentYes = parentYes;
    }
}