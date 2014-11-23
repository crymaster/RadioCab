<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>

<%@page import="db.CityDB"%>
<%@page import="beans.CityBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    CityBean item = new CityBean();
    String stt = request.getParameter("status");
    item.setCity_Status(Integer.parseInt(stt));
    String itemID = request.getParameter("itemID");
    item.setCity_ID(Integer.parseInt(itemID));
    boolean status = CityDB.editCity(item);

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