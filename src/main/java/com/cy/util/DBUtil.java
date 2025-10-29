package com.cy.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DBUtil {

    // 创建Properties类对象,专用于操作properties文件
    private static final Properties properties = new Properties( );
    // 声明Druid连接池的连接池对象
    // 数据连接,一般称作数据源 dataSource
    private static DruidDataSource dataSource;


    static {

        try {
            InputStream inputStream = DBUtil.class.getResourceAsStream("/jdbc.properties");
            properties.load(inputStream);
            // 不需要由我们加载驱动
            // 需要给dataSource赋值
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            System.out.println("加载驱动异常!!");
            e.printStackTrace( );
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 不需要我们获得连接
            // 而是通过Druid获得
            conn = dataSource.getConnection( );
        } catch (Exception e) {
            System.out.println("获得连接出异常!!!");
            e.printStackTrace( );
        }
        return conn;
    }


    /**
     * 关闭所有流
     */
    public static void closeAll(Connection conn, Statement s) {
        if (conn != null) {
            try {
                conn.close( );
            } catch (SQLException throwables) {
                throwables.printStackTrace( );
            }
        }

        if (s != null) {
            try {
                s.close( );
            } catch (SQLException throwables) {
                throwables.printStackTrace( );
            }
        }
    }

    public static void closeAll(Connection conn, Statement s, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close( );
            } catch (SQLException throwables) {
                throwables.printStackTrace( );
            }
        }

        if (s != null) {
            try {
                s.close( );
            } catch (SQLException throwables) {
                throwables.printStackTrace( );
            }
        }

        if (rs != null) {
            try {
                rs.close( );
            } catch (SQLException throwables) {
                throwables.printStackTrace( );
            }
        }
    }


    /**
     * 封装查询方法,返回一个对象
     * 参数1 执行查询的SQL,预处理的,条件用?占位
     * select * from tb_user where id = ? and username = ? and password = ?
     * 参数2 结果要封装的类
     * 参数3 给?赋值,不定长参数,是数组
     * 1,admin,123456
     */
    public static <T> T selectOne(String sql, Class<T> t, Object... args) {
        Connection conn = getConnection( );
        PreparedStatement ps = null;
        ResultSet rs = null;
        T target = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; args != null && i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery( );
            /**
             * 创建对象
             * 从数据库取出数据,并设置对象属性
             */
            while (rs.next( )) {
                target = t.newInstance( );
                Field[] declaredFields = t.getDeclaredFields( );
                for (int i = 0; i < declaredFields.length; i++) {
                    Field field = declaredFields[i];
                    Object value = rs.getObject(field.getName( ));

                    // 破解私有
                    field.setAccessible(true);

                    // 给对象的该字段赋值
                    field.set(target, value);
                }

            }
        } catch (Exception e) {
            e.printStackTrace( );
        } finally {
            closeAll(conn, ps, rs);
        }
        return target;
    }

    public static <T> List<T> selectAll(String sql, Class<T> t, Object... args) {
        Connection conn = getConnection( );
        PreparedStatement ps = null;
        ResultSet rs = null;
        T target = null;
        ArrayList<T> list = new ArrayList<T>( );
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; args != null && i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery( );
            /**
             * 创建对象
             * 从数据库取出数据,并设置对象属性
             */
            while (rs.next( )) {
                target = t.newInstance( );
                Field[] declaredFields = t.getDeclaredFields( );
                for (int i = 0; i < declaredFields.length; i++) {
                    Field field = declaredFields[i];
                    Object value = rs.getObject(field.getName( ));

                    // 破解私有
                    field.setAccessible(true);

                    // 给对象的该字段赋值
                    field.set(target, value);
                }
                list.add(target);

            }
        } catch (Exception e) {
            e.printStackTrace( );
        } finally {
            closeAll(conn, ps, rs);
        }
        return list;
    }

    /**
     * 增删改方法一样
     */
    public static boolean update(String sql, Object... args) {
        Connection conn = getConnection( );
        PreparedStatement ps = null;
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; args != null && i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            num = ps.executeUpdate( );
        } catch (Exception e) {
            e.printStackTrace( );
        } finally {
            closeAll(conn, ps);
        }
        return num > 0 ? true : false;
    }

}
//util的data和sql的datatime 查询是子类赋给父类 多态
//添加、修改是jdbc自己处理的类型转换
//总之都不用手动进行这两个数据类型转换的处理
