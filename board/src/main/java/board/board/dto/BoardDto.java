package board.board.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private Date createdDatetime;
	private String updaterId;
	private Date updatedDatetime;

}
