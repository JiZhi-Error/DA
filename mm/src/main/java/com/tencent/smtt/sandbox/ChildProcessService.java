package com.tencent.smtt.sandbox;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.chromium.base.process_launcher.ICallbackInt;
import org.chromium.base.process_launcher.IChildProcessService;

public abstract class ChildProcessService extends Service {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final boolean ENABLE_DEBUG = false;
    private static final String MAIN_THREAD_NAME = "ChildProcessMain";
    private static final String TAG = "ChildProcessService";
    private static boolean sCreateCalled;
    public static boolean use_isolated_process = false;
    private byte _hellAccFlag_;
    private final Semaphore mActivitySemaphore = new Semaphore(1);
    private boolean mBindToCallerCheck;
    private final IChildProcessService.Stub mBinder = new IChildProcessService.Stub() {
        /* class com.tencent.smtt.sandbox.ChildProcessService.AnonymousClass1 */
        static final /* synthetic */ boolean $assertionsDisabled = (!ChildProcessService.class.desiredAssertionStatus());

        static {
            AppMethodBeat.i(53762);
            AppMethodBeat.o(53762);
        }

        @Override // org.chromium.base.process_launcher.IChildProcessService
        public boolean bindToCaller() {
            AppMethodBeat.i(53758);
            if (!$assertionsDisabled && !ChildProcessService.this.mBindToCallerCheck) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(53758);
                throw assertionError;
            } else if ($assertionsDisabled || ChildProcessService.this.mServiceBound) {
                synchronized (ChildProcessService.this.mBinderLock) {
                    try {
                        int callingPid = Binder.getCallingPid();
                        if (ChildProcessService.this.mBoundCallingPid == 0) {
                            ChildProcessService.this.mBoundCallingPid = callingPid;
                        } else if (ChildProcessService.this.mBoundCallingPid != callingPid) {
                            Log.e(ChildProcessService.TAG, "Service is already bound by pid %d, cannot bind for pid %d", Integer.valueOf(ChildProcessService.this.mBoundCallingPid), Integer.valueOf(callingPid));
                            AppMethodBeat.o(53758);
                            return false;
                        }
                        return true;
                    } finally {
                        AppMethodBeat.o(53758);
                    }
                }
            } else {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(53758);
                throw assertionError2;
            }
        }

        @Override // org.chromium.base.process_launcher.IChildProcessService
        public void invokeMiscMethod(String str, Bundle bundle) {
            AppMethodBeat.i(53759);
            Log.d(ChildProcessService.TAG, "invokeMiscMethod -- method: " + str + ", bundle: " + bundle);
            AppMethodBeat.o(53759);
        }

        @Override // org.chromium.base.process_launcher.IChildProcessService
        public void setupConnection(Bundle bundle, ICallbackInt iCallbackInt, List<IBinder> list) {
            AppMethodBeat.i(53760);
            Log.d(ChildProcessService.TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] args: " + bundle);
            if ($assertionsDisabled || ChildProcessService.this.mServiceBound) {
                synchronized (ChildProcessService.this.mBinderLock) {
                    try {
                        if (!ChildProcessService.this.mBindToCallerCheck || ChildProcessService.this.mBoundCallingPid != 0) {
                            iCallbackInt.call(Process.myPid());
                            ChildProcessService.this.processConnectionBundle(bundle, list);
                            AppMethodBeat.o(53760);
                            return;
                        }
                        Log.e(ChildProcessService.TAG, "Service has not been bound with bindToCaller()", new Object[0]);
                        iCallbackInt.call(-1);
                    } finally {
                        AppMethodBeat.o(53760);
                    }
                }
            } else {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(53760);
                throw assertionError;
            }
        }

