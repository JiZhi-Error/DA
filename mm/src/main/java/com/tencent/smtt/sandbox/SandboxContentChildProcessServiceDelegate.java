package com.tencent.smtt.sandbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.Arrays;
import java.util.List;
import org.chromium.base.UnguessableToken;
import org.chromium.content.common.IGpuProcessCallback;
import org.chromium.content.common.SurfaceWrapper;

@JNINamespace("content")
public class SandboxContentChildProcessServiceDelegate implements ChildProcessServiceDelegate {
    static final /* synthetic */ boolean $assertionsDisabled = (!SandboxContentChildProcessServiceDelegate.class.desiredAssertionStatus());
    private static final String TAG = "ContentCPSDelegate";
    private int mCpuCount;
    private long mCpuFeatures;
    private SparseArray<String> mFdsIdsToKeys;
    private IGpuProcessCallback mGpuCallback;
    private ChildProcessService mService = null;

    private static native void nativeExitChildProcess();

    private native void nativeInitChildProcess(int i2, long j2);

    private static native void nativeInitCommandLine(String[] strArr);

    private static native int nativeInvoke(String str, String[] strArr);

    private static native void nativeRegisterFileDescriptors(String[] strArr, int[] iArr, int[] iArr2, long[] jArr, long[] jArr2);

    private native void nativeRetrieveFileDescriptorsIdsToKeys();

    private native void nativeShutdownMainThread();

    private static native int nativeStartContentMain();

    static {
        AppMethodBeat.i(53784);
        AppMethodBeat.o(53784);
    }

    public void setService(ChildProcessService childProcessService) {
        this.mService = childProcessService;
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void onServiceCreated() {
        AppMethodBeat.i(53767);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] ...");
        AppMethodBeat.o(53767);
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void onServiceBound(Intent intent) {
        AppMethodBeat.i(53768);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] intent: " + intent);
        AppMethodBeat.o(53768);
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void onConnectionSetup(Bundle bundle, List<IBinder> list) {
        AppMethodBeat.i(53769);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] connectionBundle: " + bundle + " clientInterfaces: " + list);
        this.mGpuCallback = (list == null || list.isEmpty()) ? null : IGpuProcessCallback.Stub.asInterface(list.get(0));
        this.mCpuCount = bundle.getInt(TbsCoreSettings.EXTRA_CPU_COUNT);
        this.mCpuFeatures = bundle.getLong(TbsCoreSettings.EXTRA_CPU_FEATURES);
        if ($assertionsDisabled || this.mCpuCount > 0) {
            AppMethodBeat.o(53769);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(53769);
        throw assertionError;
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void preloadNativeLibrary(Context context) {
        AppMethodBeat.i(53770);
        Log.i(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] hostContext: " + context, new Object[0]);
        AppMethodBeat.o(53770);
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public boolean loadNativeLibrary(Context context) {
        AppMethodBeat.i(53771);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] hostContext: " + context);
        AppMethodBeat.o(53771);
        return true;
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public SparseArray<String> getFileDescriptorsIdsToKeys() {
        AppMethodBeat.i(53772);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        if ($assertionsDisabled || this.mFdsIdsToKeys != null) {
            SparseArray<String> sparseArray = this.mFdsIdsToKeys;
            AppMethodBeat.o(53772);
            return sparseArray;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(53772);
        throw assertionError;
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void onBeforeMain() {
        AppMethodBeat.i(53773);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        nativeInitChildProcess(this.mCpuCount, this.mCpuFeatures);
        AppMethodBeat.o(53773);
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void initCommandLine(String[] strArr) {
        AppMethodBeat.i(53774);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] args: " + Arrays.toString(strArr));
        nativeInitCommandLine(strArr);
        AppMethodBeat.o(53774);
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void onDestroy() {
        AppMethodBeat.i(53775);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        nativeShutdownMainThread();
        AppMethodBeat.o(53775);
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void runMain() {
        AppMethodBeat.i(53776);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        RuntimeException runtimeException = new RuntimeException("ContentMain.start un-implemented!");
        AppMethodBeat.o(53776);
        throw runtimeException;
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void startContentMainRunner() {
        AppMethodBeat.i(53777);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] result: " + nativeStartContentMain());
        AppMethodBeat.o(53777);
    }

    @CalledByNative
    private void setFileDescriptorsIdsToKeys(int[] iArr, String[] strArr) {
        AppMethodBeat.i(53778);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        if (!$assertionsDisabled && iArr.length != strArr.length) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(53778);
            throw assertionError;
        } else if ($assertionsDisabled || this.mFdsIdsToKeys == null) {
            this.mFdsIdsToKeys = new SparseArray<>();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.mFdsIdsToKeys.put(iArr[i2], strArr[i2]);
            }
            AppMethodBeat.o(53778);
        } else {
            AssertionError assertionError2 = new AssertionError();
            AppMethodBeat.o(53778);
            throw assertionError2;
        }
    }

    @CalledByNative
    private void forwardSurfaceTextureForSurfaceRequest(UnguessableToken unguessableToken, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(53779);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        if (this.mGpuCallback == null) {
            Log.e(TAG, "No callback interface has been provided.", new Object[0]);
            AppMethodBeat.o(53779);
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        try {
            this.mGpuCallback.forwardSurfaceForSurfaceRequest(unguessableToken, surface);
            this.mGpuCallback.invokeMiscMethod("invokeX5Core", new Bundle());
        } catch (RemoteException e2) {
            Log.e(TAG, "Unable to call forwardSurfaceForSurfaceRequest: %s", e2);
        } finally {
            surface.release();
            AppMethodBeat.o(53779);
        }
    }

    @CalledByNative
    private Surface getViewSurface(int i2) {
        AppMethodBeat.i(53780);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        if (this.mGpuCallback == null) {
            Log.e(TAG, "No callback interface has been provided.", new Object[0]);
            AppMethodBeat.o(53780);
            return null;
        }
        try {
            SurfaceWrapper viewSurface = this.mGpuCallback.getViewSurface(i2);
            if (viewSurface != null) {
                Surface surface = viewSurface.getSurface();
                AppMethodBeat.o(53780);
                return surface;
            }
            AppMethodBeat.o(53780);
            return null;
        } catch (RemoteException e2) {
            Log.e(TAG, "Unable to call getViewSurface: %s", e2);
            AppMethodBeat.o(53780);
            return null;
        }
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void RegisterFileDescriptors(String[] strArr, int[] iArr, int[] iArr2, long[] jArr, long[] jArr2) {
        AppMethodBeat.i(53781);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        nativeRegisterFileDescriptors(strArr, iArr, iArr2, jArr, jArr2);
        AppMethodBeat.o(53781);
    }

    @Override // com.tencent.smtt.sandbox.ChildProcessServiceDelegate
    public void ExitChildProcess() {
        AppMethodBeat.i(53782);
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        nativeExitChildProcess();
        AppMethodBeat.o(53782);
    }

    @CalledByNative
    public String invokeMiscMethod(String str, Bundle bundle) {
        AppMethodBeat.i(53783);
        Log.d(TAG, "invokeMiscMethod -- method: " + str + ", bundle: " + bundle);
        String str2 = null;
        if (str.equals("lazyLoadLibrary")) {
            str2 = String.valueOf(this.mService.lazyLoadLibraryByName(bundle.getString("libraryName")));
        }
        AppMethodBeat.o(53783);
        return str2;
    }
}
