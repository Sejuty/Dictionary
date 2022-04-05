package com.nishat00.dictionary;

import com.nishat00.dictionary.model.APIResponse;

public interface OnFetchDataListener {

    void OnFetchData(APIResponse apiResponse, String message);
    void OnError(String message);

}
