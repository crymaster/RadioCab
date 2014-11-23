<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>

<%@page import="db.MembertypeDB"%>
<%@page import="beans.MembertypeBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    MembertypeBean item = new MembertypeBean();
    String fee = request.getParameter("fee");
    item.setMem_Fee(Float.parseFloat(fee));
    String stt = request.getParameter("status");
    item.setMem_Status(Integer.parseInt(stt));
    String itemID = request.getParameter("itemID");
    item.setMem_ID(Integer.parseInt(itemID));
    boolean status = MembertypeDB.editMembertype(item);

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