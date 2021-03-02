package com.tencent.mm.plugin.fingerprint.faceid.auth;

public interface a {
    void onAuthCancel();

    void onAuthFail(int i2);

    void onAuthSuccess(int i2, int i3);
}
