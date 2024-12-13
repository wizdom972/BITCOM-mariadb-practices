package bookmall.vo;

public class OrderBookVo {
    private int no;
    private int orderNo;
    private int bookNo;
    private int quantity;
    private int price;

    public OrderBookVo() {}

    public OrderBookVo(int orderNo, int bookNo, int quantity, int price) {
        this.orderNo = orderNo;
        this.bookNo = bookNo;
        this.quantity = quantity;
        this.price = price;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderBookVo [no=" + no + ", orderNo=" + orderNo + ", bookNo=" + bookNo + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
