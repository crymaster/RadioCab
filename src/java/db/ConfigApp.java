/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

/**
 *
 * @author quangphamngoc
 */
public class ConfigApp {
    public static final int statusOKValue = 1;
    public static final int statusNotOKValue = 0;
    public static final int statusNotActiveValue = 2;
    public static final String statusOK = "Enable";
    public static final String statusNotOK = "Disable";
    public static final String statusNotActive = "Not Activated Yet";
    
    public static final String UPLOAD_IMAGE_FOLDER = "app_images";
    public static final String UPLOAD_PRODUCT_IMAGE_FOLDER = "product_images";
    
    
    
    public static final int eventStatusApplying = 1;
    public static final int eventStatusComing = 0;
    public static final int eventStatusEnded = -1;
    
    public static final String eventApplying = "Applying";
    public static final String eventComing = "Coming";
    public static final String eventEnded = "Ended";
    
    
    public static final int orderSubmitStatus = 0;
    public static final int orderConfirmedStatus = 1;
    public static final int orderApprovedStatus = 2;
    
    public static final String orderSubmitStatusClientString = "Recorded - Reviewing";
    public static final String orderConfirmedStatusClientString = "Confirmed";
    public static final String orderApprovedStatusClientString = "Paid";
    
    public static final String orderSubmitStatusServerString = "Recorded";
    public static final String orderConfirmedStatusServerString = "Confirmed";
    public static final String orderApprovedStatusServerString = "Approved";
    
}
