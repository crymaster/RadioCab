<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>

<%@page import="db.PaymenttypeDB"%>
<%@page import="beans.PaymenttypeBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    PaymenttypeBean item = new PaymenttypeBean();
    String fee = request.getParameter("fee");
    item.setPaytype_Fee(Float.parseFloat(fee));
    String stt = request.getParameter("status");
    item.setPaytype_Status(Integer.parseInt(stt));
    String itemID = request.getParameter("itemID");
    item.setPaytype_ID(Integer.parseInt(itemID));
    boolean status = PaymenttypeDB.editPaymenttype(item);

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