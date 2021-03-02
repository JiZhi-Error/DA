package com.tencent.wxmm;

public interface IVoipCallBack {
    void callBackFromVoip1(int i2, int i3, byte[] bArr);

    byte[] callBackFromVoip2(int i2, int i3, byte[] bArr);
}
