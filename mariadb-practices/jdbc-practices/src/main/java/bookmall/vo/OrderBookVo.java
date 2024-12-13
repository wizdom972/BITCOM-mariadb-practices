package bookmall.vo;

public class OrderBookVo {
    private Long no;
    private Long orderNo;
    private Long bookNo;
    private int quantity;
    private int price;
    private String bookTitle;

	public OrderBookVo() {}

    public OrderBookVo(Long orderNo, Long bookNo, int quantity, int price) {
        this.orderNo = orderNo;
        this.bookNo = bookNo;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

    @Override
    public String toString() {
        return "OrderBookVo [no=" + no + ", orderNo=" + orderNo + ", bookNo=" + bookNo + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
