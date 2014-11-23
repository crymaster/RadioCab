<%-- 
    Document   : doRemoveProductFromEvent
    Created on : Sep 5, 2014, 4:57:48 PM
    Author     : quangphamngoc
--%>

<%@page import="beans.ProductBean"%>
<%@page import="java.util.List"%>
<%@page import="db.ProductDB"%>
<%@page import="db.OfferDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    String offerID = request.getParameter("eventid");
    String productID = request.getParameter("productid");
    boolean status = OfferDB.removeProductFromEvent(Integer.parseInt(offerID), Integer.parseInt(productID));
    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully remove  item");
        
    } else {
        json.put("msg", "Error!");
    }
    json.put("href", "eventproduct.jsp?id=" + offerID);
    json.put("status", status);
    out.print(json);
    out.flush();
%>