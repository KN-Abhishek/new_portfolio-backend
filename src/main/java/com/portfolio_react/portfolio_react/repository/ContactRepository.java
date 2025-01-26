package com.portfolio_react.portfolio_react.repository;

import com.portfolio_react.portfolio_react.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
