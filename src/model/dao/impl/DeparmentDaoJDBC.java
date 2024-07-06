package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DeparmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DeparmentDaoJDBC (Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO department "
                        + "(Name) "
                        + "VALUES "
                        + "(?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1,obj.getName());

            int rows = st.executeUpdate();

            if (rows == 0){
                throw new DbException("Error!");
            }
            else {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }



        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Department obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE department "
                        + "SET Name = ? "
                        + "WHERE Id = ?");

            st.setString(1,obj.getName());
            st.setInt(2, obj.getId());

            int rows = st.executeUpdate();

            if (rows == 0){
                throw new DbException("This Id does not exist!");
            }


        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
