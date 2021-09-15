package ru.garant21.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.garant21.products.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
