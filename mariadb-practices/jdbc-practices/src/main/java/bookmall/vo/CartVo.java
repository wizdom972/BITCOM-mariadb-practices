package bookmall.vo;

public class CartVo {
    private int no;
    private int userNo;
    private int bookNo;
    private int quantity;

    public CartVo() {}

    public CartVo(int userNo, int bookNo, int quantity) {
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.quantity = quantity;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
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
