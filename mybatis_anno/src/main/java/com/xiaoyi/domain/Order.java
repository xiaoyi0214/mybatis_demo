package com.xiaoyi.domain;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public class Order {

    private Long id;
    private String orderNo;
    private Double price;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
