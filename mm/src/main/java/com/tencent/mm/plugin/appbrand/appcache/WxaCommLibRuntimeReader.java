package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.api.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

@Deprecated
public final class WxaCommLibRuntimeReader {
    private static volatile ICommLibReader kMh;
    private static Future<Object> kMi;
    private static final ThreadPoolExecutor kMj = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static {
        AppMethodBeat.i(90587);
        AppMethodBeat.o(90587);
    }

    private static ICommLibReader a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.i(90581);
        if (wxaPkgWrappingInfo.kNY) {
            AssetReader assetReader = AssetReader.kKj;
            AppMethodBeat.o(90581);
            return assetReader;
        }
        PkgReader pkgReader = new PkgReader(wxaPkgWrappingInfo);
        AppMethodBeat.o(90581);
        return pkgReader;
    }

    public static synchronized boolean b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        boolean z;
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(90582);
            ICommLibReader a2 = a(wxaPkgWrappingInfo);
            if (kMh == null || a2.compareTo(kMh) != 0) {
                kMh = a2;
                z = true;
                AppMethodBeat.o(90582);
            } else {
                z = false;
                AppMethodBeat.o(90582);
            }
        }
        return z;
    }

    public static synchronized void bvU() {
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(90583);
            try {
                vC();
                if (kMh == null) {
                    kMh = AssetReader.kKj;
                    AppMethodBeat.o(90583);
                }
            } catch (Throwable th) {
                if (kMh == null) {
                    kMh = AssetReader.kKj;
                }
                AppMethodBeat.o(90583);
                throw th;
            }
            AppMethodBeat.o(90583);
        }
    }

    public static synchronized void vC() {
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(90584);
            if (kMh != null) {
                Log.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", kMh);
                AppMethodBeat.o(90584);
            } else if (ay.bwe()) {
                kMh = AssetReader.kKj;
                Log.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
                AppMethodBeat.o(90584);
            } else if (!MMApplicationContext.isMMProcessExist()) {
                Log.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
                AccountNotReadyError accountNotReadyError = new AccountNotReadyError();
                AppMethodBeat.o(90584);
                throw accountNotReadyError;
            } else {
                try {
                    if (kMi != null) {
                        Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
                    } else {
                        Log.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
                        kMi = kMj.submit(new Callable<Object>() {
                            /* class com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.AnonymousClass1 */

                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                Object obj;
                                AppMethodBeat.i(90569);
                                try {
                                    Object a2 = XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class);
                                    AppMethodBeat.o(90569);
                                    obj = a2;
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e2, "load() ipc read lib", new Object[0]);
                                    AppMethodBeat.o(90569);
                                    obj = e2;
                                }
                                return obj;
                            }
                        });
                    }
                    Object obj = kMi.get(5, TimeUnit.SECONDS);
                    if (obj instanceof WxaPkgWrappingInfo) {
                        kMh = a((WxaPkgWrappingInfo) obj);
                        AppMethodBeat.o(90584);
                    } else if (obj instanceof AccountNotReadyError) {
                        AccountNotReadyError accountNotReadyError2 = (AccountNotReadyError) obj;
                        AppMethodBeat.o(90584);
                        throw accountNotReadyError2;
                    } else if (obj instanceof Exception) {
                        Exception exc = (Exception) obj;
                        AppMethodBeat.o(90584);
                        throw exc;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder("Unknown result ").append(null).toString() == obj ? BuildConfig.COMMAND : obj.getClass().getName());
                        AppMethodBeat.o(90584);
                        throw illegalArgumentException;
                    }
                } catch (Throwable th) {
                    kMi.cancel(false);
                    kMi = null;
                    AppMethodBeat.o(90584);
                    throw th;
                }
            }
        }
    }

    public static ICommLibReader bvV() {
        return kMh;
    }

    public static synchronized ICommLibReader bvW() {
        ICommLibReader iCommLibReader;
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(90585);
            if (kMh == null) {
                bvU();
            }
            iCommLibReader = kMh;
            AppMethodBeat.o(90585);
        }
        return iCommLibReader;
    }

    public static WxaPkgWrappingInfo bvX() {
        AppMethodBeat.i(90586);
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) bvW().bve();
        AppMethodBeat.o(90586);
        return wxaPkgWrappingInfo;
    }

    /* access modifiers changed from: package-private */
    public static final class AccountNotReadyError extends Error implements Parcelable {
        public static final Parcelable.Creator<AccountNotReadyError> CREATOR = new Parcelable.Creator<AccountNotReadyError>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.AccountNotReadyError.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AccountNotReadyError[] newArray(int i2) {
                return new AccountNotReadyError[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AccountNotReadyError createFromParcel(Parcel parcel) {
                AppMethodBeat.i(90570);
                AccountNotReadyError accountNotReadyError = new AccountNotReadyError((byte) 0);
                AppMethodBeat.o(90570);
                return accountNotReadyError;
            }
        };

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
        }

        AccountNotReadyError() {
        }

        AccountNotReadyError(byte b2) {
        }

        static {
            AppMethodBeat.i(90571);
            AppMethodBeat.o(90571);
        }
    }

    public static void bvY() {
        AppMethodBeat.i(184411);
        Assert.assertTrue(MMApplicationContext.isMainProcess());
        Log.i("MicroMsg.WxaCommLibRuntimeReader", "ensureLibReaderInMainProcess()");
        a aVar = new a();
        IPCVoid iPCVoid = IPCVoid.hnE;
        aVar.bvZ();
        AppMethodBeat.o(184411);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements k<IPCVoid, Object> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Object invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(90576);
            Object bvZ = bvZ();
            AppMethodBeat.o(90576);
            return bvZ;
        }

        public final Object bvZ() {
            ICommLibReader iCommLibReader;
            AppMethodBeat.i(90573);
            if (!g.aAf().hpY) {
                AccountNotReadyError accountNotReadyError = new AccountNotReadyError();
                AppMethodBeat.o(90573);
                return accountNotReadyError;
            }
            WxaPkgWrappingInfo bwa = bwa();
            if (bwa != null && bwa.kNY) {
                iCommLibReader = AssetReader.kKj;
                Log.i("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib use local pkg");
            } else if (bwa == null || TextUtils.isEmpty(bwa.pkgPath)) {
                iCommLibReader = AssetReader.kKj;
                Log.e("MicroMsg.WxaCommLibRuntimeReader", "IPC_ReadLib invalid PkgInfo=%s", bwa);
            } else {
                iCommLibReader = new PkgReader(bwa);
            }
            at.c(iCommLibReader);
            AppMethodBeat.o(90573);
            return bwa;
        }

        private WxaPkgWrappingInfo bwa() {
            AppMethodBeat.i(90574);
            if (!g.aAf().hpY) {
                AppMethodBeat.o(90574);
                return null;
            }
            WxaPkgWrappingInfo gG = gG(false);
            if (gG != null) {
                AppMethodBeat.o(90574);
                return gG;
            }
            WxaPkgWrappingInfo gG2 = gG(true);
            AppMethodBeat.o(90574);
            return gG2;
        }

        private WxaPkgWrappingInfo gG(boolean z) {
            AppMethodBeat.i(90575);
            Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> gJ = WxaPkgIntegrityChecker.gJ(z);
            if (gJ.first == WxaPkgIntegrityChecker.a.APP_BROKEN && gJ.second == null && !z) {
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(90572);
                        if (!g.aAf().hpY) {
                            AppMethodBeat.o(90572);
                            return;
                        }
                        try {
                            ((b) g.af(b.class)).gB(false);
                            AppMethodBeat.o(90572);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e2, "[NOT CRASH]", new Object[0]);
                            AppMethodBeat.o(90572);
                        }
                    }
                }, "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
            }
            if (gJ.second != null && ((WxaPkgWrappingInfo) gJ.second).kNW == 999) {
                ((WxaPkgWrappingInfo) gJ.second).pkgVersion = 0;
            }
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) gJ.second;
            AppMethodBeat.o(90575);
            return wxaPkgWrappingInfo;
        }
    }

    public static final class PkgReader extends AbsReader {
        public static final Parcelable.Creator<PkgReader> CREATOR = new Parcelable.Creator<PkgReader>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.PkgReader.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PkgReader[] newArray(int i2) {
                return new PkgReader[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PkgReader createFromParcel(Parcel parcel) {
                AppMethodBeat.i(184408);
                PkgReader pkgReader = new PkgReader((WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
                AppMethodBeat.o(184408);
                return pkgReader;
            }
        };
        private final WxaPkgWrappingInfo kKi;
        private final WxaPkg kMl;

        public PkgReader(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            AppMethodBeat.i(90577);
            this.kKi = wxaPkgWrappingInfo;
            this.kMl = new WxaPkg(wxaPkgWrappingInfo.pkgPath);
            AppMethodBeat.o(90577);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.o
        public final InputStream openRead(String str) {
            AppMethodBeat.i(90578);
            this.kMl.bvf();
            InputStream UR = this.kMl.UR(str);
            AppMethodBeat.o(90578);
            return UR;
        }

        public final String toString() {
            AppMethodBeat.i(90579);
            String format = String.format(Locale.US, "PkgReader[%d] [%s]", Integer.valueOf(this.kKi.pkgVersion), bvb());
            AppMethodBeat.o(90579);
            return format;
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public final void finalize() {
            AppMethodBeat.i(90580);
            super.finalize();
            try {
                this.kMl.close();
                AppMethodBeat.o(90580);
            } catch (Throwable th) {
                AppMethodBeat.o(90580);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(230561);
            try {
                this.kMl.close();
                AppMethodBeat.o(230561);
            } catch (Throwable th) {
                AppMethodBeat.o(230561);
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(184409);
            parcel.writeParcelable(this.kKi, i2);
            AppMethodBeat.o(184409);
        }

        static {
            AppMethodBeat.i(184410);
            AppMethodBeat.o(184410);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.o
        public final /* bridge */ /* synthetic */ IPkgInfo bve() {
            return this.kKi;
        }
    }
}
