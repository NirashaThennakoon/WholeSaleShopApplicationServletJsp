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
                            <a href="searchAllCustomer.html">
                                <span class="img_icon icon3"></span>
                                <span class="link_title" style="color: white">All Customers</span>
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
                        <h1 class="wow fadeInLeftBig" style="color: #e36da1">Customer</h1>

                    </div>
                </div>
                <div class="row" style="height: 10px"></div>

                <div class="row">
                    <div style="margin: 0px ; padding: 5px; border: 0px" class="col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp">
                        
                            <div class="r-form-1-top">
                                <div class="r-form-1-top-left">
                                    <h3>Enter Customer details</h3>
                                </div>
                            </div>
                            <div class="r-form-1-bottom">
                                <form role="form" id="frm" enctype="application/x-www-form-urlencoded" method="POST" action="Servelet">
                                    <div class="form-group">
                                        <label >Customer Id</label>
                                        <input type="text" name="txtCustomerId1"  class="r-form-1-first-name form-control" id="txtCustomerId1">
                                    </div>
                                    <div class="form-group">
                                        <label >Name</label>
                                        <input type="text" name="txtCustomerName1"  class="r-form-1-last-name form-control" id="txtCustomerName1">
                                    </div>
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" name="txtCustomerAddress1"  class="r-form-1-email form-control" id="txtCustomerAddress1">
                                    </div>
                                    <div class="form-group">
                                        <label >Salary</label>
                                        <input type="text" name="txtCustomerSalary1"  class="r-form-1-email form-control" id="txtCustomerSalary1">
                                    </div>
                                    <br>
                                    <div><button id="btnSave" type="button" class="btn">Add</button></div>
                                    <br>
                                    <div><button id="btnSave" type="button" class="btn">All Customer</button></div>
                                    
                                </form>
                            </div>
                        
                    </div>
                    <div style="margin: 0px ; padding: 5px; border: 0px" class="col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp">
                        
                            <div class="r-form-1-top">
                                <div class="r-form-1-top-left">
                                    <h3>Search First!!!</h3>
                                </div>

                            </div>
                            <div class="r-form-1-bottom">
                                <form role="form" id="frm2" enctype="application/x-www-form-urlencoded" method="POST" action="Servelet">
                                    <div class="form-group">
                                        <label>Id</label>
                                        <select class="selectbox" name="txtCustomerId" id="txtCustomerId" onchange="loadCustomerDetails(this.value)">
                                            <option selected disabled hidden>Select Customer ID</option>
                                            <%
                                                ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext("lk/ijse/spring/SpringConfig.xml");
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
                                        <label>Name</label>
                                        <input type="text" name="txtCustomerName" class="r-form-1-last-name form-control" id="txtCustomerName">
                                    </div>
                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" name="txtCustomerAddress" class="r-form-1-email form-control" id="txtCustomerAddress">
                                    </div>
                                    <div class="form-group">
                                        <label>Salary</label>
                                        <input type="text" name="txtCustomerSalary" class="r-form-1-email form-control" id="txtCustomerSalary">
                                    </div>
                                        <br>
                                    <div><button id="btnUpdate" type="button" class="btn">Update</button></div>
                                    <br>
                                    <div><button id="btnDelete" type="button" class="btn">Delete</button></div>
                               

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script type="text/javascript">
            
            $("#btnSave").click(function () {
                $("#frm").attr("action", "Servelet?action=save");
                $("#frm").submit();
                alert("Customer has been added");
            });


            $("#btnUpdate").click(function () {
                $("#frm2").attr("action", "Servelet?action=update");
                $("#frm2").submit();
                alert("Customer has been updated");
            });


            $("#btnDelete").click(function () {
                $("#frm2").attr("action", "Servelet?action=delete");
                $("#frm2").submit();
                alert("Customer has been deleted");
            });



            function loadCustomerDetails(txtCustomerId) {
                $.ajax("Servelet", {
                    accepts: {mycustomtype: "*/*"},
                    data: {
                        action: "search",
                        id: txtCustomerId
                    },
                    method: "POST"
                }).done(function (response) {
                    var message = JSON.parse(response);
                    $("#txtCustomerName").val(message.name);
                    $("#txtCustomerAddress").val(message.address);
                    $("#txtCustomerSalary").val(message.salary);

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