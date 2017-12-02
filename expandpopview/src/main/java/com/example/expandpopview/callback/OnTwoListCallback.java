package com.example.expandpopview.callback;

/**
 * Created by thatnight on 2017.11.27.
 */

public interface OnTwoListCallback {
    void returnParentKey(int pos, String value);

    void returnChildKey(int pos, String value);
}
