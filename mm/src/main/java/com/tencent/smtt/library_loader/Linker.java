package com.tencent.smtt.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class Linker {
    protected static final int ADDRESS_SPACE_RESERVATION = 201326592;
    protected static final int BREAKPAD_GUARD_REGION_BYTES = 16777216;
    public static final int BROWSER_SHARED_RELRO_CONFIG = 1;
    public static final int BROWSER_SHARED_RELRO_CONFIG_ALWAYS = 2;
    public static final int BROWSER_SHARED_RELRO_CONFIG_LOW_RAM_ONLY = 1;
    public static final int BROWSER_SHARED_RELRO_CONFIG_NEVER = 0;
    protected static final boolean DEBUG = false;
    public static final String EXTRA_LINKER_SHARED_RELROS = "org.chromium.base.android.linker.shared_relros";
    private static final String LINKER_JNI_LIBRARY = "chromium_android_linker";
    public static final int MEMORY_DEVICE_CONFIG_INIT = 0;
    public static final int MEMORY_DEVICE_CONFIG_LOW = 1;
    public static final int MEMORY_DEVICE_CONFIG_NORMAL = 2;
    private static final String TAG = "Linker";
    private static Linker sSingleton = null;
    private static Object sSingletonLock = new Object();
    protected final Object mLock = new Object();

    private static native long nativeGetRandomBaseLoadAddress();

    public abstract void disableSharedRelros();

    public abstract void finishLibraryLoad();

    public abstract long getBaseLoadAddress();

    public abstract Bundle getSharedRelros();

    public abstract void initServiceProcess(long j2);

    public abstract boolean isUsingBrowserSharedRelros();

    public abstract String loadLibraryByFd(ParcelFileDescriptor parcelFileDescriptor, long j2, String str, int i2);

    /* access modifiers changed from: package-private */
    public abstract void loadLibraryImpl(String str, String str2, boolean z);

    public abstract void prepareLibraryLoad();

    public abstract void useSharedRelros(Bundle bundle);

    protected Linker() {
    }

    public static final Linker getInstance() {
        Linker linker;
        synchronized (sSingletonLock) {
            if (sSingleton == null) {
                sSingleton = LegacyLinker.create();
                new StringBuilder("Using linker: ").append(sSingleton.getClass().getName());
            }
            linker = sSingleton;
        }
        return linker;
    }

    protected static void loadLinkerJniLibrary() {
        System.loadLibrary(LINKER_JNI_LIBRARY);
    }

    /* access modifiers changed from: protected */
    public long getRandomBaseLoadAddress() {
        return nativeGetRandomBaseLoadAddress();
    }

    public void loadLibrary(String str, String str2) {
        loadLibraryImpl(str, str2, true);
    }

    public void loadLibraryNoFixedAddress(String str, String str2) {
        loadLibraryImpl(str, str2, false);
    }

    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = new Parcelable.Creator<LibInfo>() {
            /* class com.tencent.smtt.library_loader.Linker.LibInfo.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final LibInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(53826);
                LibInfo libInfo = new LibInfo(parcel);
                AppMethodBeat.o(53826);
                return libInfo;
            }

            @Override // android.os.Parcelable.Creator
            public final LibInfo[] newArray(int i2) {
                return new LibInfo[i2];
            }
        };
        public long mLoadAddress;
        public long mLoadSize;
        public int mRelroFd;
        public long mRelroSize;
        public long mRelroStart;

        public LibInfo() {
            this.mLoadAddress = 0;
            this.mLoadSize = 0;
            this.mRelroStart = 0;
            this.mRelroSize = 0;
            this.mRelroFd = -1;
        }

        public void close() {
            AppMethodBeat.i(53821);
            if (this.mRelroFd >= 0) {
                try {
                    ParcelFileDescriptor.adoptFd(this.mRelroFd).close();
                } catch (IOException e2) {
                }
                this.mRelroFd = -1;
            }
            AppMethodBeat.o(53821);
        }

        public LibInfo(Parcel parcel) {
            AppMethodBeat.i(53822);
            this.mLoadAddress = parcel.readLong();
            this.mLoadSize = parcel.readLong();
            this.mRelroStart = parcel.readLong();
            this.mRelroSize = parcel.readLong();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
            this.mRelroFd = parcelFileDescriptor == null ? -1 : parcelFileDescriptor.detachFd();
            AppMethodBeat.o(53822);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(53823);
            if (this.mRelroFd >= 0) {
                parcel.writeLong(this.mLoadAddress);
                parcel.writeLong(this.mLoadSize);
                parcel.writeLong(this.mRelroStart);
                parcel.writeLong(this.mRelroSize);
                try {
                    ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.mRelroFd);
                    fromFd.writeToParcel(parcel, 0);
                    fromFd.close();
                    AppMethodBeat.o(53823);
                    return;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(53823);
        }

        public int describeContents() {
            return 1;
        }

        static {
            AppMethodBeat.i(53825);
            AppMethodBeat.o(53825);
        }

        public String toString() {
            AppMethodBeat.i(53824);
            String format = String.format(Locale.US, "[load=0x%x-0x%x relro=0x%x-0x%x fd=%d]", Long.valueOf(this.mLoadAddress), Long.valueOf(this.mLoadAddress + this.mLoadSize), Long.valueOf(this.mRelroStart), Long.valueOf(this.mRelroStart + this.mRelroSize), Integer.valueOf(this.mRelroFd));
            AppMethodBeat.o(53824);
            return format;
        }
    }

    /* access modifiers changed from: protected */
    public Bundle createBundleFromLibInfoMap(HashMap<String, LibInfo> hashMap) {
        Bundle bundle = new Bundle(hashMap.size());
        for (Map.Entry<String, LibInfo> entry : hashMap.entrySet()) {
            bundle.putParcelable(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public HashMap<String, LibInfo> createLibInfoMapFromBundle(Bundle bundle) {
        HashMap<String, LibInfo> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, (LibInfo) bundle.getParcelable(str));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void closeLibInfoMap(HashMap<String, LibInfo> hashMap) {
        for (Map.Entry<String, LibInfo> entry : hashMap.entrySet()) {
            entry.getValue().close();
        }
    }
}