        @Override // org.chromium.base.process_launcher.IChildProcessService
        public void crashIntentionallyForTesting() {
            AppMethodBeat.i(53761);
            Log.d(ChildProcessService.TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]... ");
            if ($assertionsDisabled || ChildProcessService.this.mServiceBound) {
                AppMethodBeat.o(53761);
                return;
            }
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(53761);
            throw assertionError;
        }
    };
    private final Object mBinderLock = new Object();
    private int mBoundCallingPid;
    private String[] mCommandLineParams;
    private final ChildProcessServiceDelegate mDelegate;
    private FileDescriptorInfo[] mFdInfos;
    private ParcelFileDescriptor[] mFdsOfLibraryies = null;
    private ParcelFileDescriptor[] mLazilyLoadedLibraryFDs = null;
    private CharSequence[] mLazilyLoadedLibraryNames = null;
    private boolean mLibraryInitialized;
    private final Object mLibraryInitializedLock = new Object();
    private Thread mMainThread;
    private boolean mServiceBound;

    static {
        boolean z;
        if (!ChildProcessService.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
    }

    public ChildProcessService(ChildProcessServiceDelegate childProcessServiceDelegate) {
        this.mDelegate = childProcessServiceDelegate;
        ((SandboxContentChildProcessServiceDelegate) this.mDelegate).setService(this);
    }

    public boolean isServiceIsolated(Service service) {
        try {
            String name = service.getClass().getName();
            Log.d(TAG, "## serviceName=".concat(String.valueOf(name)));
            return (service.getPackageManager().getServiceInfo(new ComponentName(service.getApplicationContext().getApplicationInfo().packageName, name), 128).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "Could not get application info", e2);
            return false;
        }
    }

    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Creating new ChildProcessService pid=%d", Integer.valueOf(Process.myPid()));
        if (sCreateCalled) {
            throw new RuntimeException("Illegal child process reuse.");
        }
        sCreateCalled = true;
        use_isolated_process = isServiceIsolated(this);
        Log.d(TAG, "## use_isolated_process=" + use_isolated_process);
        final Context applicationContext = getApplicationContext();
        ContextUtils.initApplicationContext(applicationContext);
        this.mDelegate.onServiceCreated();
        Log.d(TAG, "starting mMainThread thread @pid: " + Process.myPid());
        this.mMainThread = new Thread(new Runnable() {
            /* class com.tencent.smtt.sandbox.ChildProcessService.AnonymousClass2 */
            static final /* synthetic */ boolean $assertionsDisabled = (!ChildProcessService.class.desiredAssertionStatus());
            private byte _hellAccFlag_;

            static {
                AppMethodBeat.i(53764);
                AppMethodBeat.o(53764);
            }

            public void run() {
                boolean a2;
                AppMethodBeat.i(53763);
                Log.i(ChildProcessService.TAG, "@mMainThread run... pid: " + Process.myPid() + ", use_isolated_process:" + ChildProcessService.use_isolated_process, new Object[0]);
                try {
                    if (ChildProcessService.use_isolated_process) {
                        i.d();
                        i.a(ChildProcessService.this);
                        Log.i(ChildProcessService.TAG, "@mMainThread after prepareLinker", new Object[0]);
                    }
                    synchronized (ChildProcessService.this.mMainThread) {
                        while (ChildProcessService.this.mCommandLineParams == null) {
                            try {
                                ChildProcessService.this.mMainThread.wait();
                            } finally {
                                AppMethodBeat.o(53763);
                            }
                        }
                    }
                    if ($assertionsDisabled || ChildProcessService.this.mServiceBound) {
                        if (ChildProcessService.use_isolated_process) {
                            a2 = i.a(applicationContext, ChildProcessService.this.mFdsOfLibraryies);
                        } else {
                            a2 = i.a(applicationContext);
                        }
                        Log.i(ChildProcessService.TAG, "@mMainThread loadNativeLibrary successful: ".concat(String.valueOf(a2)), new Object[0]);
                        if (!a2) {
                            Log.e(ChildProcessService.TAG, "@mMainThread loadNativeLibrary failed!", new Object[0]);
                            a a3 = c.a(-1, new a());
                            Object obj = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj, a3.axQ(), "com/tencent/smtt/sandbox/ChildProcessService$2", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                            System.exit(((Integer) a3.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/smtt/sandbox/ChildProcessService$2", "run", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
                        } else {
                            Log.i(ChildProcessService.TAG, "@mMainThread loadNativeLibrary successful!", new Object[0]);
                            i.e();
                        }
                        ChildProcessService.this.mDelegate.initCommandLine(ChildProcessService.this.mCommandLineParams);
                        synchronized (ChildProcessService.this.mLibraryInitializedLock) {
                            try {
                                ChildProcessService.this.mLibraryInitialized = true;
                                ChildProcessService.this.mLibraryInitializedLock.notifyAll();
                            } finally {
                                AppMethodBeat.o(53763);
                            }
                        }
                        Log.d(ChildProcessService.TAG, "@mMainThread after mLibraryInitializedLock.notifyAll");
                        synchronized (ChildProcessService.this.mMainThread) {
                            try {
                                ChildProcessService.this.mMainThread.notifyAll();
                                while (ChildProcessService.this.mFdInfos == null) {
                                    ChildProcessService.this.mMainThread.wait();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        Log.d(ChildProcessService.TAG, "@mMainThread after mMainThread.wait");
                        SparseArray<String> fileDescriptorsIdsToKeys = ChildProcessService.this.mDelegate.getFileDescriptorsIdsToKeys();
                        Log.d(ChildProcessService.TAG, "@mMainThread after getFileDescriptorsIdsToKeys");
                        int[] iArr = new int[ChildProcessService.this.mFdInfos.length];
                        String[] strArr = new String[ChildProcessService.this.mFdInfos.length];
                        int[] iArr2 = new int[ChildProcessService.this.mFdInfos.length];
                        long[] jArr = new long[ChildProcessService.this.mFdInfos.length];
                        long[] jArr2 = new long[ChildProcessService.this.mFdInfos.length];
                        for (int i2 = 0; i2 < ChildProcessService.this.mFdInfos.length; i2++) {
                            FileDescriptorInfo fileDescriptorInfo = ChildProcessService.this.mFdInfos[i2];
                            String str = fileDescriptorsIdsToKeys != null ? fileDescriptorsIdsToKeys.get(fileDescriptorInfo.id) : null;
                            if (str != null) {
                                strArr[i2] = str;
                            } else {
                                iArr[i2] = fileDescriptorInfo.id;
                            }
                            if (fileDescriptorInfo.fd != null) {
                                iArr2[i2] = fileDescriptorInfo.fd.detachFd();
                            }
                            jArr[i2] = fileDescriptorInfo.offset;
                            jArr2[i2] = fileDescriptorInfo.size;
                        }
                        Log.d(ChildProcessService.TAG, "@mMainThread before RegisterFileDescriptors");
                        ChildProcessService.this.mDelegate.RegisterFileDescriptors(strArr, iArr, iArr2, jArr, jArr2);
                        Log.d(ChildProcessService.TAG, "@mMainThread after RegisterFileDescriptors");
                        ChildProcessService.this.mDelegate.onBeforeMain();
                        Log.d(ChildProcessService.TAG, "@mMainThread after onBeforeMain");
                        if (ChildProcessService.this.mActivitySemaphore.tryAcquire()) {
                            Log.d(ChildProcessService.TAG, "@mMainThread before startContentMainRunner");
                            ChildProcessService.this.mDelegate.startContentMainRunner();
                            Log.d(ChildProcessService.TAG, "@mMainThread after startContentMainRunner");
                            ChildProcessService.this.mDelegate.ExitChildProcess();
                            Log.d(ChildProcessService.TAG, "@mMainThread after ExitChildProcess");
                        }
                        AppMethodBeat.o(53763);
                        return;
                    }
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(53763);
                    throw assertionError;
                } catch (InterruptedException e2) {
                    Log.e(ChildProcessService.TAG, "%s startup failed: %s", ChildProcessService.MAIN_THREAD_NAME, e2);
                    AppMethodBeat.o(53763);
                }
            }
        }, MAIN_THREAD_NAME);
        this.mMainThread.start();
        Log.i(TAG, "onCreate end; @pid:" + Process.myPid(), new Object[0]);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroying ChildProcessService pid=%d", Integer.valueOf(Process.myPid()));
        if (this.mActivitySemaphore.tryAcquire()) {
            a a2 = c.a(0, new a());
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/smtt/sandbox/ChildProcessService", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
            System.exit(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/smtt/sandbox/ChildProcessService", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
            return;
        }
        synchronized (this.mLibraryInitializedLock) {
            while (!this.mLibraryInitialized) {
                try {
                    this.mLibraryInitializedLock.wait();
                } catch (InterruptedException e2) {
                }
            }
        }
        this.mDelegate.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] intent: " + intent);
        if ($assertionsDisabled || !this.mServiceBound) {
            stopSelf();
            this.mBindToCallerCheck = intent.getBooleanExtra(TbsCoreSettings.EXTRA_BIND_TO_CALLER, false);
            this.mServiceBound = true;
            this.mDelegate.onServiceBound(intent);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.smtt.sandbox.ChildProcessService.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(53820);
                    ChildProcessService.this.mDelegate.preloadNativeLibrary(ChildProcessService.this.getApplicationContext());
                    AppMethodBeat.o(53820);
                }
            });
            return this.mBinder;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processConnectionBundle(Bundle bundle, List<IBinder> list) {
        Log.d(TAG, "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] bundle: " + bundle);
        bundle.setClassLoader(getApplicationContext().getClassLoader());
        synchronized (this.mMainThread) {
            SandboxBuildInfo.setSandboxBuildInfo(bundle.getStringArray(TbsCoreSettings.TBS_SETTINGS_SANDBOX_BUILDINFO));
            SandboxSysUtils.setIsLowEndDevice(bundle.getBoolean(TbsCoreSettings.TBS_SETTINGS_IS_LOWEND_DEVICES));
            if (this.mCommandLineParams == null) {
                this.mCommandLineParams = bundle.getStringArray(TbsCoreSettings.EXTRA_COMMAND_LINE);
                this.mMainThread.notifyAll();
            }
            Log.d(TAG, "#processConnectionBundle# mCommandLineParams:" + Arrays.toString(this.mCommandLineParams));
            if ($assertionsDisabled || this.mCommandLineParams != null) {
                int[] intArray = bundle.getIntArray(TbsCoreSettings.EXTRA_FILE_IDS);
                Parcelable[] parcelableArray = bundle.getParcelableArray(TbsCoreSettings.EXTRA_FILE_FDS);
                long[] longArray = bundle.getLongArray(TbsCoreSettings.EXTRA_FILE_OFFSETS);
                long[] longArray2 = bundle.getLongArray(TbsCoreSettings.EXTRA_FILE_SIZES);
                Parcelable[] parcelableArray2 = bundle.getParcelableArray(TbsCoreSettings.EXTRA_FILE_FDS_OF_LIBRARIES);
                this.mFdsOfLibraryies = new ParcelFileDescriptor[parcelableArray2.length];
                for (int i2 = 0; i2 < parcelableArray2.length; i2++) {
                    this.mFdsOfLibraryies[i2] = (ParcelFileDescriptor) parcelableArray2[i2];
                }
                Log.d(TAG, "#processConnectionBundle# fds_of_libraryies:" + this.mFdsOfLibraryies);
                Log.d(TAG, "#processConnectionBundle# bundle.getIntArray ids:".concat(String.valueOf(intArray)));
                if (intArray != null) {
                    int length = intArray.length;
                    this.mFdInfos = new FileDescriptorInfo[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        this.mFdInfos[i3] = new FileDescriptorInfo(intArray[i3], (ParcelFileDescriptor) parcelableArray[i3], longArray[i3], longArray2[i3]);
                        Log.d(TAG, "#processConnectionBundle# mFdInfos[" + i3 + "](" + intArray[i3] + "," + parcelableArray[i3] + "," + longArray[i3] + "," + longArray2[i3] + ")");
                    }
                }
                this.mLazilyLoadedLibraryNames = bundle.getCharSequenceArray(TbsCoreSettings.LAZY_LOAD_LIBRARY_NAMES);
                Parcelable[] parcelableArray3 = bundle.getParcelableArray(TbsCoreSettings.LAZY_LOAD_LIBRARY_FDS);
                Log.d(TAG, "#processConnectionBundle# mLazilyLoadedLibraryNames length: " + this.mLazilyLoadedLibraryNames.length + ", lazy_fds.length: " + parcelableArray3.length);
                if (parcelableArray3 != null) {
                    this.mLazilyLoadedLibraryFDs = new ParcelFileDescriptor[this.mLazilyLoadedLibraryNames.length];
                    System.arraycopy(parcelableArray3, 0, this.mLazilyLoadedLibraryFDs, 0, this.mLazilyLoadedLibraryNames.length);
                }
                i.c();
                this.mDelegate.onConnectionSetup(bundle, list);
                this.mMainThread.notifyAll();
            } else {
                throw new AssertionError();
            }
        }
    }

    public ParcelFileDescriptor getFdByFileName(String str) {
        for (int i2 = 0; i2 < this.mLazilyLoadedLibraryNames.length; i2++) {
            CharSequence charSequence = this.mLazilyLoadedLibraryNames[i2];
            ParcelFileDescriptor parcelFileDescriptor = this.mLazilyLoadedLibraryFDs[i2];
            if (str.equals(charSequence)) {
                return parcelFileDescriptor;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0072 A[SYNTHETIC, Splitter:B:13:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007d A[SYNTHETIC, Splitter:B:19:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void displayLazilyLoadedLibraries() {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sandbox.ChildProcessService.displayLazilyLoadedLibraries():void");
    }

    private ParcelFileDescriptor getLazilyLoadedLibrary(String str) {
        for (int i2 = 0; i2 < this.mLazilyLoadedLibraryNames.length; i2++) {
            try {
                CharSequence charSequence = this.mLazilyLoadedLibraryNames[i2];
                ParcelFileDescriptor parcelFileDescriptor = this.mLazilyLoadedLibraryFDs[i2];
                if (str.equals(charSequence)) {
                    return parcelFileDescriptor;
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public boolean lazyLoadLibraryByName(String str) {
        try {
            i.a(str, getLazilyLoadedLibrary(str));
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
