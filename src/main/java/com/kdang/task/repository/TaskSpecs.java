package com.kdang.task.repository;

import com.kdang.task.model.Task;
import org.springframework.data.jpa.domain.Specification;


public class TaskSpecs {

    public static Specification<Task> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }
}

// The Root object represents the entity being queried (in this case, Task).
// The CriteriaQuery object defines query structure and can be used to modify
// the query aspects like ordering and grouping.
// The CriteriaBuilder object provides a set of methods for building criteria-based
// predicates (good for creating WHERE clause).