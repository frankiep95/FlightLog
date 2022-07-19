package com.flightLog.utilities;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Service {

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    @SafeVarargs
    public static <T> List<T> getListWithoutDuplicates(List<T> list, Function<T, ?>... keyFunctions) {

            List<T> result = new ArrayList<>();

            Set<List<?>> set = new HashSet<>();

            for(T element : list) {
                List<?> functionResults = Arrays.stream(keyFunctions)
                        .map(function -> function.apply(element))
                        .collect(Collectors.toList());

                if(set.add(functionResults)) {
                    result.add(element);
                }
            }

            return result;
        }


}

