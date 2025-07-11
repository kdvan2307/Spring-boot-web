<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api/building"/>
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
                        Sửa hoặc thêm tòa nhà
                    </h1>
                </div><!-- /.page-header -->
                <div class = "row" style="font-family: 'Times New Roman', Times, serif;">
                    <form:form modelAttribute="buildingEdit"  id="listForm" method="GET">
                        <div class="col-xs-12">
                        <form class="form-horizontal" role="form" id = "form-edit">
                            <div class="form-group">
                                <label class = "col-xs-3">Tên tòa nhà</label>
                                <div class="col-xs-9">
                                    <form:input class="form-control" path = "name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3" >Quận</label>
                                <div class="col-xs-2">
                                    <form:select class = "form-control" path="district">
                                        <form:option value="">---Chọn Quận---</form:option>
                                        <form:options items="${districts}"></form:options>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Phường</label>
                                <div class="col-xs-9">
<%--                                    <input type="text"  class="form-control" id ="ward" name="ward" value="">--%>
                                        <form:input class="form-control" path = "ward"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Đường</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" class="form-control" id ="street"  name="street" value="">--%>
                                    <form:input class="form-control" path = "street"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Kết cấu</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" class="form-control" id ="structure"  name="structure" value="">--%>
                                    <form:input class="form-control" path = "structure"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Số tầng hầm</label>
                                <div class="col-xs-9">
<%--                                    <input type="number"class="form-control" id ="numberofbasement"  name="numberOfBasement" value="">--%>
                                    <form:input class="form-control" path = "numberOfBasement"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Diện tích sàn</label>
                                <div class="col-xs-9">
<%--                                    <input type="number"  class="form-control" id ="floorarea" name="floorarea" value="">--%>
                                    <form:input class="form-control" path = "floorArea"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Hướng</label>
                                <div class="col-xs-9">
<%--                                    <input type="text"  class="form-control" id ="direction" name="direction" value="">--%>
                                    <form:input class="form-control" path = "direction"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Hạng</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" class="form-control" id ="level" name="level" value="">--%>
                                    <form:input class="form-control" path = "level"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Diện tích thuê</label>
                                <div class="col-xs-9">
<%--                                    <input type="text"class="form-control" id ="rentarea"  name="rentarea" value="">--%>
                                    <form:input class="form-control" path = "rentArea"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Giá thuê</label>
                                <div class="col-xs-9">
<%--                                    <input type="number"  class="form-control" id ="rentprice" name="rentprice" value="">--%>
                                    <form:input class="form-control" path = "rentPrice"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Mô tả giá</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" class="form-control" id ="rentpricescription"  name="rentpricescription" value="">--%>
                                    <form:input class="form-control" path = "rentpricescription"/>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class = "col-xs-3">Phí dịch vụ</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "serviceFee"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Phí ô tô</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "carFee"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Phí mô tô</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "motoFee"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Phí ngoài giờ</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "overtimeFee"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Tiền điện</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "electricityBill"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Đặt cọc</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "deposit"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Thanh toán</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "pay"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Thời hạn thuê</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "rentalTerm"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Thời gian trang trí</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "decorationTime"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Tên quản lý</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "managerName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">SDT quản lý</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "managerPhone"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Phí môi giới</label>
                                <div class="col-xs-9">
<%--                                    <input type="number" id ="name" class="form-control" name="name">--%>
                                    <form:input class="form-control" path = "brokerageFee"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3"> Loại tòa nhà</label>
                                <div class="col-xs-9">
                                    <form:checkboxes items="${typeCodes}" path="typeCode"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3">Ghi chú</label>
                                <div class="col-xs-9">
<%--                                    <input type="text" id ="name" class="form-control">--%>
                                    <form:input class="form-control" path = "note"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class = "col-xs-3"></label>
                                <div class = "col-xs-9">
                                    <c:if test="${not empty buildingEdit.id}">
                                        <button type = "button" class = "btn btn-primary" id ="btnAddOrUpdateBuilding">Cập nhập tòa nhà</button>
                                        <button type = "button" class = "btn btn-primary" id="btnCancel">Huỷ thao tác</button>
                                    </c:if>
                                    <c:if test="${empty buildingEdit.id}">
                                        <button type = "button" class = "btn btn-primary" id ="btnAddOrUpdateBuilding">Thêm tòa nhà</button>
                                        <button type = "button" class = "btn btn-primary" id="btnCancel">Huỷ thao tác</button>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="buildingId"/>
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
    $('#btnAddOrUpdateBuilding').click(function(){
        var data={};
        var typeCode=[];
        var formData = $('#listForm').serializeArray();
        $.each(formData,function(i,v){
            if(v.name != 'typeCode'){
                data["" + v.name + ""] = v.value;
            }
            else{
                typeCode.push(v.value);
            }
        });
        data['typeCode'] = typeCode;
        if(typeCode != ''){
            addOrUpdateBuilding(data);
        }
        else{
            window.location.href="<c:url value="/admin/building-edit?typeCode=require"/>";

        }
    });
    function addOrUpdateBuilding(data){
        $.ajax({
            type: "POST",
            url: "${buildingAPI}" ,
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
        window.location.href = "/admin/building-list";
    });


</script>
</body>
</html>
