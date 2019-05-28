package com.itheima.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * * 所有的注解都是使用JPA的规范提供的注解，
 * * 所以在导入注解包的时候，一定要导入javax.persistence下的
 */
@Entity //声明实体类
@Table(name = "cst_customer") //建立实体类和表的映射关系
public class Customer {

    @Id//声明当前私有属性为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //配置主键的生成策略
    @Column(name = "cust_id") //指定和表中cust_id字段的映射关系
    private Long custId;

    @Column(name = "cust_name") //指定和表中cust_name字段的映射关系
    private String custName;

    @Column(name = "cust_source")//指定和表中cust_source字段的映射关系
    private String custSource;

    @Column(name = "cust_industry")//指定和表中cust_industry字段的映射关系
    private String custIndustry;

    @Column(name = "cust_level")//指定和表中cust_level字段的映射关系
    private String custLevel;

    @Column(name = "cust_address")//指定和表中cust_address字段的映射关系
    private String custAddress;

    @Column(name = "cust_phone")//指定和表中cust_phone字段的映射关系
    private String custPhone;

//    @OneToMany(targetEntity = LinkMan.class,cascade = CascadeType.ALL) //targetEntity = LinkMan.class：指定目标的实体类的对象
//   @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    @OneToMany(mappedBy="customer") //当前客户对象放弃了维护 cascade:联级操作    mappedBy:指定从表实体类中引用主表对象的名称
    private Set<LinkMan> linkmans=new HashSet<LinkMan>(0);


    public Set<LinkMan> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(Set<LinkMan> linkmans) {
        this.linkmans = linkmans;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}