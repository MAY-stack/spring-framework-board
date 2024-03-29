package com.MarisolBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarisolBoard.dao.MasterDAO;
import com.MarisolBoard.dto.FileVO;

@Service
public class MasterServiceImpl implements MasterService{

	@Autowired
	MasterDAO dao;
	
	//삭제 파일 목록 갯수
	@Override
	public int fileDeleteCount() {
		return dao.fileDeleteCount();
	}
	
	//삭제 파일 목록 정보
	@Override
	public List<FileVO> fileDeleteList(){
		return dao.fileDeleteList();
	}
	
	//파일 삭제
	@Override
	public void deleteFile(int fileseqno) {
		dao.deleteFile(fileseqno);
	}
	
}
