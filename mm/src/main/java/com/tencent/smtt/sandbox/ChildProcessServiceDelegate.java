package com.tencent.smtt.sandbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.List;

public interface ChildProcessServiceDelegate {
    void ExitChildProcess();

    void RegisterFileDescriptors(String[] strArr, int[] iArr, int[] iArr2, long[] jArr, long[] jArr2);

    SparseArray<String> getFileDescriptorsIdsToKeys();

    void initCommandLine(String[] strArr);

    boolean loadNativeLibrary(Context context);

    void onBeforeMain();

    void onConnectionSetup(Bundle bundle, List<IBinder> list);

    void onDestroy();

    void onServiceBound(Intent intent);

    void onServiceCreated();

    void preloadNativeLibrary(Context context);

    void runMain();

    void startContentMainRunner();
}
