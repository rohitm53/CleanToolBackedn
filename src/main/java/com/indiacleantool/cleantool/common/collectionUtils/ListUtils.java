package com.indiacleantool.cleantool.common.collectionUtils;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ListUtils {



    public static  <T> Stream<T> convertIterableToStream(Iterable<T>iterable){
        Spliterator<T> spliterator = iterable.spliterator();
        return StreamSupport.stream(spliterator,false);

    }

}
