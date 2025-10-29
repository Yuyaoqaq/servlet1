package com.cy.dao.imp;

import com.cy.dao.LesseeDao;
import com.cy.model.Lessee;
import com.cy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class LesseeDaoImpl implements LesseeDao {
    @Override
    public List<Lessee> findAll(HashMap<String, Object> map) {
//        {addr: 'beijing', floor: '', area: '', deco: '0'}
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        String name =(String) map.get("name");
        String idCard =(String) map.get("idCard");
        int x=(pageNum-1)*pageSize;
        int y=pageSize;

        String sql = "select * from lessee";
        boolean hasWhere = false;

// 处理 name 条件：先拼 SQL
        if (name != null && !name.trim().equals("")) {
            if (hasWhere) {
                sql += " and name like \'%"+name+"%\'";
            } else {
                sql += " where name like \'%"+name+"%\'";
                hasWhere = true;
            }
        }

// 处理 idCard 条件：继续拼 SQL
        if (idCard != null && !idCard.trim().equals("")) {
            if (hasWhere) {
                sql += " and idCard = "+idCard;
            } else {
                sql += " where idCard = "+idCard;
                hasWhere = true;
            }
        }
        sql+=" limit "+x+","+y;
//        System.out.println(sql);
        List<Lessee> lessee= DBUtil.selectAll(sql,Lessee.class);
        return lessee;
    }

    @Override
    public int count(HashMap<String, Object> map) {

        String name =(String) map.get("name");
        String idCard =(String) map.get("idCard");
        String sql = "select count(*) from lessee";
        boolean hasWhere = false;
        int paramIndex = 1; // 动态索引：记录当前要赋值的 ? 位置（从1开始）

// 处理 name 条件：先拼 SQL
        if (name != null && !name.trim().equals("")) {
            if (hasWhere) {
                sql += " and name = ?";
            } else {
                sql += " where name = ?";
                hasWhere = true;
            }
        }

// 处理 idCard 条件：继续拼 SQL
        if (idCard != null && !idCard.trim().equals("")) {
            if (hasWhere) {
                sql += " and idCard = ?";
            } else {
                sql += " where idCard = ?";
                hasWhere = true;
            }
        }

        Connection con = DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int count=0;

        try {
            ps = con.prepareStatement(sql);
            if (name != null && !name.trim().equals("")) {
                ps.setObject(paramIndex++, name); // 赋值后，索引+1
            }

            if (idCard != null && !idCard.trim().equals("")) {
                ps.setObject(paramIndex++, idCard); // 赋值后，索引+1
            }
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return count;
    }

    @Override
    public boolean addOne(Lessee lessee) {
        boolean isok = DBUtil.update("insert into lessee (name,tel,sex,np,idCard,addTime) values (?,?,?,?,?,?)",lessee.getName(),lessee.getTel(),lessee.getSex(),lessee.getNp(),lessee.getIdCard(),lessee.getAddTime());
        return isok;
    }

    @Override
    public boolean updateById(Lessee lessee) {
        boolean isok=DBUtil.update("update lessee set name=?,tel=?,sex=?,np=?,idCard=?,addTime=?" +
                        "where id = ?",lessee.getName(),lessee.getTel(),lessee.getSex(),lessee.getNp(),lessee.getIdCard(),lessee.getAddTime(),lessee.getId());
        return isok;
    }

    @Override
    public boolean deleteById(int i) {
        boolean isok=DBUtil.update("delete from lessee where id=?",i);
        return isok;
    }

    @Override
    public boolean pldeleteByIds(String[] ids) {
        String idsStr = String.join(",", ids);
        boolean isok =DBUtil.update("delete from lessee where id in("+ ids+")");
        return isok;
    }
}
