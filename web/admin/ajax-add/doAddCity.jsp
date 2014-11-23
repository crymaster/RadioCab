<%-- 
    Document   : doAddCustomer
    Created on : Aug 18, 2014, 3:26:10 PM
    Author     : quangphamngoc
--%>

<%@page import="db.CityDB"%>
<%@page import="beans.CityBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    
    JSONObject json = new JSONObject();
    CityBean item = new CityBean();
        String name = request.getParameter("name");
        item.setCity_Name(name);
        int insertedID = CityDB.addCity(item);
        boolean status  = (insertedID == -1) ? false : true;
        json = new JSONObject();
        if (status){
            json.put("msg", "Successfully added new item");
            json.put("insertedID", insertedID);
        }
        else{
            json.put("msg", "An error occured! Please try again");
        }
        json.put("status", status);
        out.print(json);
        out.flush();
%>
