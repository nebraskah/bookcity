package com.bookcity.book.dao;

import com.bookcity.book.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Domingos Manuel
 * Date: 24 February 2021
 * BookOrder DAO class
 */
@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {
}
