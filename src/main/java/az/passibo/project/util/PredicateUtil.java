package az.passibo.project.util;


import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class PredicateUtil {

    private final List<Predicate> predicates = new ArrayList<>();

    public static PredicateUtil builder() {
        return new PredicateUtil();
    }

    public <T> PredicateUtil add(T object, Function<T, Predicate> function) {
        predicates.add(function.apply(object));
        return this;
    }

    public <T> PredicateUtil add(Collection<T> collection, Function<Collection<T>, Predicate> function) {
        if (CollectionUtils.isNotEmpty(collection)) {
            predicates.add(function.apply(collection));
        }
        return this;
    }

    public <T> PredicateUtil addNullSafety(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public <T> PredicateUtil addNullSafety(Collection<T> collection, Function<Collection<T>, Predicate> function) {
        if (CollectionUtils.isNotEmpty(collection)) {
            predicates.add(function.apply(collection));
        }
        return this;
    }

    public Predicate[] build() {
        return predicates.toArray(new Predicate[0]);
    }
}