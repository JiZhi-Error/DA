package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector;
import java.util.Set;

public class TPHeadsetPluginCallbackToNative implements TPHeadsetPluginDetector.HeadsetPluginListener {
    private static final String TAG = "TPHeadsetPluginCallback";
    private long mNativeContext;

    private native void _onAudioRouteChanged(Set<Integer> set, Set<Integer> set2);

    private TPHeadsetPluginCallbackToNative(long j2) {
        this.mNativeContext = j2;
    }

    @TPMethodCalledByNative
    private void registerCallback() {
        AppMethodBeat.i(189733);
        TPHeadsetPluginDetector.addHeadsetPluginListener(this);
        AppMethodBeat.o(189733);
    }

    @TPMethodCalledByNative
    private void unregisterCallback() {
        AppMethodBeat.i(189734);
        TPHeadsetPluginDetector.removeHeadsetPluginListener(this);
        AppMethodBeat.o(189734);
    }

    @TPMethodCalledByNative
    private long getNativeContext() {
        return this.mNativeContext;
    }

    @Override // com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.HeadsetPluginListener
    public void onHeadsetPlugin(Set<Integer> set, Set<Integer> set2) {
        AppMethodBeat.i(189735);
        TPNativeLog.printLog(2, TAG, "onHeadsetPlugin: oldOutputs: " + set + ", newOutputs: " + set2);
        _onAudioRouteChanged(set, set2);
        AppMethodBeat.o(189735);
    }
}
