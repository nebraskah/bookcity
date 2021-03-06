package com.bookcity.book.dao;

import com.bookcity.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Domingos Manuel
 * Date: 24 February 2021
 * Book DAO interface
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
