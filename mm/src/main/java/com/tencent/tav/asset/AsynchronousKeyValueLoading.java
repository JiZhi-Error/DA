package com.tencent.tav.asset;

import java.util.List;

public interface AsynchronousKeyValueLoading {

    public interface loadCallback {
        void loadSucceeds();
    }

    void loadValuesAsynchronouslyForKeys(List<String> list, loadCallback loadcallback);

    int statusOfValueForKey(String str);
}
