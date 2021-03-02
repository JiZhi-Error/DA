package com.tencent.mm.appbrand.commonjni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class AppBrandJsBridgeBinding {
    private long mJsRuntimeInst = 0;

    private native long nativeCreateRuntime(long j2, long j3);

    private native void nativeDestroyRuntime(long j2);

    private native void nativeInvokeCallbackHandler(long j2, int i2, String str);

    private native void nativeSubscribeHandler(long j2, String str, String str2, int i2, String str3);

    public void createRuntime(long j2, long j3) {
        AppMethodBeat.i(201233);
        this.mJsRuntimeInst = nativeCreateRuntime(j2, j3);
        AppMethodBeat.o(201233);
    }

    public void destroyRuntime() {
        AppMethodBeat.i(201234);
        nativeDestroyRuntime(this.mJsRuntimeInst);
        AppMethodBeat.o(201234);
    }

    public void invokeCallbackHandler(int i2, String str) {
        AppMethodBeat.i(201235);
        nativeInvokeCallbackHandler(this.mJsRuntimeInst, i2, str);
        AppMethodBeat.o(201235);
    }

    public void subscribeHandler(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(201236);
        nativeSubscribeHandler(this.mJsRuntimeInst, str, str2, i2, str3);
        AppMethodBeat.o(201236);
    }
}
