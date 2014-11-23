<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>



<%@page import="db.PermissionDB"%>
<%@page import="beans.PermissionBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    String itemID = request.getParameter("itemID");
    List<PermissionBean> list = PermissionDB.getPermissionByRoleID(Integer.parseInt(itemID));
    for(PermissionBean v: list){
        String status = request.getParameter(String.valueOf(v.getActID()));
        if(status != null){
            v.setPerStatus(Integer.parseInt(status));
        }else{
            v.setPerStatus(0);
        }
    }
    boolean status = PermissionDB.editPermission(list);

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