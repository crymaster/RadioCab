<%-- 
    Document   : doAddCustomer
    Created on : Aug 18, 2014, 3:26:10 PM
    Author     : quangphamngoc
--%>

<%@page import="db.MembertypeDB"%>
<%@page import="beans.MembertypeBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    
    JSONObject json = new JSONObject();
    MembertypeBean item = new MembertypeBean();
        String name = request.getParameter("name");
        item.setMem_Name(name);
        String fee = request.getParameter("fee");
        item.setMem_Fee(Float.parseFloat(fee));
        int insertedID = MembertypeDB.addMembertype(item);
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
