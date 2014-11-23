<%-- 
    Document   : doApproveOrder
    Created on : Sep 8, 2014, 8:44:09 AM
    Author     : quangphamngoc
--%>
<%@page import="beans.BillBean"%>
<%@page import="db.BillDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    String itemID = request.getParameter("id");
    BillBean bill = BillDB.getOrderByID(Integer.parseInt(itemID));
    boolean status = false;
    if (bill.getBill_Status() == 1) {
        
        bill.setListDetails(BillDB.getAllBillDetailByBillId(Integer.parseInt(itemID)));
        status = BillDB.approveBill(bill);
        if (status) {
            json.put("msg", "Successfully edit item");
        } else {
            json.put("msg", BillDB.errorString);
        }
    } else {
        status = false;
        json.put("msg", "Bill must be confirmed before being approved");
    }

    json.put("status", status);
    out.print(json);
    out.flush();
%>