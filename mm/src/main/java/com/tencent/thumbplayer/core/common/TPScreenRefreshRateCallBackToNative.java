package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector;

public class TPScreenRefreshRateCallBackToNative implements TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener {
    private static final String TAG = "TPScreenRefreshRateCallBack";
    private long mNativeContext;

    private native void _onScreenRefreshRateChanged(float f2);

    private TPScreenRefreshRateCallBackToNative(long j2) {
        this.mNativeContext = j2;
    }

    @TPMethodCalledByNative
    private void registerCallback() {
        AppMethodBeat.i(189793);
        TPScreenRefreshRateDetector.addListener(this);
        AppMethodBeat.o(189793);
    }

    @TPMethodCalledByNative
    private void unregisterCallback() {
        AppMethodBeat.i(189794);
        TPScreenRefreshRateDetector.removeListener(this);
        AppMethodBeat.o(189794);
    }

    @TPMethodCalledByNative
    private long getNativeContext() {
        return this.mNativeContext;
    }

    @Override // com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener
    public void onScreenRefreshRateChanged(float f2) {
        AppMethodBeat.i(189795);
        TPNativeLog.printLog(2, TAG, "onScreenRefreshRateChanged refreshRate:".concat(String.valueOf(f2)));
        _onScreenRefreshRateChanged(f2);
        AppMethodBeat.o(189795);
    }
}
