package com.devanshi.tambola.ticketgenerator.app.utils;

/**
 * Manages public constants.
 */
public class Constants {

    /**
     * Max time interval to prevent double click
     */
    public static final long MAX_CLICK_INTERVAL = 500;

    public static final String ASSETS_FOLDER_FONTS = "Fonts/";

    /**
     * Intent Filter Actions
     */
    public static final String INTENT_FILTER_ACTION_ORDER_PLACED = "order_placed";
    public static final String INTENT_FILTER_ACTION_OSP_LOGIN = "osp_login";

    /**
     * Intent-Bundle Keys
     */
    public static final String INTENT_KEY_APPLY_FILTER = "INTENT_KEY_APPLY_FILTER";
    public static final String INTENT_KEY_FILTER_SELECTION = "INTENT_KEY_FILTER_SELECTION";
    public static final String PUSH_PARAM_ORDER_ID = "o_id";
    public static final String PUSH_PARAM_ORDER_TITLE = "title";
    public static final String PUSH_PARAM_ORDER_BODY = "body";

    public static final int REQUEST_CODE_FILTER_APPLY = 100;
    public static final int REQUEST_CODE_SORT_APPLY = 200;

    public static final String BUNDLE_COUNTRY_ID = "BUNDLE_COUNTRY_ID";
    public static final String BUNDLE_IS_SHIPPING_COUNTRY_SELECTION = "BUNDLE_IS_SHIPPING_COUNTRY_SELECTION";
    public static final String BUNDLE_COUNTRY_CODE = "BUNDLE_COUNTRY_CODE";
    public static final String BUNDLE_COUNTRY_NAME = "BUNDLE_COUNTRY_NAME";
    public static final String BUNDLE_IS_COUNTRY_HAS_REGION = "BUNDLE_IS_COUNTRY_HAS_REGION";
    public static final String BUNDLE_REGION_ID = "BUNDLE_REGION_ID";
    public static final String BUNDLE_REGION_NAME = "BUNDLE_REGION_NAME";
    public static final String BUNDLE_IMAGE_ARRAY_LIST = "BUNDLE_IMAGE_ARRAY_LIST";
    public static final String BUNDLE_IMAGE_POSITION = "BUNDLE_IMAGE_POSITION";
    public static final String BUNDLE_IMAGE_PATH = "BUNDLE_IMAGE_PATH";
    public static final String BUNDLE_PRODUCT_MODEL = "BUNDLE_PRODUCT_MODEL";
    public static final String BUNDLE_PRODUCT_ID = "BUNDLE_PRODUCT_ID";
    public static final String BUNDLE_CATEGORY_ID = "BUNDLE_CATEGORY_ID";
    public static final String BUNDLE_CATEGORY_NAME = "BUNDLE_CATEGORY_NAME";
    public static final String BUNDLE_IS_FROM_SPLASH = "BUNDLE_IS_FROM_SPLASH";
    public static final String BUNDLE_IS_FROM_MYCART = "BUNDLE_IS_FROM_MYCART";
    public static final String BUNDLE_SUPPLIER_ID = "BUNDLE_SUPPLIER_ID";
    public static final String BUNDLE_SUPPLIER_NAME = "BUNDLE_SUPPLIER_NAME";
    public static final String BUNDLE_FILE_NAME = "BUNDLE_FILE_NAME";
    public static final String BUNDLE_SCREEN_TITLE = "BUNDLE_SCREEN_TITLE";
    public static final String BUNDLE_IMAGE_RESOURCE = "BUNDLE_IMAGE_RESOURCE";
    public static final String BUNDLE_ADDRESS_MODEL = "BUNDLE_ADDRESS_MODEL";
    public static final String BUNDLE_FILTER_MODEL = "BUNDLE_FILTER_MODEL";
    public static final String BUNDLE_FROM_SOURCING_REQUEST = "BUNDLE_FROM_SOURCING_REQUEST";
    public static final String BUNDLE_PRODUCT_LIST = "BUNDLE_PRODUCT_LIST";
    public static final String BUNDLE_FILTER_OPTIONS = "BUNDLE_FILTER_OPTIONS";
    public static final String BUNDLE_FILTER_SELECTION = "BUNDLE_FILTER_SELECTION";
    public static final String BUNDLE_OPTION_MODEL = "BUNDLE_OPTION_MODEL";
    public static final String BUNDLE_CART_MODEL = "BUNDLE_CART_MODEL";
    public static final String HASHMAP_BILLING_ADDRESS = "HASHMAP_BILLING_ADDRESS";
    public static final String HASHMAP_SHIPPING_ADDRESS = "HASHMAP_SHIPPING_ADDRESS";
    public static final String BUNDLE_ADDRESS_TARGET_REUEST_CODE = "BUNDLE_ADDRESS_TARGET_REUEST_CODE";
    public static final String BUNDLE_ADDRESS_LIST_SIZE = "BUNDLE_ADDRESS_LIST_SIZE";
    public static final String BUNDLE_ORDER_ID = "BUNDLE_ORDER_ID";
    public static final String BUNDLE_ORDER_REMARK = "BUNDLE_ORDER_REMARK";
    public static final String BUNDLE_INCREMENT_ID = "BUNDLE_INCREMENT_ID";
    public static final String BUNDLE_SERVICE_POINT_ID = "BUNDLE_SERVICE_POINT_ID";
    public static final String BUNDLE_REQUEST_ID = "BUNDLE_REQUEST_ID";
    public static final String BUNDLE_POST_SOURCING_REQUEST_MODEL = "BUNDLE_POST_SOURCING_REQUEST_MODEL";
    public static final String BUNDLE_SORTING_OPTION = "BUNDLE_SORTING_OPTION";
    public static final String BUNDLE_QR_CODE_VALUE = "BUNDLE_QR_CODE_VALUE";
    public static final String BUNDLE_ADDRESS_ID = "BUNDLE_ADDRESS_ID";
    public static final String BUNDLE_IS_FROM_PUSH_NOTIFICATION = "BUNDLE_IS_FROM_PUSH_NOTIFICATION";
    public static final String BUNDLE_UNIT_NAME = "BUNDLE_UNIT_NAME";
    public static final String BUNDLE_ITEM_SELECTION = "BUNDLE_ITEM_SELECTION";
    public static final String BUNDLE_UNIT_ID = "BUNDLE_UNIT_ID";
    public static final String BUNDLE_ORDER_STATUS = "BUNDLE_ORDER_STATUS";
    public static final String BUNDLE_TRACKING_LIST_MODEL = "BUNDLE_TRACKING_LIST_MODEL";
    public static final String BUNDLE_CARRIER_ID = "BUNDLE_CARRIER_ID";
    public static final String BUNDLE_CARRIER_NAME = "BUNDLE_CARRIER_NAME";
    public static final String BUNDLE_SHIPPING_AMOUNT = "BUNDLE_SHIPPING_AMOUNT";
    public static final String BUNDLE_OSP_ORDER_DETAIL_MODEL = "BUNDLE_OSP_ORDER_DETAIL_MODEL";

