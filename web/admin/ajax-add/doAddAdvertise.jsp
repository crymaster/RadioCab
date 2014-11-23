<%-- 
    Document   : doAddCustomer
    Created on : Aug 18, 2014, 3:26:10 PM
    Author     : quangphamngoc
--%>

<%@page import="db.AdvertiseDB"%>
<%@page import="beans.AdvertiseBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    AdvertiseBean item = new AdvertiseBean();
    String company = request.getParameter("company");
    item.setCom_ID(Integer.parseInt(company));
    String productImage = request.getParameter("productImageName");
    item.setAdv_Image(productImage);
    String des = request.getParameter("des");
    item.setAdv_Description(des);
    
    int insertedID = AdvertiseDB.addAdvertise(item);
    boolean status = (insertedID == -1) ? false : true;
    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully added new item");
        json.put("insertedID", insertedID);
    } else {
        json.put("msg", "An error occured! Please try again");
    }
    json.put("status", status);
    out.print(json);
    out.flush();
%>
