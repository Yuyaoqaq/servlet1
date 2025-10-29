package com.cy.dao.imp;

import com.cy.dao.HouseDao;
import com.cy.model.House;
import com.cy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
    @Override
    public List<House> findAll(HashMap<String, Object> map) {
//        {addr: 'beijing', floor: '', area: '', deco: '0'}
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        String addr =(String) map.get("addr");
        String floor =(String) map.get("floor");
        String area =(String) map.get("area");
        String deco =(String) map.get("deco");
        int x=(pageNum-1)*pageSize;
        int y=pageSize;

        String sql="select * from house where status =1 ";
        if(addr!=null&&!addr.equals("")){
            sql+=" and address =\""+addr+"\"";
        }
        if(floor!=null&&!floor.equals("")){
            sql+=" and floor = "+floor;
        }
        if(area!=null&&!area.equals("")){
            sql+=" and area =\""+area+"\"";
        }
        if(deco!=null&&!deco.equals("")&&!deco.equals("0")){
            sql+=" and deco = "+deco;
        }
        sql+=" limit "+x+","+y;
//        System.out.println(sql);
        List<House> house= DBUtil.selectAll(sql,House.class);
        return house;
    }

    @Override
    public int count(HashMap<String, Object> map) {

        String addr =(String) map.get("addr");
        String floor =(String) map.get("floor");
        String area =(String) map.get("area");
        String deco =(String) map.get("deco");

        String sql="select count(*) from house where status = 1 ";
        if(addr!=null&&!addr.equals("")){
            sql+=" and address =\""+addr+"\"";
        }
        if(floor!=null&&!floor.equals("")){
            sql+=" and floor = "+floor;
        }
        if(area!=null&&!area.equals("")){
            sql+=" and area =\""+area+"\"";
        }
        if(deco!=null&&!deco.equals("")&&!deco.equals("0")){
            sql+=" and deco = "+deco;
        }

        Connection con = DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int count=0;
        try {
             ps = con.prepareStatement(sql);
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
    public boolean addOne(House house) {
        boolean isok = DBUtil.update("insert into house (address,`floor`,roomNum,area,dir,deco,air,price,rentStatus,addTime,status) values (?,?,?,?,?,?,?,?,?,?,?)",house.getAddress(),house.getFloor(),house.getRoomNum(),house.getArea(),house.getDir(),house.getDeco(),house.getAir(),house.getPrice(),house.getRentStatus(),house.getAddTime(),house.getStatus());
        return isok;
    }

    @Override
    public boolean updateById(House house) {
        boolean isok=DBUtil.update("update house set address = ?,floor=?,roomNum=?," +
                "area=?,dir=?,deco=?,air=?,price=?,rentStatus=?,addTime=?,updateTime=?,status=? " +
                "where id = ?",house.getAddress(),house.getFloor(),house.getRoomNum(),
                house.getArea(),house.getDir(),house.getDeco(),house.getAir(),
                house.getPrice(),house.getRentStatus(),house.getAddTime(),
                house.getUpdateTime(),house.getStatus(),house.getId());
        return isok;
    }

    @Override
    public boolean deleteById(int i) {
        boolean isok=DBUtil.update("update house set status =2 where id=?",i);
        return isok;
    }

    @Override
    public boolean pldeleteByIds(String[] ids) {
        String idsStr = String.join(",", ids);
        boolean isok =DBUtil.update("update house set status = 2 where id in("+ idsStr+")");
        return isok;
    }
}
