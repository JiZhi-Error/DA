package com.pay.http;

public interface IAPHttpAns {
    void onError(APBaseHttpReq aPBaseHttpReq, int i2, String str);

    void onFinish(APBaseHttpReq aPBaseHttpReq);

    void onReceive(byte[] bArr, int i2, long j2, APBaseHttpReq aPBaseHttpReq);

    void onStart(APBaseHttpReq aPBaseHttpReq);

    void onStop(APBaseHttpReq aPBaseHttpReq);
}
