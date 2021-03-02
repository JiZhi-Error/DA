package com.tencent.wxmm;

public interface IConfCallBack {
    byte[] callBackFromConf(int i2, int i3, byte[] bArr);

    void callbackWriteLog(int i2, String str, String str2, int i3, String str3, String str4, int i4);
}
