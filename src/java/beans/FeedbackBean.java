/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author son
 */
public class FeedbackBean {

    private String fbName;
    private String fbType;
    private String fbMobile;
    private String fbEmail;
    private int fbCity;
    private String fbDescription;

    public String getFbName() {
        return fbName;
    }

    public void setFbName(String fbName) {
        this.fbName = fbName;
    }

    public String getFbType() {
        return fbType;
    }

    public void setFbType(String fbType) {
        this.fbType = fbType;
    }

    public String getFbMobile() {
        return fbMobile;
    }

    public void setFbMobile(String fbMobile) {
        this.fbMobile = fbMobile;
    }

    public String getFbEmail() {
        return fbEmail;
    }

    public void setFbEmail(String fbEmail) {
        this.fbEmail = fbEmail;
    }

    public int getFbCity() {
        return fbCity;
    }

    public void setFbCity(int fbCity) {
        this.fbCity = fbCity;
    }

    public String getFbDescription() {
        return fbDescription;
    }

    public void setFbDescription(String fbDescription) {
        this.fbDescription = fbDescription;
    }

}
