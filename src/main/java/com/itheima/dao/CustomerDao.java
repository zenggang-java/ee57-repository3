package com.itheima.dao;

import com.itheima.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    /*
     *查询所有的数据
     *使用的是JPQL
     *语句来进行的查询
     */

}