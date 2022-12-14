package reference;

public class ReferenceVO {
	private int idx;
	private String nickName;
	private String title;
	private String content;
	private String wDate;
	private int readNum;
	private String mid;
	
	// 날짜형식필드를 '문자'와 '숫자'로 저장시켜주기 위한 변수 선언
	private String wCdate;
	private int wNdate;
	
	// '이전글','다음글'을 위한 변수 선언
	private int preIdx;
	private int nextIdx;
	private String preTitle;
	private String nextTitle;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getwDate() {
		return wDate;
	}
	public void setwDate(String wDate) {
		this.wDate = wDate;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getwCdate() {
		return wCdate;
	}
	public void setwCdate(String wCdate) {
		this.wCdate = wCdate;
	}
	public int getwNdate() {
		return wNdate;
	}
	public void setwNdate(int wNdate) {
		this.wNdate = wNdate;
	}
	public int getPreIdx() {
		return preIdx;
	}
	public void setPreIdx(int preIdx) {
		this.preIdx = preIdx;
	}
	public int getNextIdx() {
		return nextIdx;
	}
	public void setNextIdx(int nextIdx) {
		this.nextIdx = nextIdx;
	}
	public String getPreTitle() {
		return preTitle;
	}
	public void setPreTitle(String preTitle) {
		this.preTitle = preTitle;
	}
	public String getNextTitle() {
		return nextTitle;
	}
	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
	@Override
	public String toString() {
		return "NoticeVO [idx=" + idx + ", nickName=" + nickName + ", title=" + title + ", content=" + content + ", wDate="
				+ wDate + ", readNum=" + readNum + ", mid=" + mid + ", wCdate=" + wCdate + ", wNdate=" + wNdate + ", preIdx="
				+ preIdx + ", nextIdx=" + nextIdx + ", preTitle=" + preTitle + ", nextTitle=" + nextTitle + "]";
	}
	

}
