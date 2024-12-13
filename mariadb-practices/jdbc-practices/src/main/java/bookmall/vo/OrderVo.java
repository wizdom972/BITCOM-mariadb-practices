package bookmall.vo;

public class OrderVo {
    private int no;
    private int userNo;
    private String number;
    private int payment;
    private String shipping;
    private String status;

    public OrderVo() {}

    public OrderVo(int userNo, String number, int payment, String shipping, String status) {
        this.userNo = userNo;
        this.number = number;
        this.payment = payment;
        this.shipping = shipping;
        this.status = status;
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
