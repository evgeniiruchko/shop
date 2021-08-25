package ru.garant21.routing.dtos;

import java.util.ArrayList;
import java.util.List;

public class ListIdProducts {
    List<Long> listId = new ArrayList<>();

    public List<Long> getListId() {
        return listId;
    }

    public void setListId(List<Long> listId) {
        this.listId = listId;
    }
}
