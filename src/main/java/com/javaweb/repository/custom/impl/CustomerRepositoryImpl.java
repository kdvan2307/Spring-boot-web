package com.javaweb.repository.custom.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;


@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public static void joinTable (CustomerSearchRequest customerSearchRequest, StringBuilder sql) {
        Long staffId = customerSearchRequest.getStaffId();
        if (staffId != null) {
            sql.append(" INNER JOIN assignmentcustomer ON c.id = assignmentcustomer.customerid ");
        }
    }

    public static void queryNomal (CustomerSearchRequest customerSearchRequest, StringBuilder where) {
        try {
            Field[] fields = CustomerSearchRequest.class.getDeclaredFields();//getDeclaredFields() lấy tất cả các fields của class (kể cả private)
            for (Field item : fields) {
                item.setAccessible(true);//Mặc định, các thuộc tính private không thể truy cập được.Dùng setAccessible(true) để bỏ qua giới hạn này.
                String fieldName = item.getName();
                if (!fieldName.equals("staffId")) {
                    Object value = item.get(customerSearchRequest);//Lấy giá trị của thuộc tính trong buildingSearchBuilder:Nếu buildingSearchBuilder có thuộc tính name = "Office", thì value = "Office"
                    if (value != null && !value.toString().trim().isEmpty()) {
                        if (item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {//item.getType() → Lấy kiểu dữ liệu của trường (Field).getName() → Lấy tên đầy đủ của kiểu dữ liệu đó dưới dạng chuỗi (String)
                            where.append(" AND c." + fieldName + " = " + value + " ");
                        } else if (item.getType().getName().equals("java.lang.String")) {
                            where.append(" AND c." + fieldName + " LIKE '%" + value + "%' ");
                        }
                    }
                }
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void querySpecial (CustomerSearchRequest customerSearchRequest, StringBuilder where) {
        Long staffId = customerSearchRequest.getStaffId();
        if (staffId != null) {
            where.append (" AND assignmentcustomer.staffid = " + staffId);
        }
    }

    @Override
    public List<CustomerEntity> findAll(CustomerSearchRequest customerSearchRequest) {
        StringBuilder sql = new StringBuilder( "SELECT c.* FROM customer c");
        joinTable(customerSearchRequest, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNomal(customerSearchRequest, where);
        querySpecial(customerSearchRequest, where);
//        where.append(" GROUP BY c.id;");
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

}
