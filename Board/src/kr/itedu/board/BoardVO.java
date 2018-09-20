package kr.itedu.board;

public class BoardVO {
	
	private int bid;
	private String btitle = ""; 
	private String bcontent = "";
	private String bregdate, bmodidate;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBregdate() {
		return bregdate;
	}
	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}
	public String getBmodidate() {
		return bmodidate;
	}
	public void setBmodidate(String bmodidate) {
		this.bmodidate = bmodidate;
	}
	
}
