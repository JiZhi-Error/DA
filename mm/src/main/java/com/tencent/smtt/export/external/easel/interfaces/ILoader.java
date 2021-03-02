package com.tencent.smtt.export.external.easel.interfaces;

public interface ILoader {

    public interface Delegate {
        void didFail();

        void didFinishLoading();

        void didReceiveData(byte[] bArr, int i2);

        void didReceiveResponse(int i2);
    }

    void cancel();

    void load(String str, String str2);

    void setDelegate(Delegate delegate);
}
