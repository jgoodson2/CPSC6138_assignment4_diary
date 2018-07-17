package com.jtgoodson.cpsc6138_assignment4_diary;

import java.sql.Time;

public class DiaryEntry {

    private int _id;
    private Time _timestamp;
    private String _subject;
    private String _content;

    public DiaryEntry(Time timestamp, String subject, String content) {
        this._timestamp = timestamp;
        this._subject = subject;
        this._content = content;
    }

    public DiaryEntry() {
    }

    public Time get_timestamp() {
        return _timestamp;
    }

    public void set_timestamp(Time _timestamp) {
        this._timestamp = _timestamp;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_subject() {
        return _subject;
    }

    public void set_subject(String _subject) {
        this._subject = _subject;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }
}
