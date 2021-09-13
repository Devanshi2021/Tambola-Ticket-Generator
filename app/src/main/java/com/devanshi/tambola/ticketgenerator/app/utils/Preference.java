package com.devanshi.tambola.ticketgenerator.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.devanshi.tambola.ticketgenerator.app.R;


/**
 * Preference class to use SharedPreference class through out application. Use this class to store or retrieve data from SharedPreference.
 */
public class Preference {
    /**
     * Preference key for userId
     */
    private final String USER_ID = "USER_ID";
    private final String IMAGE_PICKER_USED = "IMAGE_PICKER_USED";
    private final String USER_PREFIX = "USER_PREFIX";
    private final String USER_FIRST_NAME = "USER_FIRST_NAME";
    private final String USER_LAST_NAME = "USER_LAST_NAME";
    private final String USER_EMAIL = "USER_EMAIL";
    private final String DEVICE_ID = "DEVICE_ID";
    private final String PUSH_NOTIFICATION_TOKEN = "PUSH_NOTIFICATION_TOKEN";
    private final String TOKEN_REGISTERED_ON_SERVER = "TOKEN_REGISTERED_ON_SERVER";
    private final String USER_TYPE = "USER_TYPE";
    private final String USER_SETTINGS = "USER_SETTINGS";
    private final String PARENT_USER_ID = "PARENT_USER_ID";
    private final String OFFLINE_PRODUCT_JSON = "OFFLINE_PRODUCT_JSON";
    private final String OFFLINE_CUSTOMER_JSON = "OFFLINE_CUSTOMER_JSON";
    private final String OFFLINE_ORDER_ARRAY = "OFFLINE_ORDER_ARRAY";
    private final String OFFLINE_CITY_ARRAY = "OFFLINE_CITY_ARRAY";
    private final String OFFLINE_NEW_CUSTOMER_ARRAY = "OFFLINE_NEW_CUSTOMER_ARRAY";
    private final String RUN_APP_OFFLINE = "RUN_APP_OFFLINE";
    private final String UPDATE_CUSTOMER = "UPDATE_CUSTOMER";
    private final String PREVIOUS_FRAGMENT = "PREVIOUS_FRAGMENT";
    private final String SCANNED_ITEM_ID = "SCANNED_ITEM_ID";
    private final String UPDATE_PRODUCT = "UPDATE_PRODUCT";
    private final String UPDATE_BARCODE = "UPDATE_BARCODE";

    /**
     * Shared Preference instance
     */
    private SharedPreferences sharedPreferences;

    private Context context;


    public Preference(Context context) {
        sharedPreferences = (SharedPreferences) context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
        this.context = context;
    }

    /**
     * Returns the userId from the Shared Preference file
     *
     * @return userId
     */
    public Integer getUserId() {
        return sharedPreferences.getInt(USER_ID, -1);
    }

