package com.bookcity.book.dao;

import com.bookcity.book.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Domingos Manuel
 * Date: 06 March 2021
 * Order DAO interface
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
