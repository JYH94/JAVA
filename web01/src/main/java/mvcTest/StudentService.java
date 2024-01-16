package mvcTest;

import java.util.List;

public class StudentService {
	StudentDAO dao = new StudentDAO();

	// ** selectList
	public List<StudentDTO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	public StudentDTO selectOne(int sno) {
		return dao.selectOne(sno);
	}

	// ** selectOne2 참조자료형 테스트
	public void selectOne2(StudentDTO dto) {
		dao.selectOne2(dto);
	}

	// ** insert
	public int insert(StudentDTO dto) {
		return dao.insert(dto);
	}

	// ** update
	public int update(StudentDTO dto) {
		return dao.update(dto);
	}

	// ** delete
	public int delete(int sno) {
		return dao.delete(sno);
	}

} // class