<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>

<%@page import="db.AdvertiseDB"%>
<%@page import="beans.AdvertiseBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    AdvertiseBean item = new AdvertiseBean();
    String productImage = request.getParameter("productImageName");
    item.setAdv_Image(productImage);
    String des = request.getParameter("des");
    item.setAdv_Description(des);
    String stt = request.getParameter("status");
    item.setAdv_Status(Integer.parseInt(stt));
    String itemID = request.getParameter("itemID");
    item.setAdv_ID(Integer.parseInt(itemID));
    boolean status = AdvertiseDB.editAdvertise(item);

    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully edit item");
    } else {
        json.put("msg", "An error occured! Please try again");
    }
    json.put("status", status);
    out.print(json);
    out.flush();
%>