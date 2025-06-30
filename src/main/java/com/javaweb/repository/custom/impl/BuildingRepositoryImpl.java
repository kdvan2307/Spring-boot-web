package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public static void joinTable (BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
            sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
        }

//        List<String> typeCode = buildingSearchRequest.getTypeCode()	;
//        if (typeCode != null && typeCode.size() != 0) {
//            sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
//            sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
//        }
        Long rentAreaTo = buildingSearchBuilder.getAreaTo();
        Long rentAreaFrom = buildingSearchBuilder.getAreaFrom();
        if (rentAreaFrom != null || rentAreaTo != null) {
            sql.append(" INNER JOIN rentarea ON rentarea.buildingid = b.id ");
        }
    }

    public static void queryNomal (BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();//getDeclaredFields() lấy tất cả các fields của class (kể cả private)
            for (Field item : fields) {
                item.setAccessible(true);//Mặc định, các thuộc tính private không thể truy cập được.Dùng setAccessible(true) để bỏ qua giới hạn này.
                String fieldName = item.getName();
                if (!fieldName.equals("staffId") && !fieldName.equals("typeCode")
                        && !fieldName.startsWith("area") && !fieldName.startsWith("rentPrice")) {
                    Object value = item.get(buildingSearchBuilder);//Lấy giá trị của thuộc tính trong buildingSearchBuilder:Nếu buildingSearchBuilder có thuộc tính name = "Office", thì value = "Office"
                    if (value != null  && !value.toString().trim().isEmpty()) {
                        if (item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {//item.getType() → Lấy kiểu dữ liệu của trường (Field).getName() → Lấy tên đầy đủ của kiểu dữ liệu đó dưới dạng chuỗi (String)
                            where.append(" AND b." + fieldName + " = " + value + " ");
                        }
                        else if (item.getType().getName().equals("java.lang.String")){
                            where.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");
                        }
                    }
                }
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void querySpecial (BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
            where.append (" AND assignmentbuilding.staffid = " + staffId);
        }
        Long rentAreaTo =  buildingSearchBuilder.getAreaTo();
        Long rentAreaFrom =  buildingSearchBuilder.getAreaFrom();
        if (rentAreaFrom != null  || rentAreaTo != null) {
            where.append(" AND EXISTS ( SELECT * from rentarea r where b.id = r.buildingid ");
            if (rentAreaFrom != null) {
                where.append(" AND r.value >= " + rentAreaFrom);
            }
            if (rentAreaTo != null) {
                where.append(" AND r.value <= " + rentAreaTo);
            }
            where.append(" ) ");
        }
        Long rentPriceTo =  buildingSearchBuilder.getRentPriceTo();
        Long rentPriceFrom =  buildingSearchBuilder.getRentPriceFrom();
        if (rentPriceFrom != null || rentPriceTo != null) {
            if (rentPriceFrom != null) {
                where.append(" AND b.rentprice >= " + rentPriceFrom);
            }
            if (rentPriceTo != null) {
                where.append(" AND b.rentprice <= " + rentPriceTo);
            }
        }
        List<String> typeCode = buildingSearchBuilder.getTypeCode()	;
        if (typeCode != null && typeCode.size() != 0) {
            where.append(" AND (");
            String sql = typeCode.stream().map(it -> " b.type Like" + "'%" + it  + "%' "	)
                    .collect(Collectors.joining(" OR "));
            where.append(sql);
            where.append(" ) ");
        }
    }
    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder( "SELECT b.* FROM building b");
        joinTable(buildingSearchBuilder, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
//		queryNomal(buildingSearchBuilder, where);
        queryNomal(buildingSearchBuilder, where);
        querySpecial(buildingSearchBuilder, where);
        where.append(" GROUP BY b.id;");
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }


}
