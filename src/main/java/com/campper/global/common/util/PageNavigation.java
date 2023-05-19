package com.campper.global.common.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageNavigation {

    private boolean startRange;
    private boolean endRange;
    private int totalCount;
    private int newCount;
    private int totalPageCount;
    private int currentPage;
    private int naviSize;
    private int countPerPage;
    private String navigator;
}
