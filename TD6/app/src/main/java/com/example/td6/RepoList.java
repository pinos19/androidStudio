package com.example.td6;

import java.util.List;

public class RepoList {
    private List<Repo> items;

    public int getSize(){
        return items.size();
    }
    public Repo getItems(int ind) {
        return items.get(ind);
    }
}
