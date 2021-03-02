package com.tencent.thumbplayer.core.decoder;

/* access modifiers changed from: package-private */
public class TPFrameInfo {
    int bufferIndex;
    int channelCount;
    int cropBottom;
    int cropLeft;
    int cropRight;
    int cropTop;
    byte[] data;
    int errCode;
    int format;
    int height;
    long ptsUs;
    int sampleRate;
    int width;

    TPFrameInfo() {
    }
}
