package com.tencent.map.tools.net.http;

public interface HttpResponseListener<T> {
    void onFailure(int i2, String str, Throwable th);

    void onSuccess(int i2, T t);
}
