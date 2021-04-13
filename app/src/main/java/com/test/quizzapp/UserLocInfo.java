package com.test.quizzapp;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.GeoPoint;

public class UserLocInfo {
    private GeoPoint gp;

    public UserLocInfo(GeoPoint gp) {
        this.gp = gp;
    }

    public UserLocInfo() {
    }

    public GeoPoint getGp() {
        return gp;
    }

    public void setGp(GeoPoint gp) {
        this.gp = gp;
    }
}
