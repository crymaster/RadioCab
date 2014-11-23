<%-- 
    Document   : doEditProfile
    Created on : Aug 19, 2014, 4:25:29 PM
    Author     : quangphamngoc
--%>

<%@page import="db.AdminDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    String change = request.getParameter("change");
    if(change.equalsIgnoreCase("avatar")){
        String fileName = request.getParameter("avatar");
        String itemID = request.getParameter("itemID");
        
        boolean status = AdminDB.changeAvatar(fileName, Integer.parseInt(itemID));
        json = new JSONObject();
        if (status){
            json.put("msg", "Successfully edit item");
        }
        else{
            json.put("msg", "An error occured! Please try again");
        }
        json.put("status", status);
        out.print(json);
        out.flush();
    } else if(change.equalsIgnoreCase("password")) {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String itemID = request.getParameter("itemID");
        int result = AdminDB.changePassword(oldPassword, newPassword, Integer.parseInt(itemID));
        boolean status = false;
        json = new JSONObject();
        switch(result){
            case 0:
                json.put("msg", "Connect SQL error");
                break;
            case 1:
                json.put("msg", "Wrong Old Password");
                break;
            case 2:
                json.put("msg", "Failed to update new password");
                break;
            case 3:
                status = true;
                json.put("msg", "Successfully changed password");
                break;  
            default:
                json.put("msg", "Unknown error");
                break;
        }
        
        
       
        json.put("status", status);
        out.print(json);
        out.flush();
    }
        
        
%>