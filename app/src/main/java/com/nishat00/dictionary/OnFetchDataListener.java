package com.nishat00.dictionary;

public interface OnFetchDataListener {

    void OnFetchData(DataModel dataModel, String message);
    void OnError(String message);

}
