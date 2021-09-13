package com.devanshi.tambola.ticketgenerator.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerNameData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("profile_code")
    @Expose
    private String profileCode;
    @SerializedName("referral_code")
    @Expose
    private Object referralCode;
    @SerializedName("connected_admin_id")
    @Expose
    private Integer connectedAdminId;
    @SerializedName("device_type")
    @Expose
    private String deviceType;
    @SerializedName("device_token")
    @Expose
    private String deviceToken;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("remember_token")
    @Expose
    private Object rememberToken;
    @SerializedName("settings")
    @Expose
    private Object settings;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlayerNameData withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public PlayerNameData withRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerNameData withName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PlayerNameData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public PlayerNameData withMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public PlayerNameData withProfileCode(String profileCode) {
        this.profileCode = profileCode;
        return this;
    }

    public Object getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(Object referralCode) {
        this.referralCode = referralCode;
    }

    public PlayerNameData withReferralCode(Object referralCode) {
        this.referralCode = referralCode;
        return this;
    }

    public Integer getConnectedAdminId() {
        return connectedAdminId;
    }

    public void setConnectedAdminId(Integer connectedAdminId) {
        this.connectedAdminId = connectedAdminId;
    }

    public PlayerNameData withConnectedAdminId(Integer connectedAdminId) {
        this.connectedAdminId = connectedAdminId;
        return this;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public PlayerNameData withDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public PlayerNameData withDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public PlayerNameData withAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public PlayerNameData withEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PlayerNameData withPassword(String password) {
        this.password = password;
        return this;
    }

    public Object getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(Object rememberToken) {
        this.rememberToken = rememberToken;
    }

    public PlayerNameData withRememberToken(Object rememberToken) {
        this.rememberToken = rememberToken;
        return this;
    }

    public Object getSettings() {
        return settings;
    }

    public void setSettings(Object settings) {
        this.settings = settings;
    }

    public PlayerNameData withSettings(Object settings) {
        this.settings = settings;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public PlayerNameData withCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PlayerNameData withUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public PlayerNameData() {
        this.id = -1;
        this.roleId = -1;
        this.name = "Select Player Name";
        this.email = "";
        this.mobileNo = "";
        this.profileCode = "";
        this.referralCode = "";
        this.connectedAdminId = -1;
        this.deviceType = "";
        this.deviceToken = "";
        this.avatar = "";
        this.emailVerifiedAt = null;
        this.password = "";
        this.rememberToken = null;
        this.settings = null;
        this.createdAt = null;
        this.updatedAt = null;
    }

}
