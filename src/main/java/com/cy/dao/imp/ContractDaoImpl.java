package com.cy.dao.imp;

import com.cy.dao.ContractDao;
import com.cy.model.Contract;
import com.cy.model.VO.ContractVO;
import com.cy.util.DBUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContractDaoImpl implements ContractDao {
    @Override
    public List<ContractVO> findAll(HashMap<String, Object> map) {
//        {addr: 'beijing', floor: '', area: '', deco: '0'}
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        String num =(String) map.get("num");

        int x=(pageNum-1)*pageSize;
        int y=pageSize;

        String sql="select c.*,l.name,h.address from contract c,lessee l,house h where c.lid=l.id and c.hid =h.id";
// 处理 num 条件：先拼 SQL
        if (num != null && !num.trim().equals("")) {
                sql += " and num = ?";
        }
        sql+=" limit "+x+","+y;
//        System.out.println(sql);
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ContractVO contract =null;
        ArrayList<ContractVO> list = new ArrayList<>();
        ContractVO contractVO =null;
        Class<ContractVO> c = ContractVO.class;

        con = DBUtil.getConnection();
        try {
            ps = con.prepareStatement(sql);
            if (num != null && !num.trim().equals("")) {
                ps.setObject(1,num);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                contractVO = c.newInstance();
                // 关键：获取ContractVO及其所有父类的属性（包括private）
                List<Field> allFields = getAllFields(c);

                for (Field field : allFields) {
                    field.setAccessible(true); // 突破private权限
                    String fieldName = field.getName(); // 比如父类的id、num，子类的lesseeName
                    Object columnValue = rs.getObject(fieldName); // 从数据库取对应字段值
                    field.set(contractVO, columnValue); // 给属性赋值（父类、子类的都能赋）
                }
                list.add(contractVO);
            }
        } catch (Exception e) {
//            throw new Exception(e);
            e.printStackTrace( );
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }

        return list;
    }
    // 新增：递归获取当前类及其所有父类的属性
    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        // 遍历当前类及其所有父类（直到Object类为止）
        while (clazz != null && clazz != Object.class) {
            // 获取当前类的所有属性（包括private），添加到集合
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            // 向上走一层，获取父类
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
    @Override
    public int count(HashMap<String, Object> map) {

        String num =(String) map.get("num");


        String sql="SELECT COUNT(DISTINCT c.id) FROM contract c " +
                "JOIN house h ON c.hid = h.id " +  // 关联房屋表
                "JOIN lessee l ON c.lid = l.id ";

        if (num != null && !num.trim().equals("")) {
            sql += " where num = ?";
        }

        Connection con = DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int count=0;
        try {
            ps = con.prepareStatement(sql);
            if (num != null && !num.trim().equals("")) {
                ps.setObject(1,num);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return count;
    }

    @Override
    public boolean addOne(Contract contract) {
        boolean isok = DBUtil.update("insert into contract (num,hid,lid,time,startTime,endTime,totalMoney,payType) values (?,?,?,?,?,?,?,?)",contract.getNum(),contract.getHid(),contract.getLid(),contract.getTime(),contract.getStartTime(),contract.getEndTime(),contract.getTotalMoney(),contract.getPayType());
        return isok;
    }

    @Override
    public boolean updateById(Contract contract) {
        boolean isok=DBUtil.update("update contract set num = ?,hid=?,lid=?," +
                        "time=?,startTime=?,endTime=?,totalMoney=?,payType=?" +
                        "where id = ?",contract.getNum(),contract.getHid(),contract.getLid(),
                         contract.getTime(),contract.getStartTime(),contract.getEndTime(),
                         contract.getTotalMoney(),contract.getPayType(),
                         contract.getId());
        return isok;
    }

    @Override
    public boolean deleteById(int i) {
        boolean isok=DBUtil.update("delete from contract where id=?",i);
        return isok;
    }

    @Override
    public boolean pldeleteByIds(String[] ids) {
        String idsStr = String.join(",", ids);
        boolean isok =DBUtil.update("delete from contract where id in("+ ids+")");
        return isok;
    }
}
