package bookmall.vo;

public class CartVo {
    private long no;
    private long userNo;
    private long bookNo;
    private int quantity;

    public CartVo() {}

    public CartVo(long userNo, long bookNo, int quantity) {
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.quantity = quantity;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public long getUserNo() {
        return userNo;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public long getBookNo() {
        return bookNo;
    }

    public void setBookNo(long bookNo) {
        this.bookNo = bookNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartVo [no=" + no + ", userNo=" + userNo + ", bookNo=" + bookNo + ", quantity=" + quantity + "]";
    }
}
