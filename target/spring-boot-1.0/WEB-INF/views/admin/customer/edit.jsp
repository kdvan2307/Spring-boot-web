<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerAPI" value="/api/customer"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main-content" id="main-content">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        Sửa hoặc thêm khách hàng
                    </h1>
                </div><!-- /.page-header -->
                <div class = "row" style="font-family: 'Times New Roman', Times, serif;">
                    <form:form modelAttribute="customerEdit"  id="listForm" method="GET">
                        <div class="col-xs-12">
                        <form class="form-horizontal" role="form" id = "form-edit">
                            <div class="form-group">
                                <label class = "col-xs-3">Tên khách hàng </label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path = "fullName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Số điện thoại</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" class="form-control" id ="street"  name="street" value="">--%>
                                    <form:input class="form-control" path = "phone"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Email</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" class="form-control" id ="structure"  name="structure" value="">--%>
                                    <form:input class="form-control" path = "email"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Tên công ty </label>
                                <div class="col-xs-9">
<%--                                    <input type="number"class="form-control" id ="numberofbasement"  name="numberOfBasement" value="">--%>
                                    <form:input class="form-control" path = "companyName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Nhu cầu </label>
                                <div class="col-xs-9">
<%--                                    <input type="number"  class="form-control" id ="floorarea" name="floorarea" value="">--%>
                                    <form:input class="form-control" path = "demand"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Tình trạng </label>
                                <div class="col-xs-9">
<%--                                    <input type="text"  class="form-control" id ="direction" name="direction" value="">--%>
                                    <form:input class="form-control" path = "status"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3"></label>
                                <div class = "col-xs-9">
                                    <c:if test="${not empty customerEdit.id}">
                                        <button type = "button" class = "btn btn-primary" id ="btnAddOrUpdateCustomer">Cập nhập khách hàng</button>
                                        <button type = "button" class = "btn btn-primary" id="btnCancel">Huỷ thao tác</button>
                                    </c:if>
                                    <c:if test="${empty customerEdit.id}">
                                        <button type = "button" class = "btn btn-primary" id ="btnAddOrUpdateCustomer">Thêm khách hàng </button>
                                        <button type = "button" class = "btn btn-primary" id="btnCancel">Huỷ thao tác</button>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="customerId"/>
                        </form>
                    </div>
                    </form:form>

                </div>


            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->


    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->
<script>
    $('#btnAddOrUpdateCustomer').click(function(){
        var data={};
        var formData = $('#listForm').serializeArray();
        $.each(formData,function(i,v){
            data["" + v.name + ""] = v.value;
        });
        addOrUpdateCustomer(data);
    });
    function addOrUpdateCustomer(data){
        $.ajax({
            type: "POST",
            url: "${customerAPI}" ,
            data: JSON.stringify(data),
            contentType:"application/json", // định dạng lạilại
            dataType:"JSON",
            success: function(respond){
                console.log("Success");
            },
            error: function(respond){
                console.log("failed");
                console.log(respond);
            }
        });
    }


    $('#btnCancel').click(function (){
        window.location.href = "/admin/customer-list";
    });


</script>
</body>
</html>
