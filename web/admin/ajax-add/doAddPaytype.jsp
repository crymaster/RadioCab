<%-- 
    Document   : doAddCustomer
    Created on : Aug 18, 2014, 3:26:10 PM
    Author     : quangphamngoc
--%>

<%@page import="db.PaymenttypeDB"%>
<%@page import="beans.PaymenttypeBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    PaymenttypeBean item = new PaymenttypeBean();
    String fors = request.getParameter("fors");
    item.setPaytype_For(fors);
    String name = request.getParameter("name");
    item.setPaytype_Name(name);
    String day = request.getParameter("day");
    item.setPaytype_Days(Integer.parseInt(day));
    String fee = request.getParameter("fee");
    item.setPaytype_Fee(Float.parseFloat(fee));
    int insertedID = PaymenttypeDB.addPaymenttype(item);
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
