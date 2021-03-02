package com.tencent.mm.appbrand.commonjni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.a;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.c;
import java.nio.ByteBuffer;

@Keep
public class AppBrandCommonBindingJni {
    private static final String TAG = "MicroMsg.AppBrandRuntimeJni";
    private a.b mAppBrandDelegate = new a.C0266a();
    private long mNativeHandle = 0;

    public static native boolean nativeBrotliDecompress(String str, String str2);

    private native long nativeCreate(AppBrandCommonBindingJniParams appBrandCommonBindingJniParams);

    private native void nativeDestroy(long j2);

    private native void nativePause(long j2);

    private native void nativeRequestV8GarbageCollectionForTest(long j2);

    private native void nativeResume(long j2);

    private native void nativeRuntimeReady(long j2, String str, String str2);

    private native void nativeSuspend(long j2);

    static {
        AppMethodBeat.i(201232);
        b.loadLibrary("wxa-runtime-binding");
        AppMethodBeat.o(201232);
    }

    public AppBrandCommonBindingJni(a.b bVar) {
        AppMethodBeat.i(201218);
        if (bVar != null) {
            this.mAppBrandDelegate = bVar;
            AppMethodBeat.o(201218);
            return;
        }
        c.C0267c.w(TAG, "hy: not specify delegate, use default", new Object[0]);
        AppMethodBeat.o(201218);
    }

    public void notifyCreate(AppBrandCommonBindingJniParams appBrandCommonBindingJniParams) {
        AppMethodBeat.i(201219);
        this.mNativeHandle = nativeCreate(appBrandCommonBindingJniParams);
        c.C0267c.i(TAG, "hy: created with %d", Long.valueOf(this.mNativeHandle));
        AppMethodBeat.o(201219);
    }

    public void notifyRuntimeReady(String str, String str2) {
        AppMethodBeat.i(201220);
        if (this.mNativeHandle > 0) {
            nativeRuntimeReady(this.mNativeHandle, str, str2);
        }
        AppMethodBeat.o(201220);
    }

    public void notifyResume() {
        AppMethodBeat.i(201221);
        if (this.mNativeHandle > 0) {
            nativeResume(this.mNativeHandle);
        }
        AppMethodBeat.o(201221);
    }

    public void notifyPause() {
        AppMethodBeat.i(201222);
        if (this.mNativeHandle > 0) {
            nativePause(this.mNativeHandle);
        }
        AppMethodBeat.o(201222);
    }

    public void notifyDestroy() {
        AppMethodBeat.i(201223);
        if (this.mNativeHandle > 0) {
            nativeDestroy(this.mNativeHandle);
            this.mNativeHandle = 0;
        }
        AppMethodBeat.o(201223);
    }

    public void notifySuspend() {
        AppMethodBeat.i(201224);
        if (this.mNativeHandle > 0) {
            nativeSuspend(this.mNativeHandle);
        }
        AppMethodBeat.o(201224);
    }

    public void requestV8GarbageCollectionForTest() {
        AppMethodBeat.i(201225);
        if (this.mNativeHandle > 0) {
            nativeRequestV8GarbageCollectionForTest(this.mNativeHandle);
        }
        AppMethodBeat.o(201225);
    }

    /* access modifiers changed from: protected */
    @Keep
    public String nativeInvokeHandler(String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(201226);
        String nativeInvokeHandler = this.mAppBrandDelegate.nativeInvokeHandler(str, str2, i2, z);
        AppMethodBeat.o(201226);
        return nativeInvokeHandler;
    }

    /* access modifiers changed from: protected */
    @Keep
    public String[] getAsyncableJsApis() {
        AppMethodBeat.i(201227);
        String[] asyncableJsApis = this.mAppBrandDelegate.getAsyncableJsApis();
        AppMethodBeat.o(201227);
        return asyncableJsApis;
    }

    /* access modifiers changed from: package-private */
    @Keep
    public ByteBuffer readWeAppFile(String str) {
        AppMethodBeat.i(201228);
        ByteBuffer readWeAppFile = this.mAppBrandDelegate.readWeAppFile(str);
        AppMethodBeat.o(201228);
        return readWeAppFile;
    }

    /* access modifiers changed from: protected */
    @Keep
    public void resumeLoopTasks() {
        AppMethodBeat.i(201229);
        this.mAppBrandDelegate.resumeLoopTasks();
        AppMethodBeat.o(201229);
    }

    /* access modifiers changed from: protected */
    @Keep
    public boolean doInnerLoopTask() {
        AppMethodBeat.i(201230);
        boolean doInnerLoopTask = this.mAppBrandDelegate.doInnerLoopTask();
        AppMethodBeat.o(201230);
        return doInnerLoopTask;
    }

    /* access modifiers changed from: protected */
    @Keep
    public boolean syncInitModule(String str, String str2) {
        AppMethodBeat.i(201231);
        c.C0267c.i(TAG, "hy: request init %s with params %s", str, str2);
        boolean syncInitModule = this.mAppBrandDelegate.syncInitModule(str, str2);
        AppMethodBeat.o(201231);
        return syncInitModule;
    }
}
