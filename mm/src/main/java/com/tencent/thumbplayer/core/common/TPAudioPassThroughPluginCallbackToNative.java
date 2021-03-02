package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector;

public class TPAudioPassThroughPluginCallbackToNative implements TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener {
    private static final String TAG = "TPAudioPassThroughPluginCallback";
    private long mNativeContext;

    private native void _onAudioPassThroughStateChanged(boolean z);

    private TPAudioPassThroughPluginCallbackToNative(long j2) {
        this.mNativeContext = j2;
    }

    @TPMethodCalledByNative
    private void registerCallback() {
        AppMethodBeat.i(189677);
        TPAudioPassThroughPluginDetector.addListener(this);
        AppMethodBeat.o(189677);
    }

    @TPMethodCalledByNative
    private void unregisterCallback() {
        AppMethodBeat.i(189678);
        TPAudioPassThroughPluginDetector.removeListener(this);
        AppMethodBeat.o(189678);
    }

    @TPMethodCalledByNative
    private long getNativeContext() {
        return this.mNativeContext;
    }

    @Override // com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener
    public void onAudioPassThroughPlugin(boolean z) {
        AppMethodBeat.i(189679);
        TPNativeLog.printLog(2, TAG, "onAudioPassThroughPlugin bPlugin:".concat(String.valueOf(z)));
        _onAudioPassThroughStateChanged(z);
        AppMethodBeat.o(189679);
    }
}