    public static final String BUNDLE_IS_CREATE_USER = "BUNDLE_IS_CREATE_USER";
    public static final String BUNDLE_APP_SHORTCUT_SCREEN = "BUNDLE_APP_SHORTCUT_SCREEN";


    public static final String BUNDLE_SUB_USER_MODEL = "BUNDLE_SUB_USER_MODEL";
    public static final String BUNDLE_PRODUCT_OPTIONS_ALL = "BUNDLE_PRODUCT_OPTIONS_ALL";
    public static final String BUNDLE_PRODUCT_OPTIONS_SELECTED = "BUNDLE_PRODUCT_OPTIONS_SELECTED";
    public static final String BUNDLE_APPLY_SELECTION = "BUNDLE_APPLY_SELECTION";


    public static final int REQUEST_CODE_QR_CODE = 101;
    public static final int REQUEST_CODE_SELECT_UNIT = 102;
    public static final int REQUEST_CODE_SELECT_COUNTRY = 103;
    public static final int REQUEST_CODE_SELECT_REGION = 104;
    public static final int REQUEST_CODE_PRODUCT_OPTIONS = 105;

    //    public static final String RATING_ROUND_FORMAT = "#.0";
    public static final String RATING_ROUND_FORMAT = "0.0";

    public static final int IMAGE_ADD_LIMIT = 3;
    public static final int RECENT_SEARCH_SHOW_LIMIT = 5;
    //    public static final double MINIMUM_ORDER_AMOUNT = 500;
    public static final int STATUS_CODE_RESEND_MAIL = 201;
    public static final int STATUS_CODE_CART_EMPTY = 202;

    public static final String UPDATE = "update";
    public static final String ADD = "add";
    public static final String REFRESH = "refresh";

    public static final String TAG="debuglog";


}
