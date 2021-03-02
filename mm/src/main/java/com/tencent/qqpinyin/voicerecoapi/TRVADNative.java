package com.tencent.qqpinyin.voicerecoapi;

public class TRVADNative {
    public native int mfeClose();

    public native int mfeDetect();

    public native int mfeEnableNoiseDetection(boolean z);

    public native int mfeExit();

    public native int mfeGetCallbackData(byte[] bArr, int i2);

    public native int mfeGetEndFrame();

    public native int mfeGetParam(int i2);

    public native int mfeGetStartFrame();

    public native int mfeInit(int i2, int i3);

    public native int mfeOpen();

    public native int mfeSendData(short[] sArr, int i2);

    public native void mfeSetLogLevel(int i2);

    public native int mfeSetParam(int i2, int i3);

    public native int mfeStart();

    public native int mfeStop();
}
