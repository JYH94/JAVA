package com.ncs.spring02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ncs.spring02.domain.BoardDTO;

// ** 게시판
// => CRUD 구현

@Repository
public class BoardDAO {

	private static Connection cn = DBConnection.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** selectList
	public List<BoardDTO> selectList() {
		sql = "select * from board order by seq desc";

		try {

			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			List<BoardDTO> list = new ArrayList<BoardDTO>();
			if (rs.next()) {
				do {
					BoardDTO dto = new BoardDTO();

					dto.setSeq(rs.getInt(1));
					dto.setId(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setContent(rs.getString(4));
					dto.setRegdate(rs.getString(5));
					dto.setCnt(rs.getInt(6));
					dto.setRoot(rs.getInt(7));
					dto.setStep(rs.getInt(8));
					dto.setIndent(rs.getInt(9));

					list.add(dto);
				} while (rs.next());

				return list;
			} else {
				System.out.println("** Board selectList =>  출력자로가 없습니다");
				return null;
			} // if

		} catch (Exception e) {
			System.out.println("** Board selectList => " + e.toString());
			return null;
		} // try

	} // selectList

	// ** selectOne
	public BoardDTO selectOne(int seq) {
		sql = "select * from board where seq = ?";

		try {

			pst = cn.prepareStatement(sql);
			pst.setInt(1, seq);
			rs = pst.executeQuery();

			if (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getString(5));
				dto.setCnt(rs.getInt(6));
				dto.setRoot(rs.getInt(7));
				dto.setStep(rs.getInt(8));
				dto.setIndent(rs.getInt(9));

				return dto;
			} else {
				System.out.println("** Board selectOne =>  출력자로가 없습니다");
				return null;
			} // if

		} catch (Exception e) {
			System.out.println("** Board selectOne => " + e.toString());
			return null;
		} // try
	}

	// ** Insert
	public int insert(BoardDTO dto) {
		sql = "insert into board(id, title, content) values(?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());
			
			return pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("** Board insert =>  " + e.toString());
			return 0;
		}
		
		
	}

	// ** Update
	public int update(BoardDTO dto) {
		sql = "update board set title =?, content=? where seq = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getTitle());
			pst.setString(2, dto.getContent());
			pst.setInt(3, dto.getSeq());
			System.out.println(dto.getSeq());
			
			return pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("** Board update =>  " + e.toString());
			return 0;
		}
		
	}

	// ** Delete
	
	public int delete(int seq) {
		sql = "delete from member where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, seq);
			
			return pst.executeUpdate(); // 처리갯수
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	} // delete
} // class
