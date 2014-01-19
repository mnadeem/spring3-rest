package com.nadeem.app.rest.common;

import java.util.List;

import org.dozer.Mapper;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class EntityConverter
{

    private EntityConverter() {

    }

    public static <F, T> T fill(final Mapper mapper, F source, T destination) {
        if (source == null || destination == null) return null;
        mapper.map(source, destination);
        return destination;
    }

    public static <F, T> List<T> convert(final Mapper mapper, List<F> fromList, final Class<T> toClass) {
        return Lists.transform(fromList, new Function<F, T>() {
            @Override
            public T apply(F from) {
                return convert(mapper, from, toClass);
            }
        });
    }

    public static <F, T> T convert(final Mapper mapper, F from, final Class<T> toClass) {
        if (from == null) return null;
        return mapper.map(from, toClass);
    }
}
