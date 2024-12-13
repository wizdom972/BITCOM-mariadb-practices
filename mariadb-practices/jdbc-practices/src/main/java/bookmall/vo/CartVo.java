package bookmall.vo;

public class CartVo {
    private Long no;
    private Long userNo;
    private Long bookNo;
    private int quantity;
    private String bookTitle;

    public CartVo() {}

    public CartVo(Long userNo, Long bookNo, int quantity) {
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.quantity = quantity;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public Long getBookNo() {
        return bookNo;
    }

    public void setBookNo(Long bookNo) {
        this.bookNo = bookNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Override
    public String toString() {
        return "CartVo [no=" + no + ", userNo=" + userNo + ", bookNo=" + bookNo + ", quantity=" + quantity + "]";
    }
}
