<%@page import="lk.ijse.dto.ItemDTO"%>
<%@page import="lk.ijse.business.custom.impl.ItemBOImpl"%>
<%@page import="lk.ijse.dto.CustomerDTO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="lk.ijse.business.custom.impl.CustomerBOImpl"%>
<%@page import="java.util.ArrayList"%>
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
                height: 50px; 
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
        <div class="top-content">
            <div class="container">

                <div class="row" style="height: 100px"></div>
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-10">
                        <div class="col-md-3">
                            <a href="#">
                                <span class="img_icon icon1"></span>
                                <span class="link_title" style="color: white">Home</span>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="#">
                                <span class="img_icon icon2"></span>
                                <span class="link_title" style="color: white">Add Item</span>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="#">
                                <span class="img_icon icon3"></span>
                                <span class="link_title" style="color: white">All Items</span>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="#">
                                <span class="img_icon icon4"></span>
                                <span class="link_title" style="color: white">Other</span>
                            </a>
                        </div>  
                    </div>
                    <div class="col-md-1"></div>
                </div>

                <div class="row" style="height: 50px"></div>

                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1 class="wow fadeInLeftBig" style="color: #e36da1">Item</h1>

                    </div>
                </div>
                <div class="row" style="height: 10px"></div>

                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp">
                        <div class="r-form-1-top">
                            <div class="r-form-1-top-left">
                                <h3>Search First!!!</h3>
                            </div>

                        </div>
                        <div class="r-form-1-bottom">
                            <form role="form" id="frm" enctype="application/x-www-form-urlencoded" method="POST" action="ServeletItem">
                                <div class="form-group">
                                    <label>Code</label>
                                    <select class="selectbox" name="txtItemCode" id="txtItemCode" onchange="loadItemDetails(this.value)">
                                        <option selected disabled hidden>Select Item Code</option>
                                        <%
                                            ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
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
                                    <label>Description</label>
                                    <input type="text" name="txtItemDescription" class="r-form-1-last-name form-control" id="txtItemDescription">
                                </div>
                                <div class="form-group">
                                    <label>Unit Price</label>
                                    <input type="text" name="txtItemUnitPrice" class="r-form-1-email form-control" id="txtItemUnitPrice">
                                </div>
                                <div class="form-group">
                                    <label>Qty on hand</label>
                                    <input type="text" name="txtItemQtyOnHand" class="r-form-1-email form-control" id="txtItemQtyOnHand">
                                </div>
                                <div><button id="btnUpdate2" type="button" class="btn">Update</button></div>
                                <br>
                                <div><button id="btnDelete2" type="button" class="btn">Delete</button></div>
                                <br>

                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <script type="text/javascript">

            function loadItemDetails(txtItemCode) {
                alert(txtItemCode);
                $.ajax("ServeletItem", {
                    accepts: {mycustomtype: "*/*"},
                    data: {
                        action: "search",
                        id: txtItemCode
                    },
                    method: "POST"
                }).done(function (response) {
                    var message = JSON.parse(response);
                    alert(message);
                    $("#txtItemDescription").val(message.description);
                    $("#txtItemUnitPrice").val(message.unitPrice);
                    $("#txtItemQtyOnHand").val(message.qtyOnHand);

                });
            }
            
            
            
           
            $("#btnUpdate2").click(function () {
            $("#frm").attr("action", "ServeletItem?action=update");
            $("#frm").submit();
            });
            
            
            
            $("#btnDelete2").click(function () {
            alert(delete);
            $("#frm").attr("action", "ServeletItem?action=delete");
            $("#frm").submit();
            });
            }




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