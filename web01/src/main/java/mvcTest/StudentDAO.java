package mvcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** selectList
	public List<StudentDTO> selectList() {
		sql = "select * from student";
		List<StudentDTO> list = new ArrayList<StudentDTO>();

		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				do {
					StudentDTO dto = new StudentDTO();
					dto.setSno(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setAge(rs.getInt(3));
					dto.setJno(rs.getInt(4));
					dto.setInfo(rs.getString(5));
					dto.setPoint(rs.getDouble(6));

					list.add(dto);
				} while (rs.next());
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			return null;
		}
	} // selectList

	// ** selectOne
	public StudentDTO selectOne(int sno) {
		sql = "SELECT * FROM student WHERE sno=?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, sno);
			rs = pst.executeQuery();

			if (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setSno(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setJno(rs.getInt(4));
				dto.setInfo(rs.getString(5));
				dto.setPoint(rs.getDouble(6));
				return dto;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	} // selectOne

	public void selectOne2(StudentDTO dto) {
		sql = "SELECT * FROM student WHERE sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSno());
			rs = pst.executeQuery();

			if (rs.next()) {
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setJno(rs.getInt(4));
				dto.setInfo(rs.getString(5));
				dto.setPoint(rs.getDouble(6));
			} else {
				System.out.println("** Student 없음 **");
			}
		} catch (Exception e) {
			System.out.println("** selectOne2 Exception => " + e.toString());
		}
	} // selectOne2

	// ** insert
	public int insert(StudentDTO dto) {
		sql = "insert into student(name,age,jno,info) values(?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getAge());
			pst.setInt(3, dto.getJno());
			pst.setString(4, dto.getInfo());

			return pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	} // insert

	// ** update
	public int update(StudentDTO dto) {
		sql = "update student set info=?, point=? where sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getInfo());
			pst.setDouble(2, dto.getPoint());
			pst.setInt(3, dto.getSno());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	} // update

	// ** delete
	public int delete(int sno) {
		sql = "delete from student where sno=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, sno);

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete

} // class