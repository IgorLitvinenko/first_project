package com.project.jpa;

import com.project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderName(String orderName);

    @Transactional
    @Modifying
    @Query(value = "delete from `order` u where u.order_name = :orderName", nativeQuery = true )
    void deleteOrderByOrderName(@Param("orderName") String orderName);

    void deleteByOrderName(String orderName);
}
