package com.zajacmarek.lab3.dto;

import java.util.List;

public class UsersResponse {
    public UsersResponse(int totalCount, int pagesCount, int pageNumber, int pageSize, List<UserItemResponse> users) {
        this.totalCount = totalCount;
        this.pagesCount = pagesCount;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.users = users;
    }

    public int totalCount;
    public int pagesCount;
    public int pageNumber;
    public int pageSize;
    public List<UserItemResponse> users;
}
