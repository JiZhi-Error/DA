package io.flutter.embedding.engine.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class a {
    private static final String SOV = (a.class.getName() + '.' + "aot-shared-library-name");
    private static final String SOW = (a.class.getName() + '.' + "vm-snapshot-data");
    private static final String SOX = (a.class.getName() + '.' + "isolate-snapshot-data");
    private static final String SOY = (a.class.getName() + '.' + "flutter-assets-dir");
    private static a SPd;
    private String SOZ = "libapp.so";
    private String SPa = "vm_snapshot_data";
    private String SPb = "isolate_snapshot_data";
    public String SPc = "flutter_assets";
    public boolean SPe = false;
    public b SPf;
    private long SPg;
    Future<C2244a> SPh;

    public static class b {
        public String logTag;
    }

    static /* synthetic */ b hwU() {
        return null;
    }

    static {
        AppMethodBeat.i(215010);
        AppMethodBeat.o(215010);
    }

    public static a hwT() {
        AppMethodBeat.i(215002);
        if (SPd == null) {
            SPd = new a();
        }
        a aVar = SPd;
        AppMethodBeat.o(215002);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.a.a$a  reason: collision with other inner class name */
    public static class C2244a {
        final String SPn;
        final String SPo;
        final String SPp;

        /* synthetic */ C2244a(String str, String str2, String str3, byte b2) {
            this(str, str2, str3);
        }

        private C2244a(String str, String str2, String str3) {
            this.SPn = str;
            this.SPo = str2;
            this.SPp = str3;
        }
    }

    public final void startInitialization(Context context) {
        AppMethodBeat.i(215003);
        a(context, new b());
        AppMethodBeat.o(215003);
    }

    public final void a(Context context, b bVar) {
        AppMethodBeat.i(215004);
        if (this.SPf != null) {
            AppMethodBeat.o(215004);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("startInitialization must be called on the main thread");
            AppMethodBeat.o(215004);
            throw illegalStateException;
        } else {
            final Context applicationContext = context.getApplicationContext();
            this.SPf = bVar;
            this.SPg = SystemClock.uptimeMillis();
            lN(applicationContext);
            VsyncWaiter.getInstance((WindowManager) applicationContext.getSystemService("window")).init();
            this.SPh = Executors.newSingleThreadExecutor().submit(new Callable<C2244a>() {
                /* class io.flutter.embedding.engine.a.a.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ C2244a call() {
                    AppMethodBeat.i(215001);
                    C2244a hwV = hwV();
                    AppMethodBeat.o(215001);
                    return hwV;
                }

                private C2244a hwV() {
                    String path;
                    AppMethodBeat.i(215000);
                    a.hwU();
                    try {
                        System.loadLibrary("flutter");
                    } catch (Exception e2) {
                    }
                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        /* class io.flutter.embedding.engine.a.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(215014);
                            FlutterJNI.nativePrefetchDefaultFontManager();
                            AppMethodBeat.o(215014);
                        }
                    });
                    String path2 = applicationContext.getFilesDir().getPath();
                    Context context = applicationContext;
                    if (Build.VERSION.SDK_INT >= 21) {
                        path = context.getCodeCacheDir().getPath();
                    } else {
                        path = context.getCacheDir().getPath();
                    }
                    C2244a aVar = new C2244a(path2, path, io.flutter.a.a.lO(applicationContext), (byte) 0);
                    AppMethodBeat.o(215000);
                    return aVar;
                }
            });
            AppMethodBeat.o(215004);
        }
    }

    public final void ensureInitializationComplete(Context context, String[] strArr) {
        AppMethodBeat.i(215005);
        if (this.SPe) {
            AppMethodBeat.o(215005);
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            AppMethodBeat.o(215005);
            throw illegalStateException;
        } else if (this.SPf == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            AppMethodBeat.o(215005);
            throw illegalStateException2;
        } else {
            try {
                C2244a aVar = this.SPh.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                ApplicationInfo L = L(context);
                arrayList.add("--icu-native-lib-path=" + L.nativeLibraryDir + File.separator + "libflutter.so");
                if (strArr != null) {
                    Collections.addAll(arrayList, strArr);
                }
                arrayList.add("--aot-shared-library-name=" + this.SOZ);
                arrayList.add("--aot-shared-library-name=" + L.nativeLibraryDir + File.separator + this.SOZ);
                arrayList.add("--cache-dir-path=" + aVar.SPo);
                if (this.SPf.logTag != null) {
                    arrayList.add("--log-tag=" + this.SPf.logTag);
                }
                long uptimeMillis = SystemClock.uptimeMillis() - this.SPg;
                Bundle bundle = L.metaData;
                if (bundle != null && bundle.getBoolean("io.flutter.embedded_views_preview")) {
                    arrayList.add("--use-embedded-view");
                }
                FlutterJNI.nativeInit(context, (String[]) arrayList.toArray(new String[0]), null, aVar.SPn, aVar.SPo, uptimeMillis);
                this.SPe = true;
                AppMethodBeat.o(215005);
            } catch (Exception e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(215005);
                throw runtimeException;
            }
        }
    }

    private static ApplicationInfo L(Context context) {
        AppMethodBeat.i(215006);
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            AppMethodBeat.o(215006);
            return applicationInfo;
        } catch (PackageManager.NameNotFoundException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(215006);
            throw runtimeException;
        }
    }

    private void lN(Context context) {
        AppMethodBeat.i(215007);
        Bundle bundle = L(context).metaData;
        if (bundle == null) {
            AppMethodBeat.o(215007);
            return;
        }
        this.SOZ = bundle.getString(SOV, "libapp.so");
        this.SPc = bundle.getString(SOY, "flutter_assets");
        this.SPa = bundle.getString(SOW, "vm_snapshot_data");
        this.SPb = bundle.getString(SOX, "isolate_snapshot_data");
        AppMethodBeat.o(215007);
    }

    public final String getLookupKeyForAsset(String str, String str2) {
        AppMethodBeat.i(215008);
        String btd = btd("packages" + File.separator + str2 + File.separator + str);
        AppMethodBeat.o(215008);
        return btd;
    }

    public final String btd(String str) {
        AppMethodBeat.i(215009);
        String str2 = this.SPc + File.separator + str;
        AppMethodBeat.o(215009);
        return str2;
    }
}
