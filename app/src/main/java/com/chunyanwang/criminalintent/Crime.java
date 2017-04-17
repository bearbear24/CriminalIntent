package com.chunyanwang.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Data model holds a office crime.
 */
public class Crime {
    private UUID id;
    private String title;
    private Date date;
    private boolean solved;

    public Crime() {
        id = UUID.randomUUID();
        date = new Date();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
      return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
