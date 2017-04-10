package com.chunyanwang.criminalintent;

import java.util.UUID;

/**
 * Created by chunyanwang on 4/5/17.
 */

public class Crime {
    private UUID id;
    private String title;

    public Crime() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
