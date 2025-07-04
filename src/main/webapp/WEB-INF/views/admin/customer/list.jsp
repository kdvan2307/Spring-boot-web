
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerListURL" value="/admin/customer-list"/>
<c:url var="customerAPI" value="/api/customer"/>
<html>
<head>
    <title>Danh sách khách hàng </title>
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
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Quản lý khách hàng </li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">
                <div class = "row">
                    <div class="col-xs-12">
                        <div class="widget-box ui-sortable-handle">
                            <div class="widget-header">
                                <h5 class="widget-title">Tìm Kiếm</h5>

                                <div class="widget-toolbar">


                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>

                                </div>
                            </div>

                            <div class="widget-body" style="font-family:'Times New Roman', Times, serif">
                                <div class="widget-main">
                                    <form:form modelAttribute="modelSearchCustomer" id="listForm" action="${customerListURL}" method="GET">
                                        <div class = "row">
                                            <div class="col-xs-12">
                                                <div class ="col-xs-4">
                                                    <label class = "name">Tên khách hàng</label>
<%--                                                    <input type ="text" class = "form-control" name = "name" value="">--%>
                                                        <form:input  class = "form-control"  path="fullName"/>
                                                </div>
                                                <div class ="col-xs-4">
                                                    <label class = "name">Di Động</label>
<%--                                                    <input type ="number" class = "form-control" name="floorArea" value="">--%>
                                                    <form:input  class = "form-control"  path="phone"/>
                                                </div>
                                                <div class ="col-xs-4">
                                                    <label class = "name">Email</label>
<%--                                                    <input type ="text" class = "form-control" name="ward" value="">--%>
                                                    <form:input  class = "form-control"  path="email"/>
                                                </div>
                                            </div>


                                            <div class="col-xs-12">
                                                 <div class ="col-xs-4">
                                                        <security:authorize access="hasRole('MANAGER')">
                                                            <div>
                                                                <label class = "name">Nhân Viên</label>
                                                                <form:select class = "form-control" path="staffId">
                                                                    <form:option value="">---Chọn Nhân Viên---</form:option>
                                                                    <form:options items="${listStaffs}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </security:authorize>
                                                </div>
                                            </div>


                                            <div class="col-xs-12">
                                                <div class = "col-xs-6">
                                                    <button type="button" class="btn btn-xs btn-info" id="btnSearchCustomer">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"></path>
                                                        </svg>
                                                        Tìm Kiếm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>

                            <div class="pull-right" title="Thêm khách hàng ">
                                <a href="/admin/customer-edit">
                                    <button class="btn btn-info">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                            <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                            <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                            <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                        </svg>
                                    </button>
                                </a>

                                <button class="btn btn-danger" title="Xóa khách hàng " id="btnDeleteCustomer">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Bảng danh sách -->
                <div class="col-xs-12">
                    <table id="tableList" style="margin: 3em 0 1.5em;" class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Tên khách hàng</th>
                            <th>Di động</th>
                            <th>Email</th>
                            <th>Nhu cầu </th>
                            <th>Người thêm</th>
                            <th>Ngày thêm</th>
                            <th>Tình trạng</th>
                            <th>Thao tác</th>

                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="item" items="${customerList}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkList" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>

                                <td>${item.fullName}</td>
                                <td>${item.phone}</td>
                                <td>${item.email}</td>
                                <td>${item.demand}</td>
                                <td>${item.createdBy}</td>
                                <td>${item.createdDate}</td>
                                <td>${item.status}</td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <security:authorize access="hasRole('MANAGER')">
                                            <button class="btn btn-xs btn-success" title="Giao khách hàng "
                                                    onclick="assignmentCustomer(${item.id})">
                                                <i class="ace-icon fa fa-check bigger-120"></i>
                                            </button>
                                        </security:authorize>

                                        <a class="btn btn-xs btn-info" href="/admin/customer-edit-${item.id}" title="Sửa khách hàng ">
                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                        </a>
                                        <security:authorize access="hasRole('MANAGER')">
                                            <button class="btn btn-xs btn-danger" title="xoá khách hàng " onclick="deleteCustomer(${item.id})">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </security:authorize>


                                    </div>

                                    <div class="hidden-md hidden-lg">
                                        <div class="inline pos-rel">
                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                    data-toggle="dropdown" data-position="auto">
                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                            </button>

                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                <li>
                                                    <a href="#" class="tooltip-info" data-rel="tooltip" title=""
                                                       data-original-title="View">
                                                                        <span class="blue">
                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                        </span>
                                                    </a>
                                                </li>

                                                <li>
                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title=""
                                                       data-original-title="Edit">
                                                                        <span class="green">
                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                        </span>
                                                    </a>
                                                </li>

                                                <li>
                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title=""
                                                       data-original-title="Delete">
                                                                        <span class="red">
                                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                        </span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->


    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>
