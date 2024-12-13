package bookmall.vo;

public class OrderBookVo {
    private long no;
    private long orderNo;
    private long bookNo;
    private int quantity;
    private int price;

    public OrderBookVo() {}

    public OrderBookVo(long orderNo, long bookNo, int quantity, int price) {
        this.orderNo = orderNo;
        this.bookNo = bookNo;
        this.quantity = quantity;
        this.price = price;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
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
