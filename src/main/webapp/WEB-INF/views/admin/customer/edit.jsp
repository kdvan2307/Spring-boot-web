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
                    <li>
                    <c:if test = "${not empty customerEdit.id}">
                        <li class="active"> Chỉnh sửa khách hàng </li>
                    </c:if>
                    <c:if test = "${empty customerEdit.id}">
                        <li class="active"> Thêm khách hàng </li>
                    </c:if>
                    </li>

                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        Thông tin khách hàng
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
                            <form:hidden path="id" id="customerFormId"/><input type="hidden" id="modalCustomerId" name="customerId" value="">
                        </form>
                    </div>
                    </form:form>

                </div>


            </div><!-- /.page-content -->

            <c:forEach var="item" items="${transactionType}">
                <div class="col-xs-12">
                    <div class="col-sm-12">
                        <h3 class="header smaller lighter blue">${item.value}</h3>
                        <button class="btn btn-lg btn-primary" onclick="transactionType('${item.key}', '${customerEdit.id}')">
                            <i class="orange ace-icon fa fa-location-arrow bigger-130"></i>Add
                        </button>
                    </div>

                    <c:if test="${item.key == 'CSKH' || item.key == 'DDX'}">
                        <div class="col-xs-12">
                            <table class="table table-striped table-bordered table-hover">
                                <thead> <!-- ✅ Sửa từ <thread> -->
                                <tr>
                                    <th>Ngày tạo</th>
                                    <th>Người tạo</th>
                                    <th>Chi tiết giao dịch</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="tran" items="${item.key == 'CSKH' ? cskh : ddx}">
                                    <tr>
                                        <td>${tran.createdDate}</td>
                                        <td>${tran.createdBy}</td>
                                        <td>${tran.transactionDetail}</td>
                                        <td>
                                            <div class="hidden-sm hidden-xs btn-group">
                                                <a class="btn btn-xs btn-info" title="Sửa thông tin giao dịch"
                                                   onclick="UpdateTransaction('${tran.id}', '${item.key}')">
                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </c:forEach>


        </div>
    </div><!-- /.main-content -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->
<div class="modal fade" id="transactionTypeModal" role="dialog" >
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
<%--                    <button type="button" class="close" data-dismiss="modal"></button>--%>
                <h4 class="modal-title">Nhập giao dịch</h4>
            </div>
            <div class="modal-body">
                <div class="form-group has-success">
                    <label for="transactionDetail" class="col-xs-12 col-sm-3 control-label no-padding-right">Chi tiết giao dịch</label>
                    <div class="col-xs-12 col-sm-9">
                    <span class="block input-icon input-icon-right">
                        <input type="text" id = "transactionDetail" class="width-100">
                    </span>
                    </div>
                </div>

                <input type="hidden" id="customerId" name="customerId" value="">
                <input type="hidden" id="code" name="code" value="">
                <input type="hidden" id="id" name="id" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAddOrUpdateTransaction">Thêm giao dịch</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<script>

    function transactionType(code, customerId){
        $('#transactionTypeModal').modal();
        $('#modalCustomerId').val(customerId);  // ✅ Sửa từ #customerId thành #modalCustomerId
        $('#code').val(code);
    }

    function UpdateTransaction(id,code){
        $('#transactionTypeModal').modal();
        $('#id').val(id);
        $('#code').val(code);
        $('#modalCustomerId').val($('#customerFormId').val());  // ✅ Thêm dòng này
        loadTransaction(id);
    }

    $('#btnAddOrUpdateTransaction').click(function (e){
        e.preventDefault();
    
        var data = {};
        data['id'] = $('#id').val();
        data['customerId'] = $('#modalCustomerId').val();  // ✅ Sửa từ #customerId thành #modalCustomerId
        data['code'] = $('#code').val();
        data['transactionDetail'] = $('#transactionDetail').val();

        if (data.id && data.id !== "") {
            updateTransaction(data);
        } else {
            addTransaction(data);
        }
    });

    function addTransaction(data){
        $.ajax({
            type: "POST",
            url: '${customerAPI}/transaction',
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function () {
                console.log("success");
                alert("Thêm giao dịch thành công");
                location.reload();
            },
            error: function () {
                console.log("failed");
                alert("Thêm giao dịch thất bại");
            }
        });
    }

    function updateTransaction(data){
        $.ajax({
            type: "POST",
            url: '${customerAPI}/transaction',
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (data) {
                console.log("success");
                alert("Cập nhật giao dịch thành công");
                location.reload();
            },
            error: function () {
                console.log("failed");
                alert("Cập nhật giao dịch thất bại");
            }
        });
    }

    function loadTransaction(id){
        $.ajax({
            url: '${customerAPI}/transaction/' + id + '/detail',
            type: "GET",
            dataType: "json",
            success: function (res) {
                $('#transactionDetail').val(res.data); // ⚠ đúng field
            },
            error: function () {
                alert("Không tải được thông tin giao dịch.");
            }
        });
    }



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
