package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.sdk.platformtools.Log;

public class ScanFastFocusEngineNative {
    private static final String TAG = "MicroMsg.ScanFastFocusEngineNative";
    public byte[] bestImageData;
    public int bestImageId;
    public GoodsObject cropObject = new GoodsObject();
    public int height = 0;
    public int pointCount = 0;
    public ScanPoint[] points = new ScanPoint[10];
    public int result = 0;
    public int width = 0;

    public native ScanImagePHashInfo computeImagePHash(byte[] bArr, int i2, int i3, boolean z);

    public native ScanPoint[] getPointObjects();

    public native String getReportString();

    public native boolean isAICrop();

    public native boolean isUsingAI();

    public native int nativeInit(int i2, int i3, int i4, int i5, int i6, String str, String str2, boolean z);

    public native void nativeRelease();

    public native ScanFastFocusEngineNative process(byte[] bArr, int i2, int i3);

    public native void reset();

    public native void setConfig(String str);

    public native void setNetSpeed(int i2);

    public native void setServerState(int i2);

    public native ScanFrameProcessResult shouldJump(float f2, float f3, float f4, float f5, int i2, boolean z);

    static {
        AppMethodBeat.i(51649);
        try {
            System.loadLibrary("ffengine");
            System.loadLibrary("focusEngineJni");
            AppMethodBeat.o(51649);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "alvinluo FocusEngine init exception", new Object[0]);
            AppMethodBeat.o(51649);
        }
    }

    public ScanFastFocusEngineNative() {
        AppMethodBeat.i(51647);
        Log.i(TAG, "alvinluo ScanFastFocusEngineNative constructor %s", Integer.valueOf(hashCode()));
        init();
        AppMethodBeat.o(51647);
    }

    private void init() {
        AppMethodBeat.i(51648);
        for (int i2 = 0; i2 < this.points.length; i2++) {
            this.points[i2] = new ScanPoint();
        }
        AppMethodBeat.o(51648);
    }

    public void resetStatus() {
        this.bestImageData = null;
    }
}
