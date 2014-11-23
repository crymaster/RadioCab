/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import db.ConfigApp;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author quangphamngoc
 */
public class AppUtil {

    public static final int maxRelatedDescriptionLength = 120;
    public static final int maxPopularDescriptionLength = 120;
    public static final int maxProductDescriptionInAdminLength = 60;

    public static String forDateMMMYYYY(Date sourceDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy");
        return sdf.format(sourceDate);
    }

    public static String forIsoDateForInput(Date sourceDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(sourceDate);
    }

    public static String formatDateForComments(Timestamp timestamp) {
        //September 28, 2013 at 3:32 pm
        SimpleDateFormat dateSDF = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat timeSDF = new SimpleDateFormat("HH:mm:ss");
        String dateString = dateSDF.format(timestamp);
        String timeString = timeSDF.format(timestamp);
        return dateString + " at " + timeString;
    }

    public static String formatDateForEventDurationAdmin(Date start, Date end) {
        //September 28, 2013 at 3:32 pm
        SimpleDateFormat dateSDF = new SimpleDateFormat("MMM dd");
        String fromString = dateSDF.format(start);
        String endString = dateSDF.format(end);
        return fromString + " to " + endString;
    }

    public static String formatDateForNewestComments(Timestamp timestamp) {
        //12. July, 2013
        SimpleDateFormat dateSDF = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat timeSDF = new SimpleDateFormat("HH:mm:ss");
        String dateString = dateSDF.format(timestamp);
        String timeString = timeSDF.format(timestamp);
        return dateString + " at " + timeString;
    }

    public static String subStringForRelatedProductDesciption(String originalDescription) {
        if (originalDescription.length() < maxRelatedDescriptionLength) {
            return originalDescription;
        } else {
            return originalDescription.substring(0, maxRelatedDescriptionLength - 3) + "...";
        }
    }

    public static String subStringForPopularProductHomePage(String originalDescription) {
        if (originalDescription.length() < maxPopularDescriptionLength) {
            return originalDescription;
        } else {
            return originalDescription.substring(0, maxRelatedDescriptionLength - 3) + "...";
        }
    }

    public static String subStringForProductDesciptionInAdmin(String originalDescription) {
        if (originalDescription.length() < maxProductDescriptionInAdminLength) {
            return originalDescription;
        } else {
            return originalDescription.substring(0, maxProductDescriptionInAdminLength - 3) + "...";
        }
    }

    public static String formatMoneyNumber(float money) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(money)+"$";
    }

    public static String formatNullString(String nullString) {
        if (nullString == null) {
            return "";
        }
        return nullString;
    }

    public static String getClientOrderStatusString(int status) {
        if (status == 1) {
            return ConfigApp.orderConfirmedStatusClientString;
        } else if (status == 2) {
            return ConfigApp.orderApprovedStatusClientString;
        } else {
            return ConfigApp.orderSubmitStatusClientString;
        }
    }

    public static String getServerOrderStatusString(int status) {
        if (status == 1) {
            return ConfigApp.orderConfirmedStatusServerString;
        } else if (status == 2) {
            return ConfigApp.orderApprovedStatusServerString;
        } else {
            return ConfigApp.orderSubmitStatusServerString;
        }
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
