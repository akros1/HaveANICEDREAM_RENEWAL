package board.service;

import java.util.ArrayList;

import board.dto.BoardDTO;


public interface BoardService {
	int boardInsert(BoardDTO boardwrite);
	
	ArrayList<BoardDTO> boardList();
	
	BoardDTO boardRead(int boardNo);
	
	int boardDelete(int boardNo);
}
