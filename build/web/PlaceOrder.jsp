<%@page import="lk.ijse.dto.ItemDTO"%>
<%@page import="lk.ijse.business.custom.impl.ItemBOImpl"%>
<%@page import="lk.ijse.dto.OrderDTO"%>
<%@page import="lk.ijse.business.custom.impl.OrderBOImpl"%>
<%@page import="lk.ijse.dto.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lk.ijse.business.custom.impl.CustomerBOImpl"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,700">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/media-queries.css">

        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
        <script src="js/jquery.min.js"></script>

        <style>
            .selectbox{
                width: 100% ; 
                height: 30px; 
                margin: 0; 
                padding: 0 20px; 
                vertical-align: middle; 
                background: #fff; 
                border: 3px solid #fff; 
                font-family: 'Raleway', sans-serif; 
                font-size: 15px; 
                font-weight: 400; 
                line-height: 50px; 
                color: #888;
            }
        </style>

    </head>
    <body>

        <%
            ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
        %>



        <div class="top-content">
            <div class="container">

                <div class="row" style="height: 100px"></div>
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-10">
                        <div class="col-md-3">

                        </div>
                        <div class="col-md-3">
                            <a href="index.html">
                                <span class="img_icon icon2"></span>
                                <span class="link_title" style="color: white">Home</span>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="AllOrders.jsp">
                                <span class="img_icon icon3"></span>
                                <span class="link_title" style="color: white">All Orders</span>
                            </a>
                        </div>
                        <div class="col-md-3">

                        </div>  
                    </div>
                    <div class="col-md-1"></div>
                </div>

                <div class="row" style="height: 50px"></div>

                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1 class="wow fadeInLeftBig" style="color: #e36da1">Place Order</h1>
                    </div>
                </div>


                <div class="row" style="height: 10px"></div>

                <div class="row">
                    <div style="margin: 0px ; padding: 0px; border: 0px" class="col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp">
                        <div class="row" style="margin: 0px">

                            <div style="margin: 0px ; padding: 0px; border: 0px" class="col-md-6">
                                <div class="r-form-1-bottom">

                                    <form role="form" id="frm1" enctype="application/x-www-form-urlencoded" method="POST" action="ServeletPlaceOrder">
                                        <div class="form-group">
                                            <label>Date</label>
                                            <input type="text" name="txtDate"  class="r-form-1-first-name form-control" id="txtDate">
                                        </div>
                                        <div class="form-group">
                                            <label >Order Id</label>
                                            <input type="text" name="txtOrderId"  class="r-form-1-first-name form-control" id="txtOrderId">
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div style="margin: 0px ; padding: 0px; border: 0px" class="col-md-6">
                                <div class="r-form-1-bottom">
                                    <form role="form" id="frm2" enctype="application/x-www-form-urlencoded" method="POST" action="ServeletPlaceOrder">
                                        <div class="form-group">
                                            <label>Customer Id</label>
                                            <select class="selectbox" name="txtCustomerId" id="txtCustomerId" onchange="loadCustomerDetails(this.value)">
                                                <option selected disabled hidden>Select Customer ID</option>
                                                <%
                                                    CustomerBOImpl customerBO = (CustomerBOImpl) ctx.getBean("customerBOImpl");
                                                    ArrayList<CustomerDTO> customers = customerBO.getAll();
                                                    for (CustomerDTO customer : customers) {%>
                                                <option value="<%= customer.getId()%>"><%= customer.getId()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label >Customer Name</label>
                                            <input type="text" name="txtCustomerName"  class="r-form-1-last-name form-control" id="txtCustomerName">
                                        </div>
                                    </form>
                                </div>
                            </div>



                        </div>
                        <div class="row" style="height: 10px"></div>
                        <div class="row" style="margin: 0px">
                            <div class="r-form-1-top">
                                <div class="r-form-1-top-left">
                                    <h3>Item details</h3>
                                </div>
                            </div>
                            <div style="margin: 0px ; padding: 0px; border: 0px" class="col-md-6">
                                <div class="r-form-1-bottom">
                                    <form role="form" id="frm" enctype="application/x-www-form-urlencoded" method="POST" action="ServeletPlaceOrder">
                                        <div class="form-group">
                                            <label>Item Code</label>
                                            <select class="selectbox" name="txtItemCode" id="txtItemCode" onchange="loadItemDetails(this.value)">
                                                <option selected disabled hidden>Select Item Code</option>
                                                <%
                                                    ItemBOImpl itemBO = (ItemBOImpl) ctx.getBean("itemBOImpl");
                                                    ArrayList<ItemDTO> items = itemBO.getAll();
                                                    for (ItemDTO item : items) {%>
                                                <option value="<%= item.getCode()%>"><%= item.getCode()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label >Unit Price</label>
                                            <input type="text" name="txtUnitPrice"  class="r-form-1-last-name form-control" id="txtUnitPrice">
                                        </div>
                                        <div class="form-group">
                                            <label >Quantity</label>
                                            <input type="text" name="txtQuantity"  class="r-form-1-last-name form-control" id="txtQuantity">
                                        </div>
                                        <div class="form-group">
                                            <label ></label>
                                            <button style="height: 35px ; padding-top: -30px "  id="btnAdd" type="button" class="btn" onclick="addTable(document.getElementById('txtItemCode').value)">Add</button>
                                        </div>

                                    </form>
                                </div>
                            </div>
                            <div style="margin: 0px ; padding: 0px; border: 0px" class="col-md-6">
                                <div class="r-form-1-bottom">
                                    <form role="form" id="frm" enctype="application/x-www-form-urlencoded" method="POST" action="ServeletPlaceOrder">
                                        <div class="form-group">
                                            <label>Description</label>
                                            <input type="text" name="txtDescription"  class="r-form-1-first-name form-control" id="txtDescription">
                                        </div>
                                        <div class="form-group">
                                            <label >Qty on hand</label>
                                            <input type="text" name="txtQtyOnHand"  class="r-form-1-last-name form-control" id="txtQtyOnHand">
                                        </div>
                                        <div class="form-group">
                                            <label >Total</label>
                                            <input type="text" name="txtTotal" placeholder="0.0"  class="r-form-1-last-name form-control" id="txtTotal">
                                        </div>

                                        <div class="form-group">
                                            <label ></label>
                                            <button style="height: 35px ; padding-top: -30px "  id="btnSave" type="button" class="btn">Save</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div style="margin: 0px   " class="col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp">

                        <div  class="r-form-1-bottom">
                            <form role="form" id="frm" enctype="application/x-www-form-urlencoded" method="POST" action="Servelet">
                                <div style="height: 610px" class="form-group">
                                    <label></label>
                                    <div class="row">
                                        <table id="table" class="table table-responsive" style="background-color: whitesmoke ; border: solid 2px ">
                                            <thead>
                                                <tr >
                                                    <th style="background-color: transparent">Item Code</th>
                                                    <th style="background-color: transparent">Description</th>
                                                    <th style="background-color: transparent">Unit Price</th>
                                                    <th style="background-color: transparent">Quantity</th>
                                                    <th style="background-color: transparent">Amount</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>
                                    </div>


                                </div>




                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <script type="text/javascript">

//            function getOrderId() {
//                $.ajax("ServeletPlaceOrder", {
//                    accepts: {mycustomtype: "*/*"},
//                    data: {
//                        action: "getOrderId"
//                    },
//                    method: "POST"
//
//                }).done(function (responce) {
////           alert(responce);
//                    $("#txtOrderId").val(responce);
//                });
//            }
//            function createJson() {
//                var rowCount = document.getElementById('table').rows.length;
//                //alert(rowCount);
//                //for(int i=1;)
//            }



            function loadCustomerDetails(txtCustomerId) {
                $.ajax("ServeletPlaceOrder", {
                    accepts: {mycustomtype: "*/*"},
                    data: {
                        action: "search",
                        id: txtCustomerId
                    },
                    method: "POST"
                }).done(function (response) {
                    var message = JSON.parse(response);
                    $("#txtCustomerName").val(message.name);
                });
            }


            function loadItemDetails(txtItemCode) {

                $.ajax("ServeletPlaceOrder", {
                    accepts: {mycustomtype: "*/*"},
                    data: {
                        action: "search2",
                        id: txtItemCode
                    },
                    method: "POST"
                }).done(function (response) {
                    var message = JSON.parse(response);
                    $("#txtDescription").val(message.description);
                    $("#txtUnitPrice").val(message.unitPrice);
                    $("#txtQtyOnHand").val(message.qtyOnHand);
                });
            }

            var total = 0;
            function addTable(code)
            {


                var table = document.getElementById("table");
                var row = table.insertRow(1);
                var code = row.insertCell(0);
                var desc = row.insertCell(1);
                var unnitprice = row.insertCell(2);
                var qty = row.insertCell(3);
                var ammount = row.insertCell(4);
                var qtyV = document.getElementById("txtQuantity").value;
                var p = document.getElementById("txtUnitPrice").value;
                var ammountValue = qtyV * p;
                total += ammountValue;
                desc.innerHTML = document.getElementById("txtDescription").value;
                unnitprice.innerHTML = document.getElementById("txtUnitPrice").value;
                qty.innerHTML = qtyV;
                code.innerHTML = document.getElementById("txtItemCode").value;
                ammount.innerHTML = ammountValue;
                $("#txtTotal").val(total);
            }



//                $("#btnSave").click(function () {
//                    
////                    var table = $("#table").tableToJSON();
//                    
//                    $.ajax("ServeletPlaceOrder", {
//                        accepts: {mycustomtype: "*/*"},
//                        data: {
//                            action: "save",
//                            custId: txtCustomerId,
//                            orderId: document.getElementById("txtOrderId").value,
//                            date: document.getElementById("txtDate").value
////                            orderDetail: JSON.stringify(table)
//                        },
//                        method: "POST"
//                    }).done(function (responce) {
//                        alert(responce);
//                        if (responce) {
//                            location.reload();
//                        }
//                    });
//
//                });

            $("#btnSave").click(function () {
                $.ajax("ServeletPlaceOrder", {
                    accepts: {mycustomtype: "*/*"},
                    data: {
                        action: "save",
                        orderId: txtOrderId,
                        date: txtDate,
                        custId: txtCustomerId
                        
                    },
                    method: "POST"
                }).done(function (responce) {
                    alert(responce);
                    if (responce) {
                        location.reload();
                    }
                });
            });
        </script>

        <script src="js/bootstrap.min.js"></script>
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        <script src="assets/js/placeholder.js"></script>
    </body>
</html>
