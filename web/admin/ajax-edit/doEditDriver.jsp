<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>

<%@page import="db.DriverDB"%>
<%@page import="beans.DriverBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    DriverBean item = new DriverBean();
    String name = request.getParameter("name");
    item.setDriver_Name(name);
    String contact = request.getParameter("contact");
    item.setDriver_Contactperson(contact);
    String city = request.getParameter("city");
    item.setCity_ID(Integer.parseInt(city));
    String address = request.getParameter("address");
    item.setDriver_Address(address);
    String productImage = request.getParameter("productImageName");
    item.setDriver_Image(productImage);
    String mobile = request.getParameter("mobile");
    item.setDriver_Mobile(mobile);
    String tel = request.getParameter("tel");
    item.setDriver_Tel(tel);
    String email = request.getParameter("email");
    item.setDriver_Email(email);
    String exp = request.getParameter("exp");
    item.setDriver_Exp(exp);
    String des = request.getParameter("des");
    item.setDriver_Description(des);
    String stt = request.getParameter("status");
    item.setDriver_Status(Integer.parseInt(stt));
    String itemID = request.getParameter("itemID");
    item.setDriver_ID(Integer.parseInt(itemID));
    boolean status = DriverDB.editDriver(item);

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