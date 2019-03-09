package reply.service;

import java.util.ArrayList;

import board.dto.BoardDTO;
import reply.dto.ReplyDTO;


public interface ReplyService {
	int replyInsert(ReplyDTO replywrite);
	
	ArrayList<ReplyDTO> replyList(int boardNo);
	
	
}
