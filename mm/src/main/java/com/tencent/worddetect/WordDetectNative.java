package com.tencent.worddetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WordDetectNative {
    private static final String TAG = "WordDetectNative";
    private int handleId = -1;

    public static class ConfigParam {
        public String detect_model_bin;
        public String detect_model_param;
    }

    public static class WordDetectDetailResult {
        public int height;
        public float[] rate_lang;
        public byte[] rawData;
        public int width;
    }

    private native int GetDetailResult(WordDetectDetailResult wordDetectDetailResult, int i2);

    private native int GetResult(int i2);

    private static native String GetVersion();

    private native int Init(ConfigParam configParam);

    private native int Release(int i2);

    private native int ScanImage(byte[] bArr, int i2, int i3, int i4, int i5);

    static {
        AppMethodBeat.i(40076);
        System.loadLibrary("wechatWordDetectMod");
        AppMethodBeat.o(40076);
    }

    public static String getVersion() {
        AppMethodBeat.i(40070);
        String GetVersion = GetVersion();
        AppMethodBeat.o(40070);
        return GetVersion;
    }

    public int init(ConfigParam configParam) {
        AppMethodBeat.i(40071);
        if (this.handleId < 0) {
            this.handleId = Init(configParam);
        }
        if (this.handleId < 0) {
            AppMethodBeat.o(40071);
            return -1;
        }
        AppMethodBeat.o(40071);
        return 0;
    }

    public int scanImage(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(40072);
        int ScanImage = ScanImage(bArr, i2, i3, i4, this.handleId);
        AppMethodBeat.o(40072);
        return ScanImage;
    }

    public int release() {
        AppMethodBeat.i(40073);
        int Release = Release(this.handleId);
        this.handleId = -1;
        AppMethodBeat.o(40073);
        return Release;
    }

    public int getResult() {
        AppMethodBeat.i(40074);
        int GetResult = GetResult(this.handleId);
        AppMethodBeat.o(40074);
        return GetResult;
    }

    public int getDetailResult(WordDetectDetailResult wordDetectDetailResult) {
        AppMethodBeat.i(40075);
        int GetDetailResult = GetDetailResult(wordDetectDetailResult, this.handleId);
        AppMethodBeat.o(40075);
        return GetDetailResult;
    }
}
