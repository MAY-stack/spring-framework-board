package com.MarisolBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.MarisolBoard.dto.BoardVO;
import com.MarisolBoard.dto.UserVO;

@Mapper
public interface SFTestMapper {	//함수로 쓴 경우에는 엘리어싱 하지 않으면 못읽어옴, 
	
	//회원 등록
	@Insert("insert into tbl_user(userid,username,password,gender,hobby,job,description) values('${user.userid}', '${user.username}', '${user.password}', '${user.gender}', '${user.hobby}', '${user.job}', '${user.description}')")
	public void userReg(@Param("user") UserVO user);//User 로 받아온 값을 user로 집어 넣음
	
	//아이디 중복 체크
	@Select("select count(*) from tbl_user where userid ='${userid}'")//count가 1이면 이미 사용 중인 아이디, 0이면 아이디 사용 가능
	//count가 1이면 이미 사용 중인 아이디, 0이면 아이디 사용 가능
	public int idCheck(@Param("userid") String userid);
	
	//아이디에 따른 비밀번호 확인
	@Select("select password from tbl_user where userid ='${userid}'")	
	public String pwCheck(@Param("userid") String password);
	
	//회원 정보 보기
	@Select("select userid, username from tbl_user where userid = ${userid}")
	public UserVO userinfo(@Param("userid") String userid);
	
	//게시물 목록 보기
	@Select("select seqno, userid, writer, title, to_char(regdate,'YYYY-MM-DD HH24:MI:SS') as regdate, hitno from tbl_board order by seqno desc")
	public List<BoardVO> list();
	
	//게시물 등록(+첨부파일)
	@Insert("insert into tbl_board(userid,writer,title,content,org_filename,stored_filename) values('${board.userid}', '${board.writer}', '${board.title}', '${board.content}', '${board.org_filename}', '${board.stored_filename}')")
	public void write(@Param("board") BoardVO board);//BoardVO 로 받아온 값을 board로 집어 넣음
	
	//게시물 상세보기
	@Select("select seqno, userid, writer, title, to_char(regdate,'YYYY-MM-DD HH24:MI:SS') as regdate, content, org_filename, stored_filename from tbl_board where seqno = ${seqno}")
	public BoardVO view(@Param("seqno") int seqno);
	
	//조회수 업데이트
	@Update("update tbl_board set hitno=(select hitno from tbl_board where seqno = ${board.seqno}) +1 where seqno = ${board.seqno}")
	public void hitno(@Param("board") BoardVO board);
	
	//게시물 수정
	@Update("update tbl_board set writer='${board.writer}',title='${board.title}',content='${board.content}' where seqno = ${board.seqno}")
	public void modify(@Param("board") BoardVO board);
	
	//게시물 삭제
	@Delete("delete from tbl_board where seqno=${seqno}")
	public void delete(@Param("seqno") int seqno);
	
}
