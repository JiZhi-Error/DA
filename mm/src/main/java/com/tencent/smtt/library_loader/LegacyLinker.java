package com.tencent.smtt.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.library_loader.Linker;
import com.tencent.smtt.sandbox.ThreadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* access modifiers changed from: package-private */
public class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int BUFFER_SIZE = 1024;
    private static final String TAG = "LegacyLinker";
    static ArrayList<byte[]> buffered_read_data = new ArrayList<>();
    private long mBaseLoadAddress = -1;
    private boolean mBrowserUsesSharedRelro = false;
    private long mCurrentLoadAddress = -1;
    private boolean mInBrowserProcess = true;
    private boolean mInitialized = false;
    private HashMap<String, Linker.LibInfo> mLoadedLibraries = null;
    private boolean mPrepareLibraryLoadCalled = false;
    private Bundle mSharedRelros = null;
    private boolean mWaitForSharedRelros = false;

    private static native boolean nativeCreateSharedRelro(String str, long j2, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibrary(String str, long j2, Linker.LibInfo libInfo);

    private static native String nativeLoadLibraryByFd(ParcelFileDescriptor parcelFileDescriptor, long j2, String str, int i2);

    private static native boolean nativeLoadLibraryInZipFile(String str, String str2, long j2, Linker.LibInfo libInfo);

    private static native void nativeRunCallbackOnUiThread(long j2);

    private static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    static {
        boolean z;
        AppMethodBeat.i(53846);
        if (!LegacyLinker.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
        AppMethodBeat.o(53846);
    }

    static /* synthetic */ void access$000(long j2) {
        AppMethodBeat.i(53845);
        nativeRunCallbackOnUiThread(j2);
        AppMethodBeat.o(53845);
    }

    private LegacyLinker() {
    }

    static Linker create() {
        AppMethodBeat.i(53829);
        LegacyLinker legacyLinker = new LegacyLinker();
        AppMethodBeat.o(53829);
        return legacyLinker;
    }

    private void ensureInitializedLocked() {
        AppMethodBeat.i(53830);
        if (!$assertionsDisabled && !Thread.holdsLock(this.mLock)) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(53830);
            throw assertionError;
        } else if (this.mInitialized) {
            AppMethodBeat.o(53830);
        } else {
            loadLinkerJniLibrary();
            this.mInitialized = true;
            AppMethodBeat.o(53830);
        }
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public boolean isUsingBrowserSharedRelros() {
        boolean z;
        AppMethodBeat.i(53831);
        synchronized (this.mLock) {
            try {
                ensureInitializedLocked();
                z = this.mInBrowserProcess && this.mBrowserUsesSharedRelro;
            } finally {
                AppMethodBeat.o(53831);
            }
        }
        return z;
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public void prepareLibraryLoad() {
        AppMethodBeat.i(53832);
        synchronized (this.mLock) {
            try {
                ensureInitializedLocked();
                this.mPrepareLibraryLoadCalled = true;
                if (this.mInBrowserProcess) {
                    setupBaseLoadAddressLocked();
                }
            } finally {
                AppMethodBeat.o(53832);
            }
        }
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public void finishLibraryLoad() {
        AppMethodBeat.i(53833);
        synchronized (this.mLock) {
            try {
                ensureInitializedLocked();
                if (this.mLoadedLibraries != null) {
                    if (this.mInBrowserProcess) {
                        this.mSharedRelros = createBundleFromLibInfoMap(this.mLoadedLibraries);
                        if (this.mBrowserUsesSharedRelro) {
                            useSharedRelrosLocked(this.mSharedRelros);
                        }
                    }
                    if (this.mWaitForSharedRelros) {
                        if ($assertionsDisabled || !this.mInBrowserProcess) {
                            while (this.mSharedRelros == null) {
                                try {
                                    this.mLock.wait();
                                } catch (InterruptedException e2) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            useSharedRelrosLocked(this.mSharedRelros);
                            this.mSharedRelros.clear();
                            this.mSharedRelros = null;
                        } else {
                            AssertionError assertionError = new AssertionError();
                            AppMethodBeat.o(53833);
                            throw assertionError;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(53833);
            }
        }
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public void useSharedRelros(Bundle bundle) {
        AppMethodBeat.i(53834);
        Bundle bundle2 = null;
        if (bundle != null) {
            bundle.setClassLoader(Linker.LibInfo.class.getClassLoader());
            bundle2 = new Bundle(Linker.LibInfo.class.getClassLoader());
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            bundle2.readFromParcel(obtain);
            obtain.recycle();
        }
        synchronized (this.mLock) {
            try {
                this.mSharedRelros = bundle2;
                this.mLock.notifyAll();
            } finally {
                AppMethodBeat.o(53834);
            }
        }
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public void loadLibrary(String str, String str2) {
        AppMethodBeat.i(53835);
        super.loadLibrary(str, str2);
        AppMethodBeat.o(53835);
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public Bundle getSharedRelros() {
        Bundle bundle;
        synchronized (this.mLock) {
            if (!this.mInBrowserProcess) {
                bundle = null;
            } else {
                bundle = this.mSharedRelros;
            }
        }
        return bundle;
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public void disableSharedRelros() {
        AppMethodBeat.i(53836);
        synchronized (this.mLock) {
            try {
                ensureInitializedLocked();
                this.mInBrowserProcess = false;
                this.mWaitForSharedRelros = false;
                this.mBrowserUsesSharedRelro = false;
            } finally {
                AppMethodBeat.o(53836);
            }
        }
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public void initServiceProcess(long j2) {
        AppMethodBeat.i(53837);
        synchronized (this.mLock) {
            try {
                ensureInitializedLocked();
                this.mInBrowserProcess = false;
                this.mBrowserUsesSharedRelro = false;
                this.mWaitForSharedRelros = true;
                this.mBaseLoadAddress = j2;
                this.mCurrentLoadAddress = j2;
            } finally {
                AppMethodBeat.o(53837);
            }
        }
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public long getBaseLoadAddress() {
        long j2;
        AppMethodBeat.i(53838);
        synchronized (this.mLock) {
            try {
                ensureInitializedLocked();
                if (!this.mInBrowserProcess) {
                    j2 = 0;
                } else {
                    setupBaseLoadAddressLocked();
                    j2 = this.mBaseLoadAddress;
                    AppMethodBeat.o(53838);
                }
            } finally {
                AppMethodBeat.o(53838);
            }
        }
        return j2;
    }

    private void setupBaseLoadAddressLocked() {
        AppMethodBeat.i(53839);
        if ($assertionsDisabled || Thread.holdsLock(this.mLock)) {
            if (this.mBaseLoadAddress == -1) {
                this.mBaseLoadAddress = getRandomBaseLoadAddress();
                this.mCurrentLoadAddress = this.mBaseLoadAddress;
                if (this.mBaseLoadAddress == 0) {
                    this.mBrowserUsesSharedRelro = false;
                    this.mWaitForSharedRelros = false;
                }
            }
            AppMethodBeat.o(53839);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(53839);
        throw assertionError;
    }

    private void dumpBundle(Bundle bundle) {
    }

    private void useSharedRelrosLocked(Bundle bundle) {
        AppMethodBeat.i(53840);
        if (!$assertionsDisabled && !Thread.holdsLock(this.mLock)) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(53840);
            throw assertionError;
        } else if (bundle == null) {
            AppMethodBeat.o(53840);
        } else if (this.mLoadedLibraries == null) {
            AppMethodBeat.o(53840);
        } else {
            HashMap<String, Linker.LibInfo> createLibInfoMapFromBundle = createLibInfoMapFromBundle(bundle);
            for (Map.Entry<String, Linker.LibInfo> entry : createLibInfoMapFromBundle.entrySet()) {
                nativeUseSharedRelro(entry.getKey(), entry.getValue());
            }
            if (!this.mInBrowserProcess) {
                closeLibInfoMap(createLibInfoMapFromBundle);
            }
            AppMethodBeat.o(53840);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.smtt.library_loader.Linker
    public void loadLibraryImpl(String str, String str2, boolean z) {
        AppMethodBeat.i(53841);
        synchronized (this.mLock) {
            try {
                ensureInitializedLocked();
                if ($assertionsDisabled || this.mPrepareLibraryLoadCalled) {
                    if (this.mLoadedLibraries == null) {
                        this.mLoadedLibraries = new HashMap<>();
                    }
                    if (!this.mLoadedLibraries.containsKey(str2)) {
                        Linker.LibInfo libInfo = new Linker.LibInfo();
                        long j2 = 0;
                        if (z && ((this.mInBrowserProcess && this.mBrowserUsesSharedRelro) || this.mWaitForSharedRelros)) {
                            j2 = this.mCurrentLoadAddress;
                            if (j2 > this.mBaseLoadAddress + 201326592) {
                                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Load address outside reservation, for: ".concat(String.valueOf(str2)));
                                AppMethodBeat.o(53841);
                                throw unsatisfiedLinkError;
                            }
                        }
                        if (str != null) {
                            if (!nativeLoadLibraryInZipFile(str, str2, j2, libInfo)) {
                                UnsatisfiedLinkError unsatisfiedLinkError2 = new UnsatisfiedLinkError("Unable to load library: " + str2 + ", in: " + str);
                                AppMethodBeat.o(53841);
                                throw unsatisfiedLinkError2;
                            }
                        } else if (!nativeLoadLibrary(str2, j2, libInfo)) {
                            UnsatisfiedLinkError unsatisfiedLinkError3 = new UnsatisfiedLinkError("Unable to load library: ".concat(String.valueOf(str2)));
                            AppMethodBeat.o(53841);
                            throw unsatisfiedLinkError3;
                        } else {
                            str = str2;
                        }
                        if (this.mInBrowserProcess && !nativeCreateSharedRelro(str, this.mCurrentLoadAddress, libInfo)) {
                            String.format(Locale.US, "Could not create shared RELRO for %s at %x", str2, Long.valueOf(this.mCurrentLoadAddress));
                        }
                        if (!(j2 == 0 || this.mCurrentLoadAddress == 0)) {
                            this.mCurrentLoadAddress = libInfo.mLoadAddress + libInfo.mLoadSize + 16777216;
                        }
                        this.mLoadedLibraries.put(str, libInfo);
                        AppMethodBeat.o(53841);
                        return;
                    }
                    return;
                }
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(53841);
                throw assertionError;
            } finally {
                AppMethodBeat.o(53841);
            }
        }
    }

    public static void postCallbackOnMainThread(final long j2) {
        AppMethodBeat.i(53842);
        ThreadUtils.postOnUiThread(new Runnable() {
            /* class com.tencent.smtt.library_loader.LegacyLinker.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(53847);
                LegacyLinker.access$000(j2);
                AppMethodBeat.o(53847);
            }
        });
        AppMethodBeat.o(53842);
    }

    @Override // com.tencent.smtt.library_loader.Linker
    public String loadLibraryByFd(ParcelFileDescriptor parcelFileDescriptor, long j2, String str, int i2) {
        AppMethodBeat.i(53843);
        String nativeLoadLibraryByFd = nativeLoadLibraryByFd(parcelFileDescriptor, j2, str, i2);
        AppMethodBeat.o(53843);
        return nativeLoadLibraryByFd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d9, code lost:
        r2 = (r9 - r16) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        new java.lang.StringBuilder("[readLibraryByFd] -- @previous , refetch_previous_index: ").append(r5).append(", refetch_previous_index_inner: ").append(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f2, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0234, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:30:0x011a, B:53:0x01a6] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x014a A[Catch:{ Throwable -> 0x022a, all -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0160 A[Catch:{ Throwable -> 0x022a, all -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0234 A[ExcHandler: all (r2v31 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:30:0x011a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readLibraryByFd(android.os.ParcelFileDescriptor r15, int r16, int r17, boolean r18) {
        /*
        // Method dump skipped, instructions count: 594
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.library_loader.LegacyLinker.readLibraryByFd(android.os.ParcelFileDescriptor, int, int, boolean):byte[]");
    }
}
