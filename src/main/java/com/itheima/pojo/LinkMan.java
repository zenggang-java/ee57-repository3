package com.itheima.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 联系人的实体类（数据模型）
 */
@Entity
@Table(name = "cst_linkman")
public class LinkMan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long lkmId;
    @Column(name = "lkm_name")
    private String lkmName;
    @Column(name = "lkm_gender")
    private String lkmGender;
    @Column(name = "lkm_phone")
    private String lkmPhone;
    @Column(name = "lkm_mobile")
    private String lkmMobile;
    @Column(name = "lkm_email")
    private String lkmEmail;
    @Column(name = "lkm_position")
    private String lkmPosition;
    @Column(name = "lkm_memo")
    private String lkmMemo;

    //多对一关系映射：多个联系人对应客户，外键是在联系人中
    @ManyToOne(targetEntity = Customer.class) //目标实体对象
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id") //当前联系人从表中的外键关联主键ID的设置
    private Customer customer;//用它的主键，对应联系人表中的外键 判断是否是集合，
    // 当前的关联的是不是一多，联系人关联一个客户。
    // 这里我们用customer

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan [lkmId=" + lkmId + ", lkmName=" + lkmName + ", lkmGender=" + lkmGender + ", lkmPhone="
                + lkmPhone + ", lkmMobile=" + lkmMobile + ", lkmEmail=" + lkmEmail + ", lkmPosition=" + lkmPosition
                + ", lkmMemo=" + lkmMemo + "]";
    }
}