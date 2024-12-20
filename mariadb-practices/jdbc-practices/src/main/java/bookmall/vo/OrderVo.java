package bookmall.vo;

public class OrderVo {
    private Long no;
    private Long userNo;
    private String number;
    private int payment;
    private String shipping;
    private String status;

    public OrderVo() {}

    public OrderVo(Long userNo, String number, int payment, String shipping, String status) {
        this.userNo = userNo;
        this.number = number;
        this.payment = payment;
        this.shipping = shipping;
        this.status = status;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersVo [no=" + no + ", userNo=" + userNo + ", number=" + number + ", payment=" + payment + ", shipping=" + shipping + ", status=" + status + "]";
    }
}