    /**
     * Stores the userId into Shared Preference file
     */
    public void setUserId(final Integer userId) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(USER_ID, userId);
        editor.commit();
    }

    /**
     * Returns the user is login or not from the Shared Preference file
     *
     * @return userId
     */
    public boolean isImagePickerUsed() {
        return sharedPreferences.getBoolean(IMAGE_PICKER_USED, false);
    }


    /**
     * Stores user is login or not into Shared Preference file
     */
    public void setImagePickerUsed(boolean isImagePickerUsed) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IMAGE_PICKER_USED, isImagePickerUsed);
        editor.commit();
    }

    /**
     * Clears the all Shared Preference data
     */
    public void clearAllPreferenceData() {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }


    /**
     * Returns the User Prefix from Shared Preference file
     */
    public String getUserPrefix() {
        return sharedPreferences.getString(USER_PREFIX, "");
    }

    /**
     * Stores the User Prefix into Shared Preference file
     */
    public void setUserPrefix(String userPrefix) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_PREFIX, userPrefix);
        editor.commit();
    }

    /**
     * Returns the User First Name from Shared Preference file
     */
    public String getUserFirstName() {
        return sharedPreferences.getString(USER_FIRST_NAME, "");
    }

    /**
     * Stores the User First Name into Shared Preference file
     */
    public void setUserFirstName(String userFirstName) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_FIRST_NAME, userFirstName);
        editor.commit();
    }

    /**
     * Returns the User Last Name from Shared Preference file
     */
    public String getUserLastName() {
        return sharedPreferences.getString(USER_LAST_NAME, "");
    }

    /**
     * Stores the User First Name into Shared Preference file
     */
    public void setUserLastName(String userLastName) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_LAST_NAME, userLastName);
        editor.commit();
    }

    /**
     * Returns the User email from Shared Preference file
     */
    public String getUserEmail() {
        return sharedPreferences.getString(USER_EMAIL, "");
    }

    /**
     * Stores the User email into Shared Preference file
     */
    public void setUserEmail(String userEmail) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_EMAIL, userEmail);
        editor.commit();
    }

    /**
     * Returns the device id from Shared Preference file
     */
    public String getDeviceId() {
        return sharedPreferences.getString(DEVICE_ID, "");
    }

    /**
     * Stores the device id into Shared Preference file if not stored
     */
    public void setDeviceIdIfNotStored(String deviceId) {
        if (TextUtils.isEmpty(sharedPreferences.getString(DEVICE_ID, ""))) {
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(DEVICE_ID, deviceId);
            editor.commit();
        }
    }



    /**
     * Returns the token is registered or not on server from Shared Preference file
     */
    public String isTokenRegisteredOnServer() {
        return sharedPreferences.getString(TOKEN_REGISTERED_ON_SERVER, "");
    }

    /**
     * Stores the push notification token into Shared Preference file
     */
    public void setTokenRegistered(String registeredToken) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_REGISTERED_ON_SERVER, registeredToken);
        editor.commit();
    }

    /**
     * Returns the user type from Shared Preference file
     */
    public Integer getUserType() {
        return sharedPreferences.getInt(USER_TYPE, -1);
    }

    /**
     * Stores the user type into Shared Preference file if not stored
     */
    public void setUserType(Integer userType) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(USER_TYPE, userType);
        editor.commit();
    }

    /**
     * Returns the user name from Shared Preference file
     */
    public String getUserSettings() {
        return sharedPreferences.getString(USER_SETTINGS, "");
    }

    /**
     * Stores the user type into Shared Preference file if not stored
     */
    public void setUserSetting(String userName) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_SETTINGS, userName);
        editor.commit();
    }

    /**
     * Returns the parent user id. It will be available for sub osp users only.
     */
    private int getParentUserId() {
        return sharedPreferences.getInt(PARENT_USER_ID, 0);
    }

    /**
     * Sets the parent user id.
     */
    public void setParentUserId(int parentUserId) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PARENT_USER_ID, parentUserId);
        editor.commit();
    }

    public String getOfflineProductJSON(){
    return sharedPreferences.getString(OFFLINE_PRODUCT_JSON,"");
    }

    public void storeOfflineProductJSON(String jsonString){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(OFFLINE_PRODUCT_JSON, jsonString);
        editor.commit();
    }

    public String getOfflineCustomerJSON(){
        return sharedPreferences.getString(OFFLINE_CUSTOMER_JSON,"");
    }

    public void storeOfflineCustomerJSON(String jsonString){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(OFFLINE_CUSTOMER_JSON, jsonString);
        editor.commit();
    }

    public String getOrderArray(){
        return sharedPreferences.getString(OFFLINE_ORDER_ARRAY,"");
    }

    public void storeOfflineOrderArray(String array){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(OFFLINE_ORDER_ARRAY, array);
        editor.commit();
    }

    public boolean canAppRunOffline(){
        return sharedPreferences.getBoolean(RUN_APP_OFFLINE, false);
    }

    public void setAppCanRunOffline(){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(RUN_APP_OFFLINE, true);
        editor.commit();
    }

    public String getCityArray(){
        return sharedPreferences.getString(OFFLINE_CITY_ARRAY,"");
    }

    public void setCityArray(String cityJson){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(OFFLINE_CITY_ARRAY, cityJson);
        editor.commit();
    }

    public String getOfflineNewCustomerArray() {
        return sharedPreferences.getString(OFFLINE_NEW_CUSTOMER_ARRAY,"");
    }

    public void setOfflineNewCustomerArray(String offlineNewCustomerArray){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(OFFLINE_NEW_CUSTOMER_ARRAY, offlineNewCustomerArray);
        editor.commit();
    }

    public String getCustomerDetailsToBeUpdated(){
        return sharedPreferences.getString(UPDATE_CUSTOMER,"");
    }

    public void setCustomerDetailsToBeUpdated(String customerDetailsToBeUpdated){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UPDATE_CUSTOMER, customerDetailsToBeUpdated);
        editor.commit();
    }

    public String getPrevousFragmentForAddUpdate(){
        return sharedPreferences.getString(PREVIOUS_FRAGMENT,"");
    }

    public void setPrevousFragmentForAddUpdate(String prevousFragmentForAddUpdate){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREVIOUS_FRAGMENT, prevousFragmentForAddUpdate);
        editor.commit();
    }

    public String getScannedItemId(){
        return sharedPreferences.getString(SCANNED_ITEM_ID,"0");
    }

    public void setScannedItemId(String scannedItemId){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SCANNED_ITEM_ID, scannedItemId);
        editor.commit();
    }

    public String getProductDetailsToBeUpdated(){
        return sharedPreferences.getString(UPDATE_PRODUCT,"");
    }

    public void setProductDetailsToBeUpdated(String productDetailsToBeUpdated){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UPDATE_PRODUCT, productDetailsToBeUpdated);
        editor.commit();
    }

    public boolean getBarcodeEditText(){
        return sharedPreferences.getBoolean(UPDATE_BARCODE,false);
    }

    public void setBarcodeEditText(boolean isBarcodeEditText){
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(UPDATE_BARCODE, isBarcodeEditText);
        editor.commit();
    }
}
