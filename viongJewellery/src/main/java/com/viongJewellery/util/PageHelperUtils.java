package com.viongJewellery.util;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.function.Function;

public class PageHelperUtils {
    public static <E, D> PageInfo<D> convertPage(PageInfo<E> source, Function<E, D> converter) {
        List<D> mappedList = source.getList().stream().map(converter).toList();
        PageInfo<D> result = new PageInfo<>();
        result.setList(mappedList);
        result.setPageNum(source.getPageNum());
        result.setPageSize(source.getPageSize());
        result.setTotal(source.getTotal());
        result.setPages(source.getPages());
        result.setNavigatePages(source.getNavigatePages());
        return result;
    }
}