<div class="modal fade" id="assignmentCustomerModal" role="dialog" style="font-family: 'Times New Roman', Times, serif;">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover" id="staffList">
                    <thead>
                        <tr>
                            <th class="center">Chọn</th>
                            <th>Tên nhân viên</th>

                        </tr>
                    </thead>

                    <tbody>

                    </tbody>
                </table>
                <input type="hidden" id="customerId" name="CustomerId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnassignmentCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>

    </div>
</div>

    <script>
        function assignmentCustomer(customerId){
            $('#assignmentCustomerModal').modal();
            loadStaff(customerId);
            $('#customerId').val(customerId);

        }

        // gửi yêu cầu AJAX GET để lấy danh sách nhân viên đang được phân công vào một tòa nhà cụ thể (buildingId)
        // và hiển thị danh sách này trong bảng HTML.
        function loadStaff(customerId){
            $.ajax({
                type: "GET",
                url: "${customerAPI}/" + customerId +'/staffs' ,
              //  data: JSON.stringify(data),
                //contentType:"application/json", // định dạng lạilại
                dataType:"json",
                success: function(response){
                    var row ='';
                    $.each(response.data,function (index,item){
                        // response.data là một mảng danh sách nhân viên nhận được từ API
                        //     index: vị trí của phần tử trong mảng.
                        //     item: đối tượng nhân viên chứa thông tin như staffId, fullName, checked.
                        row += '<tr>';
                        row += '<td class="text-center"><input type="checkbox" value=' + item.staffId + ' id = "checkbox_'+ item.staffId +'" class = "check-box-element"' +  item.checked + '/></td>';
                        row += '<td class= "text-center">' + item.fullName + '</td>';
                        row += '</tr>';
                    });
                    $('#staffList tbody').html(row);
                    console.info("Success");
                },
                error: function(response){
                    console.log("failed");
                    window.location.href="<c:url value="/admin/customer-list?message=error"/>";
                    console.log(response);
                }
            });
        }
        // khi ấn vào nút giao tòa nhà
        $('#btnassignmentCustomer').click(function(e){
            e.preventDefault();
            var data ={};
            data['customerId'] = $('#customerId').val();
            var staffs =$('#staffList').find('tbody input[type = checkbox]:checked').map(function(){
                return $(this).val();
            }).get();
            data['staffs'] = staffs;
            if (data['staffs'] !=''){
                assignment(data);
            }
            console.log("OK");
        })
        //  gửi ajax để cập nhật danh sách nhân viên
        function assignment(data){
            $.ajax({
                type: "POST",
                url: "${customerAPI}/" +  'assignment' ,
                data: JSON.stringify(data),
                contentType:"application/json", // định dạng lạilại
                dataType:"JSON",
                success: function(response){

                    console.info("Success");
                },
                error: function(response){
                    console.log("Giao khong thanh cong");
                    window.location.href="<c:url value="/admin/customer-list?message=error"/>";
                    console.log(response);
                }
            });
        }

        $('#btnSearchCustomer').click(function(e){
            e.preventDefault();
           $('#listForm').submit();
        })
        function deleteCustomer(id){
            var customerId = [id];
            deleteCustomers(customerId);
        }
        $('#btnDeleteCustomer').click(function(e){
            e.preventDefault();
            var data = {};
            var customerIds =$('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
                return $(this).val();
            }).get();
            deleteCustomers(customerIds);
        })
        function deleteCustomers(data){
            $.ajax({
                type: "DELETE",
                url: "${customerAPI}/" + data ,
                data: JSON.stringify(data),
                contentType:"application/json", // định dạng lạilại
                dataType:"JSON",
                success: function(respond){
                    console.log("Success");
                    window.location.href="<c:url value="/admin/building-list?message=success"/>";
                },
                error: function(respond){
                    console.log("failed");
                    console.log(respond);
                }
            });
        }
    </script>
</body>
</html>